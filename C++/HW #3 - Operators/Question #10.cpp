#include <iostream>
#include <ctime>

using namespace std;

float convert(float miles)
{
    float kilo;

    kilo = miles*1.60934;

    return(kilo);
}

int main()
{
    time_t t = time(NULL);
    float miles, z;

    cout << "Enter number of miles: ";
    cin >> miles;
    cout << endl;

    z = convert(miles);

    cout << "Kilometers = " << z << endl << endl;
    cout << "Today is: " << ctime(&t) << endl;

    return 0;
}
