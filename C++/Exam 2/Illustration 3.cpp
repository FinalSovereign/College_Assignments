// Advance example
#include <iostream>
#include <iterator>
#include <list>

using namespace std;

int main()
{
    list<int> mylist;

    for(int i = 0; i < 10; i++) mylist.push_back(i*10);

    list<int>::iterator it = mylist.begin();

    advance(it,5);

    cout << "The chosen element is: " << *it << endl;

    return 0;
}
