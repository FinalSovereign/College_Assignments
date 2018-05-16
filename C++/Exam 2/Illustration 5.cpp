#include <iostream> // cin, cout, endl
#include <string>

using std::cout;
using std::endl;
using std::string;

template<typename T>
const T& max(const T& x, const T& y)
{
    if(y < x)
        return x;

    return y;
}

int main()
{
    cout << max(3, 7) << endl;
    cout << max(3.0, 4.0) << endl;
    cout << max<double>(3, 8.0) << endl;
    cout << max<char>('A', 'C') << endl;
    cout << max<string>("hello", "world") << endl;

    return 0;
}
