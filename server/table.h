#ifndef TABLE_H
#define TABLE_H

#include "player.h"
#include "card.h"

#include <vector>
#include <algorithm>

using std::vector;
using std::swap;

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
  vector<Card*>* cards;

public:
  Table(int, Player*);
  ~Table();

  int getNumberOfPlayers();
  int findPlayer(int);
  void removePlayer(int);
  void join(Player*);
  bool canJoin(int);

  void createCards();

private:
  bool playerAtTable(int);
  void generateCards();
  void randomShuffle();
  void dealCards();
};

#endif // TABLE_H
