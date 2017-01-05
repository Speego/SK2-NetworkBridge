#ifndef TABLE_H
#define TABLE_H

#include "player.h"

#include <vector>

using std::vector;

enum class TableState {
  WAITING = 0,
  READY = 1,
  GAME_ON = 2,
  BIDDING_ON = 3,
  BIDDING_END = 4,
  END_ON = 5
};

class Table {
public:
  TableState state;
  int id;

private:
  vector<Player*>* players;

public:
  Table(int, Player*);
  ~Table();

  int getNumberOfPlayers();
  int findPlayer(int);
  void removePlayer(int);
  void join(Player*);
  bool canJoin(int);

private:
  bool playerAtTable(int);
};

#endif // TABLE_H
