#include <iostream>
#include <ctime>

using namespace std;

int main()
{
    time_t t = time(NULL);
    float miles, kilo;

    cout << "Enter number of miles: ";
    cin >> miles;
    cout << endl;

    kilo = miles*1.60934;

    cout << "Kilometers = " << kilo << endl<< endl;
    cout << "Today is: " << ctime(&t) << endl;

    return 0;
}
