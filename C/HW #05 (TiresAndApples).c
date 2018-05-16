#include <stdio.h> //This is a complier directive that uses pre-made functions from the header, stdio
#include <string.h> //This is a complier directive that uses pre-made functions from the header, string

void ReverseArray(char* apples); //This declares the function prototype named ReverseArray with the parameter of the pointer to the character, apples


int main() //This is the main function (or the gateway of the program)
{
	int i; //Declares the local integer variable, i (to be used later)

	char tires[80]; //Declares a character array of length 80 bytes named tires

    strcpy(tires,"Whitewalls are best"); //This copies a string from a source ("Whitewalls are best") to the pointer of a destination ("tires" in this case)

    printf ("Tires is located at %p\n",tires); //Prints the contents of the nameless string, "Tires is located at <address of the string "tires"> \n"


	for (i=0; i<10; i++) //Declares a for loop with the initializer i=0, the test condition i<10, and the increment i=i+1
	{
	    printf ("Tires[%d] = %c at %p\n",i,tires[i], &tires[i]); //Defines the action of the for loop. Prints the nameless string "Tires[i] = [ASCII letter] at <i character of the string "tires" address> \n"
		//printf ("Tires[%d] = %d at %p\n",i,tires[i], &tires[i]); //Similar, using a decimal number instead of an ASCII letter
		//printf ("Tires[%d] = %c at %p\n",i,*(tires+i), tires+i); //Similar, uses a different format for arrays
	}


     ReverseArray(tires); //Calls on the void function ReverseArray using the parameter string "tires"

     printf("The return string is: %s\n",tires); //Prints the nameless string "The return string is: <"tires" array, reversed by ReverseArray> \n"

	return 0; //This returns the function back to Windows
}

void ReverseArray(char* apples) //Defines the void function ReverseArray using the parameter, character pointer "apples"
{
    int i,j, length=0; //Declares the local integer variables i, j, and length (Also assigns the value of 0 to length)
    char temp; //Declares the character variable, temp

    length = strlen(apples); //Assigns the value of the string length of apples to the integer variable, length
    printf("found length =%d\n",length); //Prints the nameless string "found length = <decimal value of length> \n"

    for(i=0, j=length-1; i<j; i++, j--) //Declares a for loop with the initializers i=0 and j=length-1, the test condition i<j, and the increments i=i+1 and j=j-1
    {
        temp = apples[i]; //Assigns the value of byte i in the string called apples to the integer variable, temp
        apples[i] = apples[j]; //Assigns the value of byte j in the string called apples to the byte i of the string, apples
        apples[j] = temp; //Assigns the value of the integer variable, temp to the byte j in the string called apples
       // printf("i=%d\n",i); //Prints the nameless string "i=<decimal value of i> \n"
    }

    return; //This returns the function to a operator (since it's a void function it automatically goes to Windows (known as 0)
}
