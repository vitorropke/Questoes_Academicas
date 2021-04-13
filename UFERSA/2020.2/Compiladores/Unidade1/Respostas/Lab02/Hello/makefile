# compilador 
CPP=g++
ARGS=-c -g -std=c++17

# dependências
all: hello

hello: hello.o
	$(CPP) hello.o -o hello

hello.o: hello.cpp
	$(CPP) $(ARGS) hello.cpp

clean:
	rm hello hello.o
