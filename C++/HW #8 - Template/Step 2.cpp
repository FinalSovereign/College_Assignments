#include <iostream>
#include <ctime>

#include "./limited_linked_list_template.hpp"

using namespace std;

int main()
{
    time_t t=time(NULL);

    // Create first list
    List<int> MyList;

    MyList.add(5);
    MyList.add(12);
    MyList.add(24);
    MyList.add(32);
    MyList.add(47);
    MyList.add(54);
    MyList.add(65);

    cout << "Here is my first list " << endl;
    MyList.show();

    // Create second list
    List<string> MyStringList;

    MyStringList.add("First String");
    MyStringList.add("Second String");
    MyStringList.add("Third String");
    MyStringList.add("Fourth String");
    MyStringList.add("Fifth String");

    cout << endl << "Here is my Second list " << endl;
    MyStringList.show();

    cout << endl << "Today is: " << ctime(&t) << endl;

    return 0;
}
