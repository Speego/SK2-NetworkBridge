#ifndef TABLE_H
#define TABLE_H

#include "player.h"

#include <vector>

using std::vector;

class Table {
private:
  vector<Player*>* players;

public:
  Table();

  int getNumberOfPlayers();
};

#endif // TABLE_H
