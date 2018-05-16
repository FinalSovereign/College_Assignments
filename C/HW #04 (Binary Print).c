#include <stdio.h>

int main()
{
    int i = 0xF5A2;
    int count;
    int mask = 0x8000;  //This number equals to 1000 0000 0000 0000 so it matches the bit amount

    printf("Hex value = %x,  Binary = ", i);

    for(count=0; count<16; count++)
    {
        if((i&mask)!=0)
        {
            printf("1");
            mask = mask>>1;
        }
        else
        {
            printf("0");
            mask = mask>>1;
        }

        if(count%4==3)
        {
            printf(" ");
        }
    }

    printf("\n");

    return 0;
}
