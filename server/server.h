#ifndef SERVER_H
#define SERVER_H

#include "gameManager.h"

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

#define BUF_SIZE 1
#define SERVER_PORT 1235
#define QUEUE_SIZE 40

using std::vector;

struct thread_receive_data {
  int descriptor;
  int id;
  pthread_mutex_t messagesMutex;
  GameManager* gameManager;
};

struct thread_sending_data {
  pthread_mutex_t messagesMutex;
  GameManager* gameManager;
  vector<int>* clientsDescriptors;
};

void* threadGameManager(void*);
void* threadReceivingBehavior(void*);

class Server {
private:
  int socketDescriptor;
  struct sockaddr_in serverAddress;

  pthread_mutex_t messagesMutex = PTHREAD_MUTEX_INITIALIZER;

  GameManager* gameManager;

  int numberOfClients;
  vector<int>* clientsDescriptors;

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
  void createReceivingThread(int);

  int acceptConnection(char*);
};

#endif // SERVER_H
