#ifndef GAMEMANAGER_H
#define GAMEMANAGER_H

#include "table.h"
#include "player.h"
#include "message.h"

#include <stdio.h>
#include <stdlib.h>
#include <queue>
#include <string.h>
#include <vector>
#include <string>

#define BUF_SIZE 1024

using std::queue;
using std::vector;
using std::to_string;

class GameManager {
private:
  queue<Message*>* messagesNew;
  queue<Message*>* messagesToSend;

  vector<Table*>* tables;
  vector<Player*>* players;

  vector<string> messageTypesNames = {"Disconnected", "Nickname", "SendTables", "CreateTable", "JoinTable",
                                      "Cards", "StartBid", "GivenBid", "SendBid", "BiddingResult", "PlayCard",
                                      "GivenCard", "SendCard", "RoundOver", "GameResult", "Acceptance"};

  int tablesID;

public:
  GameManager();
  ~GameManager();

  void update();
  int getReceiverID();
  char* getMessage();
  void addMessage(char*, int);

  void addPlayer(int);

private:
  void interpretMessage(Message*);
  void chooseTask(Message*, MessageType);
  int findPlayer(int);
  int findTable(int);
  void updateTables();
  void createBidPromptMessage(int);

  void removePlayer(int);

  void setPlayerName(Message*, int);
  void createTablesMessage(int);

  void createTable(int);
  void joinTable(int, Message*);

  void createCardsMessages(int);

  void manageGivenBidMessage(Message*);
  void sendGivenBidToPlayers(int, CardSuit, int);
  string convertBidToString(CardSuit, int);
  void sendEndOfBidding(int);

  void createPlayCardPromptMessage(int);

  void manageGivenCardMessage(Message*);
  void sendGivenCardToPlayers(int, CardSuit, CardType);
  string convertCardToString(CardSuit, CardType);
  void sendEndOfRound(int);
  void sendEndOfGame(int);
  void removeTable(int);

  void sendAcceptance(MessageType, bool, int);

  void addMessageToSend(char*, int);
  string convertNumberToString(int);
  char* convertConstChar(const char*);
};

#endif // GAMEMANAGER_H
