#ifndef GAMEMANAGER_H
#define GAMEMANAGER_H

#include "table.h"
#include "player.h"
#include "message.h"

#include <stdio.h>
#include <stdlib.h>
#include <queue>
#include <string.h>

#define BUF_SIZE 1024

using std::queue;

class GameManager {
private:
  queue<Message*>* messagesNew;
  queue<Message*>* messagesToSend;

  enum messageType {
    newPlayer,
    newTable,
    joinTable
  };

public:
  GameManager();
  ~GameManager();

  void update();
  int getReceiverID();
  char* getMessage();
  void addMessage(char*, int);
};

#endif // GAMEMANAGER_H
