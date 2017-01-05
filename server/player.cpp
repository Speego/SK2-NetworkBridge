#include "player.h"

bool compareCardsSuit(Card* x, Card* y) {
  return (int)x->suit < (int)y->suit;
}

bool compareCardsType(Card*x, Card* y) {
  return (int)x->type < (int)y->type;
}

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
  cards->clear();
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

int Player::getNumberOfCards() {
  return (int)cards->size();
}

string Player::getCardsMessage() {
  string msg;
  for (int i=0; i<(int)cards->size(); i++)
    msg += convertNumberToString((int)(*cards)[i]->suit) + '-' + convertNumberToString((int)(*cards)[i]->type) + ',';
  return msg;
}

string Player::convertNumberToString(int number) {
  if (number < 10)
    return "0" + to_string(number);
  return to_string(number);
}

void Player::sortCards() {
  sortCardsType();
  sortCardsSuit();
}

void Player::sortCardsSuit() {
  sort(cards->begin(), cards->end(), compareCardsSuit);
}

void Player::sortCardsType() {
  sort(cards->begin(), cards->end(), compareCardsType);
}
