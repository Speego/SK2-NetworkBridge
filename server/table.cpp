#include "table.h"

Table::Table(int ID, Player* player) {
  id = ID;
  players = new vector<Player*>();
  players->push_back(player);
  state = TableState::WAITING;
  cards = new vector<Card*>();
}

Table::~Table() {
  players->clear();
  cards->clear();
  delete players;
  delete cards;
}

int Table::getNumberOfPlayers() {
  return (int)players->size();
}

int Table::findPlayer(int clientID) {
  int numberOfPlayers = getNumberOfPlayers();
  for (int i=0; i<numberOfPlayers; i++) {
    if ((*players)[i]->id == clientID)
      return i;
  }
  string ex = "table.cpp: No player with ID " + to_string(clientID);
  throw ex;
}

void Table::removePlayer(int playerID) {
  try {
    int playerVectorPosition = this->findPlayer(playerID);
    players->erase(players->begin() + playerVectorPosition);
    printf("table.cpp: Player with ID %d removed. Number of players at table: %d.\n", playerID, (int)players->size());
  } catch(char const* noPlayer) {
    printf("%s\n", noPlayer);
  }
}

void Table::join(Player* player) {
  players->push_back(player);
  if (getNumberOfPlayers() == 4)
    state = TableState::READY;
}

bool Table::canJoin(int playerID) {
  if (getNumberOfPlayers() < 4 && !playerAtTable(playerID) && state == TableState::WAITING)
    return true;
  return false;
}

bool Table::playerAtTable(int playerID) {
  int numberOfPlayers = getNumberOfPlayers();
  for (int i=0; i<numberOfPlayers; i++) {
    if ((*players)[i]->id == playerID)
      return true;
  }
  return false;
}

void Table::createCards() {
  generateCards();
  randomShuffle();
  dealCards();
}

void Table::generateCards() {
  CardType type;
  CardSuit suit;
  cards->clear();

  for (int i=0; i<4; i++) {
    suit = CardSuit(i);
    for (int j=2; j<15; j++) {
      type = CardType(j);
      cards->push_back(new Card(suit, type));
    }
  }
}

void Table::randomShuffle() {
  for (int i=(int)cards->size()-1; i>0; i--)
    swap((*cards)[i], (*cards)[rand()%i]);
}

void Table::dealCards() {
  for (int i=0; i<(int)players->size(); i++) {
    (*players)[i]->resetCards();
    for (int j=0; j<13; j++)
      (*players)[i]->insertCard((*cards)[i*13+j]);

    (*players)[i]->sortCards();
  }
}

string Table::getCardsOfPlayer(int playerVectorPosition) {
  return (*players)[playerVectorPosition]->getCardsMessage();
}

int Table::getPlayerID(int playerVectorPosition) {
  return (*players)[playerVectorPosition]->id;
}

void Table::prepareForBidding() {
  numberOfPlayersResponses = 0;
  currentPlayer = 0;
  bidWinner = 0;
  trumpsHeight = 0;
  trumpsSuit = CardSuit::NONE;
  state = TableState::BIDDING_ON;
}

int Table::getBidderID() {
  return (*players)[currentPlayer]->id;
}

bool Table::isBidCorrect(CardSuit suit, int height) {
  int suitNumber = (int)suit;

  if (suit == CardSuit::NONE)
    return true;
  if ((height > 0) && (height < 8) && (height > trumpsHeight)) {
    if ((suitNumber >= 0) && (suitNumber <= 4))
      return true;
    return false;
  }
  if ((height == trumpsHeight) && (height <= 4) && (height > (int)trumpsSuit))
    return true;
  return false;
}

void Table::bid(CardSuit suit, int height) {
  numberOfPlayersResponses++;
  if (suit == CardSuit::NONE) {
    playerPasses();
  } else {
    trumpsSuit = suit;
    trumpsHeight = height;
    bidWinner = currentPlayer;
    numberOfPasses = 0;
  }
}

int Table::getNotCurrentPlayerID(int shift) {
  return (*players)[(currentPlayer + shift) % getNumberOfPlayers()]->id;
}

void Table::playerPasses() {
  numberOfPasses++;
}

