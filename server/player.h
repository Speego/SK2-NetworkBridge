#ifndef PLAYER_H
#define PLAYER_H

#include "message.h"

#include <string.h>
#include <string>

using std::string;

enum class PlayerState {
  fresh,
  waitingAtTable,
  bidding,
  playing,
  dummy
};

class Player {
public:
  int id;
  string* nickname;
  PlayerState state;

public:
  Player(int, PlayerState);
  Player(int, char*, PlayerState);
  ~Player();

  void setName(Message*);
};

#endif // PLAYER_H
