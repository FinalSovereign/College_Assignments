#include <stdio.h>
#include <stdlib.h>

int main()
{
    int A,B;
    int R;

    //Get the two input values
    printf("Input value for A: ");   //Print prompt first
    scanf("%d", &A);                 //Then read input

    printf("Input value for B: ");   //Print prompt first
    scanf("%d", &B);                 //Then read input

    R=A+B;
    printf("\nA+B = %d\n",R);

    R=A-B;
    printf("A-B = %d\n",R);

    R=A*B;
    printf("A*B = %d\n",R);

    R=A%B;
    printf("A%B = %d\n",R);

    R=A==B;
    printf("A==B = %d\n",R);

    R=A>B;
    printf("A>B = %d\n",R);

    R=A<=B;
    printf("A<=B = %d\n",R);

    R=A&&B;
    printf("A&&B = %d\n",R);

    R=++A;
    printf("++A = %d\n",R);

    R=B++;
    printf("B++ = %d\n",R);

    R=A&B;
    printf("A&B = %d\n",R);

    R=A|B;
    printf("A|B = %d\n",R);

    R=A<<1;
    printf("A<< = %d\n",R);

    R=B>>1;
    printf("B>> = %d\n",R);

    return 0;
}
