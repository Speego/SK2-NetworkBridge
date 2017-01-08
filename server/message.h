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
  CARDS = 5,
  START_BID = 6,
  GIVEN_BID = 7,
  SEND_BID = 8,
  BIDDING_RESULT = 9,
  PLAY_CARD = 10,
  GIVEN_CARD = 11,
  SEND_CARD = 12,
  ROUND_OVER = 13
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

  int getBidSuit();
  int getBidHeight();

  int getCardSuit();
  int getCardType();

private:
  int convertToNumber(string);
  bool isNull();
  string getMsgAfterColon();

  int getBidOrCardSuit();
  int getBidHeightOrCardType();
};

#endif // MESSAGE_H
