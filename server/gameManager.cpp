#include "gameManager.h"

GameManager::GameManager() {
  messagesNew = new queue<Message*>;
  messagesToSend = new queue<Message*>;
  tables = new vector<Table*>;
  newPlayers = new vector<Player*>;
}

GameManager::~GameManager() {
  delete messagesNew;
  delete messagesToSend;
  delete tables;
  delete newPlayers;
}

void GameManager::update() {
  Message *msg;

  while (!messagesNew->empty()) {
    msg = messagesNew->front();
    interpretMessage(msg);
    messagesNew->pop();
    delete msg;
  }
}

void GameManager::interpretMessage(Message* msg) {
  printf("gameManager.cpp: Interpreted message is: %s.\n", msg->getMessage());
  try {
    MessageType msgType = msg->getMessageType();
    printf("gameManager.cpp: Message %d - %s.\n", msgType, messageTypesNames[(int)msgType].c_str());
  } catch (char const* error) {
    printf("%s\n", error);
  }
}

int GameManager::getReceiverID() {
  if (messagesToSend->empty())
    return -1;

  return messagesToSend->front()->getReceiverID();
}

char* GameManager::getMessage() {
  Message* message;
  const char* msg;
  char* msgFinal;

  if (messagesToSend->empty())
    return NULL;

  message = messagesToSend->front();
  msg = message->getMessage();
  messagesToSend->pop();
  delete message;

  msgFinal = (char*)malloc(strlen(msg)+1);
  strcpy(msgFinal, msg);
  return msgFinal;
}

void GameManager::addMessage(char* newMessage, int sender) {
  messagesNew->push(new Message(newMessage, sender, -1));
  printf("gameManager.cpp: Received message from client with ID %d: %s.\n", sender, newMessage);
}

void GameManager::addPlayer(int ID) {
  newPlayers->push_back(new Player(ID, PlayerState::fresh));
}
