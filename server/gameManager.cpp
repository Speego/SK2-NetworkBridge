#include "gameManager.h"

GameManager::GameManager() {
  messagesNew = new queue<Message*>;
  messagesToSend = new queue<Message*>;
  tables = new vector<Table*>;
  players = new vector<Player*>;
  tablesID = 0;
}

GameManager::~GameManager() {
  delete messagesNew;
  delete messagesToSend;
  delete tables;
  delete players;
}

void GameManager::update() {
  Message *msg;

  while (!messagesNew->empty()) {
    msg = messagesNew->front();
    try {
      interpretMessage(msg);
    } catch (char const* wrongType) {
      printf("%s\n", wrongType);
    }
    messagesNew->pop();
    delete msg;
  }
}

void GameManager::interpretMessage(Message* msg) {
  printf("\ngameManager.cpp: Interpreted message is: %s\n", msg->getMessage());
  try {
    MessageType msgType = msg->getMessageType();
    if ((int)msgType >= (int)messageTypesNames.size())
      throw "gameManager.cpp: Number of message is out of range.";
    printf("gameManager.cpp: Message %d - %s.\n", msgType, messageTypesNames[(int)msgType].c_str());
    chooseTask(msg, msgType);
  } catch (char const* error) {
    printf("%s\n", error);
  }
}

void GameManager::chooseTask(Message* msg, MessageType msgType) {
  int senderID = msg->getSenderID();

  switch(msgType) {
    case MessageType::DISCONNECTED:
      removePlayer(senderID);
      break;
    case MessageType::NICKNAME:
      setPlayerName(msg, senderID);
      createTablesMessage(senderID, MessageType::SEND_TABLES);
      break;
    case MessageType::CREATE_TABLE:
      createTable(senderID);
      break;
    case MessageType::JOIN_TABLE:
      joinTable(senderID, msg);
      break;
    case MessageType::GIVEN_BID:
      manageGivenBidMessage(msg);
      break;
    case MessageType::GIVEN_CARD:
      manageGivenCardMessage(msg);
      break;
    default: break;
  }
}

int GameManager::findPlayer(int clientID) {
  for (int i=0; i<(int)players->size(); i++) {
    if ((*players)[i]->id == clientID)
      return i;
  }
  throw "gameManager.cpp: No player with ID " + clientID;
}

int GameManager::findTable(int tableID) {
  for (int i=0; i<(int)tables->size(); i++) {
    if ((*tables)[i]->id == tableID)
      return i;
  }
  throw "gameManager.cpp: No table with ID " + tableID;
}

void GameManager::updateTables() {
  for (int i=0; i<(int)tables->size(); i++) {
    if ((*tables)[i]->state == TableState::READY) {
      (*tables)[i]->createCards();
      createCardsMessages(i);
      (*tables)[i]->prepareForBidding();
      createBidPromptMessage(i);
    }
  }
}

void GameManager::createBidPromptMessage(int tableVectorPosition) {
  string msg = convertNumberToString((int)MessageType::START_BID) + ":";
  int receiver = (*tables)[tableVectorPosition]->getBidderID();
  addMessageToSend(convertConstChar(msg.c_str()), receiver);
}

void GameManager::removePlayer(int clientID) {
  try {
    int playerVectorPosition = findPlayer(clientID);
    int tableVectorPosition = findTable((*players)[playerVectorPosition]->tableID);
    players->erase(players->begin() + playerVectorPosition);
    (*tables)[tableVectorPosition]->removePlayer(clientID);
    if ((*tables)[tableVectorPosition]->getNumberOfPlayers() == 0)
      tables->erase(tables->begin() + tableVectorPosition);
    printf("gameManager.cpp: Player with ID %d removed. Number of players: %d.\n", clientID, (int)players->size());
  } catch(char const* noPlayer) {
    printf("%s\n", noPlayer);
  }
}

void GameManager::setPlayerName(Message* msg, int clientID) {
  try {
    int playerVectorPosition = findPlayer(clientID);
    (*players)[playerVectorPosition]->setName(msg);
  } catch (char const* noPlayer) {
    printf("%s\n", noPlayer);
  }
}

void GameManager::createTablesMessage(int receiver, MessageType msgType) {
  string msg = convertNumberToString(int(msgType));
  msg += ":";
  for (int i=0; i<(int)tables->size(); i++) {
    msg += to_string((*tables)[i]->id) + '-';
    msg += to_string((*tables)[i]->getNumberOfPlayers()) + ",";
  }
  addMessageToSend(convertConstChar(msg.c_str()), receiver);
}

