#include "server.h"

int main(int argc, char* argv[])
{
    // srand(time(NULL));
    Server *s = new Server();

    s->setServer(argv[0]);
    while (1) {
        // s->manageGames();
    }

    delete s;
    return 0;
}
