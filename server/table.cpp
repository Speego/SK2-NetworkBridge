#include "table.h"

Table::Table() {
  players = new vector<Player*>();
}

int Table::getNumberOfPlayers() {
  return (int)players->size();
}
