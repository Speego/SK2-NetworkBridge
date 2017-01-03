CXX = g++
CXXFLAGS = -I. -Wall -std=c++11 -pthread
DEPS =
OBJ =

%.o: %.c $(DEPS)
	$(CXX) -cpp -o $@ $< $(CFXXFLAGS)

client: $(OBJ)
	$(CXX) -cpp mainC.cpp -o $@ $^ $(CXXFLAGS)

clean:
	rm -f $(OBJ) *~ client

.PHONY: clean
