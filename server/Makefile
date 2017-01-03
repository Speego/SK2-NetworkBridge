CXX = g++
CXXFLAGS = -I. -Wall -std=c++11 -pthread
DEPS = server.h
OBJ = server.o

%.o: %.c $(DEPS)
	$(CXX) -cpp -o $@ $< $(CFXXFLAGS)

server: $(OBJ)
	$(CXX) -cpp mainS.cpp -o $@ $^ $(CXXFLAGS)

clean:
	rm -f $(OBJ) *~ server

.PHONY: clean
