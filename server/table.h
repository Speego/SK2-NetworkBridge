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

enum class BiddingResult {
  DECLARER = 0,
  FIRST_DEFENDER = 1,
  DUMMY = 2,
  SECOND_DEFENDER = 3
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

  CardSuit firstSuit;
  CardSuit winSuit;
  CardType winType;
  int declarerScore;
  GamePlayerType roundWinner;
  int cardCounter;
  int roundCounter;
  bool dummyPlaying;

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
  int getPlayerIDByBidding(BiddingResult);
  void setPlayerGameType(BiddingResult);
  void prepareForGame();

  int getCurrentPlayerID();
  bool isPlayerTurn(int);
  bool isCardCorrect(CardSuit, CardType, int);

private:
  bool playerAtTable(int);
  void generateCards();
  void randomShuffle();
  void dealCards();

  void playerPasses();

  bool cardWithWrongSuit(CardSuit);
  bool cardWithWrongType(CardType);
  bool iscardFirst();
};

#endif // TABLE_H
