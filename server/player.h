#ifndef PLAYER_H
#define PLAYER_H

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
};

#endif // PLAYER_H
