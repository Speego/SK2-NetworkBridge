#include "table.h"

Table::Table(int ID, Player* player) {
  id = ID;
  players = new vector<Player*>();
  players->push_back(player);
  state = TableState::WAITING;
}

Table::~Table() {
  delete players;
}

int Table::getNumberOfPlayers() {
  return (int)players->size();
}

int Table::findPlayer(int clientID) {
  for (int i=0; i<(int)players->size(); i++) {
    if ((*players)[i]->id == clientID)
      return i;
  }
  throw "table.cpp: No player with ID " + clientID;
}

void Table::removePlayer(int playerID) {
  try {
    int playerVectorPosition = findPlayer(playerID);
    players->erase(players->begin() + playerVectorPosition);
    printf("table.cpp: Player with ID %d removed. Number of players at table: %d.\n", playerID, (int)players->size());
  } catch(char const* noPlayer) {
    printf("%s\n", noPlayer);
  }
}
