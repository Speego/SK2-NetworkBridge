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
    string s;
    s = msg->substr(0,2);
    int msgNumber = convertToNumber(s);
    return (MessageType)msgNumber;
  } catch (char const* error) {
    if (isNull())
      return MessageType::DISCONNECTED;
    throw error;
  }
}

string Message::getPlayerName() {
  return getMsgAfterColon();
}

int Message::getTableToJoin() {
  try {
    int id;
    string strID = getMsgAfterColon();
    id = convertToNumber(strID);
    return id;
  } catch (char const* notNumber) {
    throw notNumber;
  }
}

string Message::getMsgAfterColon() {
  return msg->substr(3);
}

int Message::convertToNumber(string s) {
  int num;
  try {
    num = stoi(s, nullptr);
  } catch (const std::invalid_argument& ia) {
    throw "message.cpp: ERROR, wrong message type.";
  } catch (const std::out_of_range& oor) {
    throw "message.cpp: ERROR, wrong message type.";
  }
  return num;
}

bool Message::isNull() {
  return (*msg) == "";
}