void Table::changeTurn() {
  currentPlayer = (currentPlayer + 1) % getNumberOfPlayers();
}

bool Table::biddingOver() {
  if (numberOfPasses > 4)
    return true;
  if ((numberOfPasses == 3) && (numberOfPlayersResponses > 3))
    return true;
  return false;
}

int Table::getPlayerIDByBidding(BiddingResult br) {
  return (*players)[(bidWinner + (int)br) % getNumberOfPlayers()]->id;
}

void Table::setPlayerGameType(BiddingResult br) {
  (*players)[(bidWinner + (int)br) % getNumberOfPlayers()]->gamePlayerType = (GamePlayerType)((int)br);
}

void Table::prepareForGame() {
  state = TableState::GAME_ON;
  currentPlayer = (bidWinner + 1) % getNumberOfPlayers();
  winSuit = CardSuit::NONE;
  winType = CardType::NONE;
  firstSuit = CardSuit::NONE;
  declarerScore = 0;
  roundWinner = -1;
  cardCounter = 0;
  roundCounter = 0;
  dummyPlaying = false;
}

int Table::getCurrentPlayerID() {
  return (*players)[currentPlayer]->id;
}

bool Table::isPlayerTurn(int playerID) {
  if ((*players)[currentPlayer]->id == playerID)
    return true;
  return false;
}

bool Table::isCardCorrect(CardSuit suit, CardType type, int playerID) {
  if (state != TableState::GAME_ON)
    return false;

  try {
    int playerVectorPosition = this->findPlayer(playerID);
    if (cardWithWrongSuit(suit) || cardWithWrongType(type))
      return false;

    if ((*players)[playerVectorPosition]->hasCard(suit, type)) {
      if (isCardFirst()) {
        return true;
      } else if ((*players)[playerVectorPosition]->hasSuit(firstSuit)) {
        if (firstSuit == suit)
          return true;
      } else {
        return true;
      }
    }

    return false;
  } catch(const char* noPlayer) {
    return false;
  }
}

bool Table::cardWithWrongSuit(CardSuit suit) {
  if (((int)suit < (int)CardSuit::CLUBS) || ((int)suit > (int)CardSuit::SPADES))
    return true;
  return false;
}

bool Table::cardWithWrongType(CardType type) {
  if (((int)type < (int)CardType::TWO) || ((int)type > (int)CardType::ACE))
    return true;
  return false;
}

bool Table::isCardFirst() {
  return (firstSuit == CardSuit::NONE);
}

void Table::playCard(CardSuit suit, CardType type) {
  cardCounter++;
  (*players)[currentPlayer]->removeCard(suit, type);
  if (isCardFirst())
    firstSuit = suit;
  if (isCardWinning(suit, type)) {
    roundWinner = currentPlayer;
    winSuit = suit;
    winType = type;
  }
}

bool Table::isCardWinning(CardSuit suit, CardType type) {
  if (isCardFirst())
    return true;
  if (suit == winSuit) {
    if ((int)type > (int)winType)
      return true;
  } else if ((winSuit != trumpsSuit) && (suit == trumpsSuit)) {
    return true;
  }
  return false;
}

bool Table::roundOver() {
  return (cardCounter == 4);
}

GamePlayerType Table::getRoundWinner() {
  return (*players)[roundWinner]->gamePlayerType;
}

void Table::endRound() {
  GamePlayerType typeOfWinner = (*players)[roundWinner]->gamePlayerType;
  if ((typeOfWinner == GamePlayerType::DECLARER) || (typeOfWinner == GamePlayerType::DUMMY))
    declarerScore++;

  firstSuit = CardSuit::NONE;
  winType = CardType::NONE;
  firstSuit = CardSuit::NONE;
  cardCounter = 0;
  roundCounter++;
  currentPlayer = roundWinner;
  roundWinner = -1;
}

bool Table::gameOver() {
  return (roundCounter == 13);
}

GameResult Table::getGameResult() {
  if (declarerScore >= (6 + trumpsHeight))
    return GameResult::WON;
  return GameResult::LOST;
}

int Table::getScore() {
  return declarerScore;
}
