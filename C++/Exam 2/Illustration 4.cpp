#include <algorithm>
#include <vector>
#include <iostream>
#include <iterator>

int main()
{
    using namespace std;

    vector<int> v;

    cout << "Please enter numbers" << endl;

    istream_iterator<int> start(cin);
    istream_iterator<int> end;

    back_insert_iterator< vector<int> > dest(v);

    copy(start, end, dest);
    sort(v.begin(), v.end());
    copy(v.begin(), v.end(), ostream_iterator<int>(cout, "\n"));


    return 0;
}// Page 17
