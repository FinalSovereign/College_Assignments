#include <stdio.h>
#include <stdlib.h>
#include <strings.h>
#include <ctype.h>

void TextOutput(char filename[], char PATH[]);
void HexOutput(char filename[], char PATH[], char temp[]);
void HexDump(char filename[], char PATH[], FILE *fp);
void EachLine(unsigned char* data, int nchars, FILE *fp);

int main()
{
    char filename[50];
    char PATH[139]="D:/Documents/FIU Courses/Spring 2015/EEL 2880-U01 (Software Techniques) - Prof. Herman Watson/CodeBlocks Projects/Homework Programs/Misc/";
    char temp[138];

    strcpy(temp,PATH);

    TextOutput(filename,PATH);
    strcpy(PATH,temp);
    printf("\n");

    HexOutput(filename,PATH,temp);
    strcpy(PATH,temp);

    return 0;
}

void TextOutput(char filename[], char PATH[])
{
    printf("TextOutput - Enter file name: ");
    scanf("%s",filename);
    strcat(PATH,filename);

    FILE *fp;
    fp = fopen(PATH, "w+");
    fprintf(fp, "This is testing for fprintf...\n");
    fputs("This is testing for fputs...\n", fp);

    int i=3;
    fprintf(fp,"This is string number %d\n",i);

    i++;
    fprintf(fp,"This is string number %d\n",i);
    i++;
    fprintf(fp,"This is string number %d\n",i);
    i++;
    fprintf(fp,"This is string number %d\n",i);
    i++;
    fprintf(fp,"This is string number %d\n",i);
    i++;
    fprintf(fp,"This is string number %d\n",i);
    i++;
    fprintf(fp,"This is string number %d\n",i);
    i++;
    fprintf(fp,"This is string number %d\n",i);

    fclose(fp);

    return;
}

void HexOutput(char filename[], char PATH[], char temp[])
{
    printf("HexOutput - Enter file name: ");
    scanf("%s",filename);
    strcat(PATH,filename);
    printf("\n");

    FILE *fp;
    fp = fopen(PATH,"w+");

    strcpy(PATH,temp);
    HexDump(filename,PATH,fp);

    fclose(fp);

    return;
}

void HexDump(char filename[], char PATH[], FILE *fp)
{
    FILE* fptr;
    int nchars;
    unsigned char inputvals[16];

    printf("HexDump - Enter file name: ");
    scanf("%s",filename);
    strcat(PATH,filename);
    printf("\n");

    fptr = fopen(PATH,"r");
    if (!fptr)
    {
        printf("file not found, cannot continue\n");

        return;
    }

    do
    {
        nchars = fread(inputvals, sizeof(char), 16, fptr);
        if(nchars) EachLine(inputvals,nchars,fp);
    } while(nchars);

    return;
}

void EachLine(unsigned char* data, int nchars, FILE *fp)
{
    int i;
    char ctmp;
    static int address=0;

    printf("%04X : ", address);
    fprintf(fp, "%04X : ", address);

    for (i=0; i<nchars; i++)
    {
        printf("%02X ", data[i]);
        fprintf(fp, "%02X ", data[i]);
    }

    printf(" : ");
    fprintf(fp," : ");

    for (i=0; i<nchars; i++)
    {
        ctmp = data[i];

        if ( isprint(ctmp) )
        {
            putc(ctmp, stdout);
            fputc(ctmp, fp);
        }
        else
        {
            putc('.', stdout);
            fputc('.', fp);
        }
    }

    printf("\n");
    fprintf(fp, "\n");

    address += nchars;
}
