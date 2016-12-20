#include <unordered_map>
#include <iostream>

using namespace std;

int 
main( int argc, char* argv[] ) {
  unordered_map< int, int > myMap;
  myMap[10] = 20;
  auto itr = myMap.begin();
  cout << itr->second << endl;
  return 0;
}
