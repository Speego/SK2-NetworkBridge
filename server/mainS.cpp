#include "server.h"

int main(int argc, char* argv[])
{
    Server* s = new Server();

    s->setServer(argv[0]);
    while (1) {
        s->waitForPlayers(argv[0]);
    }

    delete s;
    return 0;
}
