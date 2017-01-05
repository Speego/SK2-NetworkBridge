#ifndef PLAYER_H
#define PLAYER_H

#include "message.h"
#include "card.h"

#include <string.h>
#include <string>
#include <vector>

using std::string;
using std::vector;

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
  int tableID;

private:
  vector <Card*>* cards;

public:
  Player(int, PlayerState);
  Player(int, char*, PlayerState);
  ~Player();

  void setName(Message*);
  void resetCards();
  void insertCard(Card*);
};

#endif // PLAYER_H
