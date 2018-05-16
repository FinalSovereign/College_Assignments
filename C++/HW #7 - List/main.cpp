#include<iostream>
#include <vector>
#include <list>
#include <ctime>

using namespace std;

int main()
{
    time_t t = time(NULL);

    int a[10]={0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };// Define an array of ints with ten elements


    std::vector<int> vec (&a[0],&a[0]+10);//Define a vector<int> with those ten elements


    std::list<int> lis (&a[0],&a[0]+10);//Define a list <int> with those elements


    //Define a second array, vector, and list, each initialized as a copy of the first array, vector, and list, respectively
    int b[10];
    for(int i=0;i<10;i++)
    {
        b[i]=a[i];
    }

    std::vector<int> v(vec);
    std::list<int> l(lis);

    for(int i=0;i<10;i++)// Increase the value of each element in the array by 2
    {
        b[i]+=2;
    }

    for(int i=0;i<10;i++)//Increase the value of each element in the vector by 3;
    {
        v[i]+=3;
    }

    for (std::list<int>::iterator it = l.begin(); it != l.end(); it++)//Increase the value of each element in list by 5.

    *it=*it+5;

    cout<<"Values of each of the containers are: "<<endl;
    cout<<"First Array is:"<<endl;

    for(int i=0;i<10;i++)
    {
        cout<<a[i]<<" ";
    }

    cout<<"\nFirst Vector is:\n";

    for(int i=0;i<10;i++)
    {
        cout<<vec[i]<<" ";
    }

    cout<<"\nFirst List is:\n";

    for (std::list<int>::iterator it = lis.begin(); it != lis.end(); it++)

    cout << *it << ' ';
    cout<<"\nSecond Array is:"<<endl;

    for(int i=0;i<10;i++)
    {
        cout<<b[i]<<" ";
    }

    cout<<"\nSecond Vector is:\n";

    for(int i=0;i<10;i++)
    {
        cout<<v[i]<<" ";
    }

    cout<<"\nSecond List is:\n";

    for (std::list<int>::iterator it = l.begin(); it != l.end(); it++)

    cout << *it << ' ';
    cout << endl << endl << "Today is: " << ctime(&t) << endl;

return 0;
}
