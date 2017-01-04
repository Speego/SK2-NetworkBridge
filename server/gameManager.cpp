#include "gameManager.h"

GameManager::GameManager() {
  messagesNew = new queue<Message*>;
  messagesToSend = new queue<Message*>;
}

GameManager::~GameManager() {
  delete messagesNew;
  delete messagesToSend;
}

void GameManager::update() {

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
  printf("Received message from client with ID %d: %s.\n", sender, newMessage);
}
