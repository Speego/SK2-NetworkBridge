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
  JOIN_TABLE = 2
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

private:
  int convertToNumber();
  bool isNull();
};

#endif // MESSAGE_H