void GameManager::createTable(int playerID) {
  try {
    int playerVectorPosition = findPlayer(playerID);
    (*players)[playerVectorPosition]->tableID = tablesID;
    (*players)[playerVectorPosition]->state = PlayerState::waitingAtTable;
    Player* player = (*players)[playerVectorPosition];
    tables->push_back(new Table(tablesID, player));
    printf("gameManager.cpp: Created new table with ID %d with player ID %d.\n", tablesID, player->id);
    tablesID++;
  } catch(char const* noPlayer) {
    printf("%s\n", noPlayer);
  }
}

void GameManager::joinTable(int playerID, Message* msg) {
  try {
    int tableID = msg->getTableToJoin();
    int tableVectorPosition = findTable(tableID);
    if ((*tables)[tableVectorPosition]->canJoin(playerID)) {
      int playerVectorPosition = findPlayer(playerID);
      (*players)[playerVectorPosition]->state = PlayerState::waitingAtTable;
      Player* player = (*players)[playerVectorPosition];
      (*tables)[tableVectorPosition]->join(player);
    } else
      printf("gameManager.cpp: Player with ID %d can't join table ID %d!\n", playerID, tableID);
  } catch (char const* notNumber) {
    printf("%s\n", notNumber);
  } catch (string noTable) {
    printf("%s\n", noTable.c_str());
  }
}

void GameManager::createCardsMessages(int tableVectorPosition) {
  string msg;
  int receiver;
  int numberOfPlayers = (*tables)[tableVectorPosition]->getNumberOfPlayers();
  for (int i=0; i<numberOfPlayers; i++) {
    msg = convertNumberToString((int)MessageType::CARDS) + ":";
    msg += (*tables)[tableVectorPosition]->getCardsOfPlayer(i);
    receiver = (*tables)[tableVectorPosition]->getPlayerID(i);
    addMessageToSend(convertConstChar(msg.c_str()), receiver);
  }
}

void GameManager::manageGivenBidMessage(Message* msg) {
  CardSuit suit = (CardSuit)msg->getBidSuit();
  int trumpsHeight = msg->getBidHeight();

  int sender = msg->getSenderID();
  int playerVectorPosition = findPlayer(sender);
  int tableID = (*players)[playerVectorPosition]->tableID;
  int tableVectorPosition = findTable(tableID);

  if ((*tables)[tableVectorPosition]->isPlayerTurn(sender)) {
    if ((*tables)[tableVectorPosition]->isBidCorrect(suit, trumpsHeight)) {
      (*tables)[tableVectorPosition]->bid(suit, trumpsHeight);
      sendGivenBidToOthers(tableVectorPosition, suit, trumpsHeight);
      if ((*tables)[tableVectorPosition]->biddingOver()) {
        sendEndOfBidding(tableVectorPosition);
        (*tables)[tableVectorPosition]->prepareForGame();
        createPlayCardPromptMessage(tableVectorPosition);
      } else {
        (*tables)[tableVectorPosition]->changeTurn();
        createBidPromptMessage(tableVectorPosition);
      }
    } else {
      createBidPromptMessage(tableVectorPosition);
    }
  }
}

void GameManager::sendGivenBidToOthers(int tableVectorPosition, CardSuit suit, int height) {
  string msg = convertNumberToString((int)MessageType::SEND_BID) + ":";
  msg += convertNumberToString((*tables)[tableVectorPosition]->getBidderID()) + "-";
  msg += convertNumberToString((int)suit) + "-" + convertNumberToString(height);
  int numberOfPlayers = (*tables)[tableVectorPosition]->getNumberOfPlayers();
  int receiver;
  for (int i=1; i<numberOfPlayers; i++) {
    receiver = (*tables)[tableVectorPosition]->getNotCurrentPlayerID(i);
    addMessageToSend(convertConstChar(msg.c_str()), receiver);
  }
}

void GameManager::sendEndOfBidding(int tableVectorPosition) {
// <BIDDING_RESULT>:<BiddingResult (enum number)>
  string msg;
  int numberOfPlayers = (*tables)[tableVectorPosition]->getNumberOfPlayers();
  int receiver;
  for (int i=0; i<numberOfPlayers; i++) {
    (*tables)[tableVectorPosition]->setPlayerGameType((BiddingResult)i);
    msg = convertNumberToString((int)MessageType::BIDDING_RESULT) + ":" + convertNumberToString(i);
    receiver = (*tables)[tableVectorPosition]->getPlayerIDByBidding((BiddingResult)i);
    addMessageToSend(convertConstChar(msg.c_str()), receiver);
  }
}

void GameManager::createPlayCardPromptMessage(int tableVectorPosition) {
// <PLAY_CARD>:
  string msg = convertNumberToString((int)MessageType::PLAY_CARD) + ":";
  int receiver = (*tables)[tableVectorPosition]->getCurrentPlayerID();
  addMessageToSend(convertConstChar(msg.c_str()), receiver);
}

