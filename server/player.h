#ifndef PLAYER_H
#define PLAYER_H

#include "message.h"
#include "card.h"

#include <string.h>
#include <string>
#include <vector>
#include <algorithm>

using std::string;
using std::to_string;
using std::vector;
using std::sort;

bool compareCardsSuit(Card*, Card*);
bool compareCardsType(Card*, Card*);

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
  int getNumberOfCards();
  string getCardsMessage();
  void sortCards();

private:
  string convertNumberToString(int);
  void sortCardsSuit();
  void sortCardsType();
};

#endif // PLAYER_H
