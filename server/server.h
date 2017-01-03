#ifndef SERVER_H
#define SERVER_H

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
#define QUEUE_SIZE 16

class Server {
private:
  int socketDescriptor;
  struct sockaddr_in serverAddress;

public:
  Server();

  void setServer(char*);

private:
  int initializeServerSocket(char*);
  void bindIPandPort(char*);
  void startListening(char*);
};

#endif // SERVER_H
