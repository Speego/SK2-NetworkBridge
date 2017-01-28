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
  string message = *msg + "\n";
  return message.c_str();
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

int Message::getBidSuit() {
  string s = getMsgAfterColon();
  s = s.substr(0,1);
  if (s == "N") return 4;
  if (s == "S") return 3;
  if (s == "H") return 2;
  if (s == "D") return 1;
  if (s == "C") return 0;
  return -1;
}

int Message::getBidHeight() {
  string s = getMsgAfterColon();
  s = s.substr(1,1);
  if (s == "") return -1;
  return convertToNumber(s);
}

int Message::getCardSuit() {
  return getBidOrCardSuit();
}

int Message::getCardType() {
  return getBidHeightOrCardType();
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

int Message::getBidOrCardSuit() {
  try {
    string s = getMsgAfterColon();
    s = s.substr(0,2);
    return convertToNumber(s);
  } catch (char const* notNumber) {
    return -1;
  } catch (const std::out_of_range& oor) {
    return -1;
  }
}

int Message::getBidHeightOrCardType() {
  try {
    string s = getMsgAfterColon();
    s = s.substr(3,2);
    return convertToNumber(s);
  } catch (char const* notNumber) {
    return -1;
  } catch (const std::out_of_range& oor) {
    return -1;
  }
}
