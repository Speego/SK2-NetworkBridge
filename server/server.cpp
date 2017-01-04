#include "server.h"

void* threadGameManager(void* t_data) {
  struct thread_sending_data *th_data = (struct thread_sending_data*)t_data;
  char* buffer = (char*)malloc(BUF_SIZE*sizeof(char));
  int receiverID;
  GameManager* gameManager = (*th_data).gameManager;
  vector<int>* clientsDescriptors = (*th_data).clientsDescriptors;
  int messageLength;

  while (1) {
    // pthread_mutex_lock(&(*th_data).sendMessageMutex);
    // mutex pobierający z kolejki oczekujących
    gameManager->update();
    // ten sam mutex (w ogóle jeden i ten sam)
    receiverID = gameManager->getReceiverID();
    buffer = gameManager->getMessage();
    if (buffer != NULL) {
        messageLength = write((*clientsDescriptors)[receiverID], buffer, strlen(buffer));
        if (messageLength < 0)
          printf("Error while writing to socket. Client id: %d, message: %s\n", receiverID, buffer);
    }
    // pthread_mutex_unlock(&(*th_data).recvMessageMutex);
  }

  printf("Game manager thread terminated.\n");
  pthread_exit(NULL);
}

void* threadReceivingBehavior(void* t_data) {
  struct thread_receive_data *th_data = (struct thread_receive_data*)t_data;
  char buffer[BUF_SIZE];
  GameManager* gameManager = (*th_data).gameManager;
  int messageLength = 1;
  printf("New client with descriptor %d.\n", (*th_data).descriptor);

  while (messageLength > 0) {
    bzero(buffer, BUF_SIZE);
    messageLength = read((*th_data).descriptor, buffer, BUF_SIZE-1);
    if (messageLength < 0)
      printf("Error while reading from socket %d.\n", (*th_data).descriptor);
    else {
      // pthread_mutex_lock(&(*th_data).recvMessageMutex);
      // mutex uaktualniający kolejkę oczekujących
      gameManager->addMessage(buffer, (*th_data).id);
      // ten sam mutex (w ogóle jeden i ten sam)
      // pthread_mutex_unlock(&(*th_data).sendMessageMutex);
    }
  }

  printf("Player thread terminated.\n");
  pthread_exit(NULL);
}

Server::Server() {
  srand(time(NULL));
  numberOfClients = 0;
  clientsDescriptors = new vector<int>();
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
  struct thread_sending_data* threadData;

  gameManager = new GameManager();

  threadData = (struct thread_sending_data*)malloc(sizeof(struct thread_sending_data));
  (*threadData).gameManager = this->gameManager;
  (*threadData).recvMessageMutex = this->recvMessageMutex;
  (*threadData).sendMessageMutex = this->sendMessageMutex;
  (*threadData).clientsDescriptors = this->clientsDescriptors;

  createResult = pthread_create(&thread, NULL, threadGameManager, (void*)threadData);
  if (createResult) {
    printf("Error while creating game manager thread. Error code: %d\n", createResult);
		exit(-1);
  }
  printf("Game manager thread created.\n");
}

void Server::waitForPlayers(char* fileName) {
  int playerDescriptor =  acceptConnection(fileName);
  createReceivingThread(playerDescriptor);
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

void Server::createReceivingThread(int playerDescriptor) {
  int createResult;
  pthread_t thread;
  struct thread_receive_data* threadData;

  threadData = (struct thread_receive_data*)malloc(sizeof(struct thread_receive_data));
  (*threadData).descriptor = playerDescriptor;
  (*threadData).gameManager = this->gameManager;
  (*threadData).recvMessageMutex = this->recvMessageMutex;
  (*threadData).sendMessageMutex = this->sendMessageMutex;
  (*threadData).id = numberOfClients;

  createResult = pthread_create(&thread, NULL, threadReceivingBehavior, (void*)threadData);
  if (createResult) {
    printf("Error while creating receiving thread. Error code: %d\n", createResult);
    exit(-1);
  } else {
    numberOfClients++;
    clientsDescriptors->push_back(playerDescriptor);
  }
}
