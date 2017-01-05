#include "player.h"

Player::Player(int ID, PlayerState st) {
  id = ID;
  state = st;
  cards = new vector<Card*>();
  printf("player.cpp: New player without name.\n");
}

Player::Player(int ID, char* name, PlayerState st) {
  id = ID;
  nickname = new string(name);
  state = st;
  cards = new vector<Card*>();
}

Player::~Player() {
  delete nickname;
  for (int i=0; i<(int)cards->size(); i++)
    delete (*cards)[i];
  delete cards;
}

void Player::setName(Message* msg) {
  nickname = new string(msg->getPlayerName());
  printf("player.cpp: Player with ID %d nickname set to: %s\n", id, (*nickname).c_str());
}

void Player::resetCards() {
  cards->clear();
}

void Player::insertCard(Card* card) {
  cards->push_back(card);
}
