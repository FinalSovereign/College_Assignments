#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define NCARDS 52
#define NPROPS 2

#define NSUITS 4
#define NFACES 13

#define NHAND 5

// card text values using array of pointers to preinitialized constant text strings
    char* suit[NSUITS]={"Hearts","Spades","Clubs","Diamonds"};

    char* face[NFACES]={"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine",
                        "Ten","Jack","Queen","King"};

// function prototypes used for manipulating cards
    void InitDeck(int deck[NCARDS][NPROPS]);
    void ShuffleDeck(int deck[NCARDS][NPROPS]);
    void SwapCards(int deck[NCARDS][NPROPS], int src, int dest);
    void PrintCard(int deck[NCARDS][NPROPS], int i);
    int GetPlayValue(int deck[NCARDS][NPROPS], int i);
    void DrawHands(int deck[NCARDS][NPROPS], int NPLAY, int p[NPLAY*NHAND][NPROPS]);
    void ShowHands(int deck[NCARDS][NPROPS], int i, int h, int NPLAY,  int p[NPLAY*NHAND][NPROPS]);
    void PrintHand(int i, int NPLAY, int p[NPLAY*NHAND][NPROPS]);
    int GetCardValue(int i, int NPLAY, int p[NPLAY*NHAND][NPROPS]);
    void CalValue(int i, int NPLAY, int p[NPLAY*NHAND][NPROPS]);

int main()
{

    // deck of cards
    // face, suite, card value
    int deck[NCARDS][NPROPS];

    int i, h, NPLAY, TOTAL;

    srand(time(NULL));

    // init the deck
    // loop on the chards
    InitDeck(deck);
    ShuffleDeck(deck);

    printf("Enter the number of players: ");
    scanf("%d", &NPLAY);

    int* p[NPLAY*NHAND][NPROPS];

    // deal out the players' hands
    puts("\nDealing...\n");
    DrawHands(deck,NPLAY,p);

    // print the hands
    puts("The players' hands are: \n");
    system("PAUSE");
    printf("\n");

    for(h=1; h<NPLAY; h++)
    {
        ShowHands(deck,i,h,NPLAY,p);
    }

    h=NPLAY;
    ShowHands(deck,i,h,NPLAY,p);

    //Tally the total for each player
    puts("The players' totals are: \n");
    system("PAUSE");
    printf("\n");

    CalValue(i,NPLAY,p);

    system("PAUSE");

    return 0;
}

void InitDeck(int deck[NCARDS][NPROPS])
{
    int s, f, row;

    row=0;

    for(s=0; s<NSUITS; s++)
    {
        for (f=0; f<NFACES; f++)
        {
            deck[row][0]=s;
            deck[row][1]=f;
            row++;
        }
    }
}

void ShuffleDeck(int deck[NCARDS][NPROPS])
{
    int src, dest;

    for(dest=0; dest<NCARDS; dest++)
    {
        src=rand()%NCARDS;
        SwapCards(deck, src, dest);
    }
}

void SwapCards(int deck[NCARDS][NPROPS], int src, int dest)
{
    int temp;

    temp=deck[dest][0];
    deck[dest][0]=deck[src][0];
    deck[src][0]=temp;

    temp=deck[dest][1];
    deck[dest][1]=deck[src][1];
    deck[src][1]=temp;
}

void PrintCard(int deck[NCARDS][NPROPS], int i)
{
    int suitValue=deck[i][0];
    int faceValue=deck[i][1];
    int playValue=GetPlayValue(deck,i);

    printf("%s of %s  Play value: %d \n", face[faceValue], suit[suitValue], playValue);
}

int GetPlayValue(int deck[NCARDS][NPROPS], int i)
{
    int faceValue=deck[i][1];
    int playValue=10;

    if(faceValue<10)
    {
        return faceValue+1;
    }
    else
    {
        return playValue;
    }
}

void DrawHands(int deck[NCARDS][NPROPS], int NPLAY, int p[NPLAY*NHAND][NPROPS])
{
    int c;
    for(c=0; c<NPLAY*NHAND; c++)
    {
        int s=deck[c][0];
        int f=deck[c][1];

        p[c][0]=s;
        p[c][1]=f;
    }
}

void ShowHands(int deck[NCARDS][NPROPS], int i, int h, int NPLAY, int p[NPLAY*NHAND][NPROPS])
{
    printf("PLAYER %d\n", h);
    printf("--------\n");

    for(i=h-1; i<NPLAY*NHAND; i=i+NPLAY)
    {
        PrintHand(i,NPLAY,p);
    }

    printf("\n");
    system("PAUSE");
    printf("\n");
}

void PrintHand(int i, int NPLAY, int p[NPLAY*NHAND][NPROPS])
{
    int suitValue=p[i][0];
    int faceValue=p[i][1];
    int playValue=GetCardValue(i,NPLAY,p);

    printf("%s of %s  Play value: %d \n", face[faceValue], suit[suitValue], playValue);
}

int GetCardValue(int i, int NPLAY, int p[NPLAY*NHAND][NPROPS])
{
    int faceValue=p[i][1];
    int playValue=10;
    int faceVal[NPLAY*NHAND];
    int c=0;


    if(faceValue>0)
    {
        faceVal[c]=faceValue;

        if(faceVal[c]<10)
        {
            return faceVal[c]+1;
        }
        else
        {
            return playValue;
        }

        c++;
    }
    else
    {
        return playValue+1;
    }
}

void CalValue(int i, int NPLAY, int p[NPLAY*NHAND][NPROPS])
{
    int c, h, count, v[NPLAY*NHAND];
    int sum=0;

    for(c=1; c<NPLAY; c++)
    {
        printf("Player %d\n", c);
        printf("--------\n");

        for(i=c-1; i<NPLAY*NHAND; i=i+NPLAY)
        {
            v[i]=GetCardValue(i,NPLAY,p);

            if(i<NPLAY)
            {
                printf(" %d\n",v[i]);
            }
            else
            {
                printf("+%d\n",v[i]);
            }

            sum+=v[i];
        }

        printf("-----\n");

        printf(" %d\n\n", sum);
        sum=0;
        system("PAUSE");
        printf("\n");
    }

    c=NPLAY;
    printf("Player %d\n", c);
    printf("--------\n");

    for(i=c-1; i<NPLAY*NHAND; i=i+NPLAY)
    {
        v[i]=GetCardValue(i,NPLAY,p);

        if(i<NPLAY)
        {
            printf(" %d\n",v[i]);
        }
        else
        {
            printf("+%d\n",v[i]);
        }

        sum+=v[i];
    }

    printf("-----\n");

    printf(" %d\n\n", sum);
    sum=0;
}
