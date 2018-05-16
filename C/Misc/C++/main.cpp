#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STRSHORT 15
#define STRMED 30
#define STRLONG 80

using namespace std;

typedef struct company
{
    char name [STRLONG];
    char street [STRLONG];
    char city [STRMED];
    char state [STRMED];
    char zip [STRSHORT];
    char phone [STRSHORT];
    char cell [STRSHORT];
    int rating;
    char contact [STRLONG];
} company;

void printInfo(company* info, FILE* fpout);

int main()
{
    FILE *fpin;
    FILE *fpout;
    int BlockNumber;
    char file_in[STRLONG];
    char file_out[STRLONG];
    char PATH[2*STRLONG]="D:/Documents/FIU Courses/Spring 2015/EEL 2880-U01 (Software Techniques) - Prof. Herman Watson/CodeBlocks Projects/Homework Programs/Misc/";
    char temp[2*STRLONG];

    strcpy(temp,PATH);
    company* info=new company;

    printf("Enter input file name : ");
    scanf("%s",file_in);
    fflush(stdin); /* flush keyboard buffer */
    strcat(PATH,file_in);

    if ((fpin = fopen(PATH,"rb+")) == NULL)
    {
        fprintf(stderr, "Error opening input file.");
        exit(1);
    }

    strcpy(PATH,temp);
    printf("\n");

    printf("Enter output file name : ");
    scanf("%s",file_out);
    fflush(stdin); /* flush keyboard buffer */
    strcat(PATH,file_out);

    if ((fpout = fopen(PATH,"w+")) == NULL)
    {
        fprintf(stderr, "Error opening output file.");
        exit(1);
    }

    strcpy(PATH,temp);

    for (BlockNumber=0; BlockNumber<8; BlockNumber++)
    {
        if (fseek(fpin, BlockNumber*sizeof(company), SEEK_SET) != 0)
        {
            fprintf(stderr, "\nError using fseek().");
            exit(1);
        }

        fread(info, sizeof(company), 1, fpin);

        fprintf(fpout, "Block %d\n", BlockNumber); //add header text
        fprintf(fpout, "-------\n");

        printInfo (info,fpout);

        fprintf(fpout, "\n\n\n");
    }

    return 0;
}

void printInfo(company* info, FILE *fpout)
{
    fprintf(fpout, "Name: %s \n", info->name);
    fprintf(fpout, "Street: %s \n", info->street);
    fprintf(fpout, "City: %s \n", info->city);
    fprintf(fpout, "State: %s \n", info->state);
    fprintf(fpout, "ZIP Code: %s \n", info->zip);
    fprintf(fpout, "Home #: %s \n", info->phone);
    fprintf(fpout, "Cell #: %s \n", info->cell);
    fprintf(fpout, "Rating: %d \n\n", info->rating);
    fprintf(fpout, "Contact: %s \n", info->contact);

    return;
}
