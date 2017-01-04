#include "server.h"

void* threadGameManager(void* t_data) {

  printf("Game manager thread terminated.\n");
  pthread_exit(NULL);
}

Server::Server() {
  srand(time(NULL));
  printf("Server created.\n");
}

Server::~Server() {
  close(socketDescriptor);
  delete gameManager;
}

void Server::setServer(char* fileName) {
  socketDescriptor = initializeServerSocket(fileName);
  bindIPandPort(fileName);
  startListening(fileName);
  createGameManagerThread();
  printf("Server set.\n");
}

int Server::initializeServerSocket(char* fileName) {
  int descriptor;
  char reuse_addr_val = 1;

  memset(&serverAddress, 0, sizeof(struct sockaddr));
  serverAddress.sin_family = AF_INET;
	serverAddress.sin_addr.s_addr = htonl(INADDR_ANY);
	serverAddress.sin_port = htons(SERVER_PORT);

  descriptor = socket(AF_INET, SOCK_STREAM, 0);
	if (descriptor < 0) {
		fprintf(stderr, "%s: Error while creating socket.\n", fileName);
		exit(1);
	}

	setsockopt(descriptor, SOL_SOCKET, SO_REUSEADDR, (char*)&reuse_addr_val, sizeof(reuse_addr_val));

	return descriptor;
}

void Server::bindIPandPort(char* fileName) {
  int bindResult = bind(socketDescriptor, (struct sockaddr*)&serverAddress, sizeof(struct sockaddr));
  if (bindResult < 0) {
    fprintf(stderr, "%s: Erorr while binding IP address and port number to socket.\n", fileName);
		exit(1);
  }
}

void Server::startListening(char* fileName) {
  int listenResult = listen(socketDescriptor, QUEUE_SIZE);
  if (listenResult < 0) {
    fprintf(stderr, "%s: Error while setting queue size.\n", fileName);
    exit(1);
  }
}

void Server::createGameManagerThread() {
  int createResult;
  pthread_t thread;

  createResult = pthread_create(&thread, NULL, threadGameManager, (void*)NULL);
  if (createResult) {
    printf("Error while creating game manager thread. Error code: %d\n", createResult);
		exit(-1);
  }
  printf("Game manager thread created.\n");
}

void Server::waitForPlayers(char* fileName) {
  int playerDescriptor =  acceptConnection(fileName);
}

int Server::acceptConnection(char* fileName) {
  int connectionSocketDescriptor = accept(socketDescriptor, NULL, NULL);
  if (connectionSocketDescriptor < 0) {
    fprintf(stderr, "%s: Error while creating socket for connection.\n", fileName);
		exit(1);
  } else
    printf("New player with descriptor %d.", connectionSocketDescriptor);

  return connectionSocketDescriptor;
}
