#ifndef MESSAGE_H
#define MESSAGE_H

#include <stdio.h>
#include <string>
#include <stdexcept>

using std::string;
using std::stoi;

enum class MessageType {
  DISCONNECTED = 0,
  NICKNAME = 1,
  SEND_TABLES = 2,
  CREATE_TABLE = 3,
  JOIN_TABLE = 4,
  CARDS = 5
};

class Message {
private:
  string* msg;
  int senderID;
  int receiverID;

public:
  Message(char*, int, int);
  ~Message();

  const char* getMessage();
  int getSenderID();
  int getReceiverID();
  MessageType getMessageType();
  string getPlayerName();
  int getTableToJoin();

private:
  int convertToNumber(string);
  bool isNull();
  string getMsgAfterColon();
};

#endif // MESSAGE_H
