#include "gameManager.h"

GameManager::GameManager() {
  messagesNew = new queue<Message*>;
  messagesToSend = new queue<Message*>;
  tables = new vector<Table*>;
  players = new vector<Player*>;
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
  printf("gameManager.cpp: Interpreted message is: %s\n", msg->getMessage());
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

    default: break;
  }
}

int GameManager::findPlayer(int clientID) {
  for(int i=0; i<(int)players->size(); i++) {
    if ((*players)[i]->id == clientID)
      return i;
  }
  throw "gameManager.cpp: No player with ID " + clientID;
}

void GameManager::removePlayer(int clientID) {
  try {
    int playerVectorPosition = findPlayer(clientID);
    players->erase(players->begin() + playerVectorPosition);
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
  for (int i=0; i<(int)tables->size(); i++)
    msg += to_string((*tables)[i]->getNumberOfPlayers()) + ",";
  addMessageToSend(convertConstChar(msg.c_str()), receiver);
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
