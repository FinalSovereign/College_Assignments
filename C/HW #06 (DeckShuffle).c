#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define NCARDS 52
#define NPROPS 2

#define NSUITS 4
#define NFACES 13

// card text values using array of pointers to preinitialized constant text strings
    char* suit[NSUITS]={"Hearts","Spades","Clubs","Diamonds"};

    char* face[NFACES]={"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine",
                        "Ten","Jack","Queen","King"};

// function prototypes used for manipulating cards
    void PrintCard(int deck[NCARDS][NPROPS], int i);
    void InitDeck(int deck[NCARDS][NPROPS]);
    void SwapCards(int deck[NCARDS][NPROPS], int src, int dest);
    void ShuffleDeck(int deck[NCARDS][NPROPS]);
    int GetPlayValue(int deck[NCARDS][NPROPS], int i);

int main()
{

    // deck of cards
    // face, suite, card value
    int deck[NCARDS][NPROPS];

    int i;

    srand(time(NULL));
    // init the deck
    // loop on the chards
    InitDeck(deck);
    ShuffleDeck(deck);



    // print the deck
    puts("The shuffled deck is:");
    for (i=0; i<NCARDS; i++)
    {
       PrintCard(deck,i);
    }

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

    printf("Deck row: %d  %s of %s  Play value: %d \n", i, face[faceValue], suit[suitValue], playValue);
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
