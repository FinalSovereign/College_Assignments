#include <iostream>

using std::cin; using std::cout; using std::endl;

class CVector
{
    public:
        int x, y;
        CVector() {};
        CVector(int, int);
        CVector operator+(CVector);
};

CVector::CVector(int a, int b)
{
    x = a;
    y = b;
}

CVector CVector::operator+(CVector param)
{
    CVector temp;

    temp.x = x + param.x;
    temp.y = y + param.y;

    return(temp);
}

int main()
{
    CVector a;

    cout << "Input x and y values: ";
    cin >> a.x >> a.y;
    cout << endl;       //Added in for spacing in the terminal

    CVector b(1,2);
    CVector c;

    c = a + b;

    cout << "Sum x = " << c.x << ", y = " << c.y;

    return 0;
}
