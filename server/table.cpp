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

void Table::join(Player* player) {
  players->push_back(player);
  if (getNumberOfPlayers() == 4)
    state = TableState::READY;
}

bool Table::canJoin(int playerID) {
  if (getNumberOfPlayers() < 4 && !playerAtTable(playerID))
    return true;
  return false;
}

bool Table::playerAtTable(int playerID) {
  try {
    findPlayer(playerID);
    return true;
  } catch (string noPlayer) {
    return false;
  }
}
