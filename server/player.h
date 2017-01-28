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

enum class GamePlayerType {
  NONE = -1,
  DECLARER = 0,
  FIRST_DEFENDER = 1,
  DUMMY = 2,
  SECOND_DEFENDER = 3
};

class Player {
public:
  int id;
  string* nickname;
  PlayerState state;
  GamePlayerType gamePlayerType;
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

  bool hasCard(CardSuit, CardType);
  bool hasSuit(CardSuit);
  void removeCard(CardSuit, CardType);

private:
  char convertNumberToCardType(int);
  string convertNumberToString(int);
  void sortCardsSuit();
  void sortCardsType();

  int findCard(CardSuit, CardType);
};

#endif // PLAYER_H
