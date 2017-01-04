#ifndef SERVER_H
#define SERVER_H

#include "gameManager.h"
#include "message.h"

#include <sys/types.h>
#include <sys/wait.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netdb.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <pthread.h>
#include <stdbool.h>
#include <vector>

#define BUF_SIZE 1024
#define SERVER_PORT 1234
#define QUEUE_SIZE 64

void* threadGameManager(void*);

class Server {
private:
  int socketDescriptor;
  struct sockaddr_in serverAddress;
  GameManager* gameManager;

public:
  Server();
  ~Server();

  void setServer(char*);
  void waitForPlayers(char*);

private:
  int initializeServerSocket(char*);
  void bindIPandPort(char*);
  void startListening(char*);
  void createGameManagerThread();

  int acceptConnection(char*);
};

#endif // SERVER_H
