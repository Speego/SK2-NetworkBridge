#include "message.h"

Message::Message(char* newMsg, int sender, int receiver) {
  msg = new string(newMsg);
  senderID = sender;
  receiverID = receiver;
  printf("\nmessage.cpp: Message created: %s\n", newMsg);
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

MessageType Message::getMessageType() {
  try {
    int msgNumber = convertToNumber();
    return (MessageType)msgNumber;
  } catch (char const* error) {
    if (isNull())
      return MessageType::DISCONNECTED;
    throw error;
  }
}

int Message::convertToNumber() {
  string* s = new string();
  int num;
  try {
    (*s) = msg->substr(0,2);
    num = stoi(*s, nullptr);
  } catch (const std::invalid_argument& ia) {
    delete s;
    throw "message.cpp: ERROR, wrong message type.";
  } catch (const std::out_of_range& oor) {
    delete s;
    throw "message.cpp: ERROR, wrong message type.";
  }
  delete s;
  return num;
}

bool Message::isNull() {
  return (*msg) == "";
}

string Message::getPlayerName() {
  return msg->substr(3);
}
