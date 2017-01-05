CXX = g++
CXXFLAGS = -I. -Wall -std=c++11 -pthread
DEPS = server.h gameManager.h table.h player.h message.h card.h
OBJ = server.o gameManager.o table.o player.o message.o card.o

%.o: %.c $(DEPS)
	$(CXX) -cpp -o $@ $< $(CFXXFLAGS)

server: $(OBJ)
	$(CXX) -cpp mainS.cpp -o $@ $^ $(CXXFLAGS)

clean:
	rm -f $(OBJ) *~ server

.PHONY: clean
