#include "server.h"

Server::Server() {
  printf("Server says 'Hello'!\n");
}

void Server::setServer(char* fileName) {
  socketDescriptor = initializeServerSocket(fileName);
  bindIPandPort(fileName);
  startListening(fileName);
  printf("Server set!\n");
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
		fprintf(stderr, "%s: Błąd przy próbie utworzenia gniazda.\n", fileName);
		exit(1);
	}

	setsockopt(descriptor, SOL_SOCKET, SO_REUSEADDR, (char*)&reuse_addr_val, sizeof(reuse_addr_val));

	return descriptor;
}

void Server::bindIPandPort(char* fileName) {
  int bindResult = bind(socketDescriptor, (struct sockaddr*)&serverAddress, sizeof(struct sockaddr));
  if (bindResult < 0) {
    fprintf(stderr, "%s: Błąd przy próbie dowiązania adresu IP i numeru portu do gniazda.\n", fileName);
		exit(1);
  }
}

void Server::startListening(char* fileName) {
  int listenResult = listen(socketDescriptor, QUEUE_SIZE);
  if (listenResult < 0) {
    fprintf(stderr, "%s: Błąd przy próbie ustawienia wielkości kolejki.\n", fileName);
    exit(1);
  }
}
