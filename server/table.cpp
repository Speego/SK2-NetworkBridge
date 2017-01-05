#include "table.h"

Table::Table(int ID, Player* player) {
  id = ID;
  players = new vector<Player*>();
  players->push_back(player);
  state = TableState::WAITING;
  cards = new vector<Card*>();
}

Table::~Table() {
  for (int i=0; i<getNumberOfPlayers(); i++)
    delete (*players)[i];
  delete players;
  for (int i=0; i<(int)cards->size(); i++)
    delete (*cards)[i];
  delete cards;
}

int Table::getNumberOfPlayers() {
  return (int)players->size();
}

int Table::findPlayer(int clientID) {
  for (int i=0; i<(int)players->size(); i++) {
    if ((*players)[i]->id == clientID)
      return i;
  }
  throw "table.cpp: No player with ID " + clientID;
}

void Table::removePlayer(int playerID) {
  try {
    int playerVectorPosition = findPlayer(playerID);
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
  try {
    findPlayer(playerID);
    return true;
  } catch (string noPlayer) {
    return false;
  }
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
  }
}
