#include <iostream>
#include <ctime>

#include "./limited_linked_list_class.hpp"

using namespace std;

int main()
{
    time_t t=time(NULL);
    List MyList;

    MyList.add(5);
    MyList.add(12);
    MyList.add(24);
    MyList.add(32);
    MyList.add(47);
    MyList.add(54);
    MyList.add(65);

    MyList.show();

    cout << endl << "Today is: " << ctime(&t) << endl;

    return 0;
}
