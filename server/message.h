#ifndef MESSAGE_H
#define MESSAGE_H

#include <stdio.h>
#include <string>

using std::string;

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
};

#endif // MESSAGE_H
