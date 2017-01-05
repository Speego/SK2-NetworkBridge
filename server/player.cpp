#include "player.h"

Player::Player(int ID, PlayerState st) {
  id = ID;
  state = st;
  printf("player.cpp: New player without name.\n");
}

Player::Player(int ID, char* name, PlayerState st) {
  id = ID;
  nickname = new string(name);
  state = st;
}

Player::~Player() {
  delete nickname;
}