void GameManager::manageGivenCardMessage(Message* msg) {
  CardSuit suit = (CardSuit)msg->getCardSuit();
  CardType type = (CardType)msg->getCardType();

  int sender = msg->getSenderID();
  int playerVectorPosition = findPlayer(sender);
  int tableID = (*players)[playerVectorPosition]->tableID;
  int tableVectorPosition = findTable(tableID);

  if ((*tables)[playerVectorPosition]->isPlayerTurn(sender)) {
    if ((*tables)[tableVectorPosition]->isCardCorrect(suit, type, sender)) {
      (*tables)[tableVectorPosition]->playCard(suit, type);
      sendGivenCardToOthers(tableVectorPosition, suit, type);
      if ((*tables)[tableVectorPosition]->roundOver()) {
        sendEndOfRound(tableVectorPosition);
        (*tables)[tableVectorPosition]->endRound();
        if ((*tables)[tableVectorPosition]->gameOver()) {
          sendEndOfRound(tableVectorPosition);
          // if yes, sum up game
        } else {
          createPlayCardPromptMessage(tableVectorPosition);
        }
      } else {
        (*tables)[tableVectorPosition]->changeTurn();
        createPlayCardPromptMessage(tableVectorPosition);
      }

    } else {
      createPlayCardPromptMessage(tableVectorPosition);
    }
  }
}

void GameManager::sendGivenCardToOthers(int tableVectorPosition, CardSuit suit, CardType type) {
  string msg = convertNumberToString((int)MessageType::SEND_CARD) + ":";
  msg += convertNumberToString((*tables)[tableVectorPosition]->getCurrentPlayerID()) + "-";
  msg += convertNumberToString((int)suit) + "-" + convertNumberToString((int)type);
  int numberOfPlayers = (*tables)[tableVectorPosition]->getNumberOfPlayers();
  int receiver;
  for (int i=1; i<numberOfPlayers; i++) {
    receiver = (*tables)[tableVectorPosition]->getNotCurrentPlayerID(i);
    addMessageToSend(convertConstChar(msg.c_str()), receiver);
  }
}

void GameManager::sendEndOfRound(int tableVectorPosition) {
// <ROUND_OVER>:<GamePlayerType (enum number) who won round>
  string msg = convertNumberToString((int)MessageType::ROUND_OVER) + ":";
  msg += convertNumberToString((int)((*tables)[tableVectorPosition]->getRoundWinner()));
  int numberOfPlayers = (*tables)[tableVectorPosition]->getNumberOfPlayers();
  int receiver;
  for (int i=0; i<numberOfPlayers; i++) {
    receiver = (*tables)[tableVectorPosition]->getPlayerID(i);
    addMessageToSend(convertConstChar(msg.c_str()), receiver);
  }
}

void GameManager::sendEndOfGame(int tableVectorPosition) {
// <GAME_RESULT>:<GameResult (enum number)>-<number of tricks taken>
  string msg = convertNumberToString((int)MessageType::GAME_RESULT) + ":";
  msg += convertNumberToString((int)(*tables)[tableVectorPosition]->getGameResult()) + '-';
  msg += convertNumberToString((*tables)[tableVectorPosition]->getScore());
  int numberOfPlayers = (*tables)[tableVectorPosition]->getNumberOfPlayers();
  int receiver;
  for (int i=0; i<numberOfPlayers; i++) {
    receiver = (*tables)[tableVectorPosition]->getPlayerID(i);
    addMessageToSend(convertConstChar(msg.c_str()), receiver);
  }
}

void GameManager::removeTable(int tableVectorPosition) {
  tables->erase(tables->begin() + tableVectorPosition);
}

int GameManager::getReceiverID() {
  if (messagesToSend->empty())
    return -1;

  return messagesToSend->front()->getReceiverID();
}

char* GameManager::getMessage() {
  Message* message;
  const char* msg;

  if (messagesToSend->empty())
    return NULL;

  message = messagesToSend->front();
  msg = message->getMessage();
  messagesToSend->pop();
  delete message;

  return convertConstChar(msg);
}

void GameManager::addMessage(char* newMessage, int sender) {
  messagesNew->push(new Message(newMessage, sender, -1));
  printf("gameManager.cpp: Received message from client with ID %d: %s\n", sender, newMessage);
}

void GameManager::addPlayer(int ID) {
  players->push_back(new Player(ID, PlayerState::fresh));
}

void GameManager::addMessageToSend(char* msg, int receiver) {
  messagesToSend->push(new Message(msg, -1, receiver));
}

string GameManager::convertNumberToString(int number) {
  if (number < 10)
    return "0" + to_string(number);
  return to_string(number);
}

char* GameManager::convertConstChar(const char* str) {
  char* strFinal = (char*)malloc(strlen(str)+1);
  strcpy(strFinal, str);
  return strFinal;
}
