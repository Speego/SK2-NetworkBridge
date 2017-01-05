#ifndef TABLE_H
#define TABLE_H

#include "player.h"
#include "card.h"

#include <string>
#include <vector>
#include <algorithm>

using std::string;
using std::vector;
using std::swap;

enum class TableState {
  WAITING = 0,
  READY = 1,
  BIDDING_ON = 2,
  BIDDING_END = 3,
  GAME_ON = 4,
  END_ON = 5
};

class Table {
public:
  TableState state;
  int id;

private:
  vector<Player*>* players;
  vector<Card*>* cards;

  int numberOfPlayersResponses;
  int bidWinner;
  int currentPlayer;
  int trumpsHeight;
  CardSuit trumpsSuit;
  int numberOfPasses;

public:
  Table(int, Player*);
  ~Table();

  int getNumberOfPlayers();
  int findPlayer(int);
  void removePlayer(int);
  void join(Player*);
  bool canJoin(int);

  void createCards();

  string getCardsOfPlayer(int);
  int getPlayerID(int);

  void prepareForBidding();
  int getBidderID();
  bool isBidCorrect(CardSuit, int);
  void bid(CardSuit, int);
  int getPlayerNotBiddingID(int);
  void changeTurn();
  bool biddingOver();

private:
  bool playerAtTable(int);
  void generateCards();
  void randomShuffle();
  void dealCards();

  void playerPasses();
};

#endif // TABLE_H
