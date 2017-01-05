#ifndef GAMEMANAGER_H
#define GAMEMANAGER_H

#include "table.h"
#include "player.h"
#include "message.h"

#include <stdio.h>
#include <stdlib.h>
#include <queue>
#include <string.h>
#include <vector>
#include <string>

#define BUF_SIZE 1024

using std::queue;
using std::vector;

class GameManager {
private:
  queue<Message*>* messagesNew;
  queue<Message*>* messagesToSend;

  vector<Table*>* tables;
  vector<Player*>* players;

  vector<string> messageTypesNames = {"Disconnected", "Nickname", "JoinTable"};

public:
  GameManager();
  ~GameManager();

  void update();
  int getReceiverID();
  char* getMessage();
  void addMessage(char*, int);

  void addPlayer(int);

private:
  void interpretMessage(Message*);
  void chooseTask(Message*, MessageType);

  void removePlayer(int);
  int findPlayer(int);
};

#endif // GAMEMANAGER_H
