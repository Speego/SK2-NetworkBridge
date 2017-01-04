#include "message.h"

Message::Message(char* newMsg, int sender, int receiver) {
  msg = new string(newMsg);
  senderID = sender;
  receiverID = receiver;
  printf("message.cpp: Message created: %s.\n", newMsg);
}

Message::~Message() {
  delete msg;
}

const char* Message::getMessage() {
  return (*msg).c_str();
}

int Message::getSenderID() {
  return senderID;
}

int Message::getReceiverID() {
  return receiverID;
}
