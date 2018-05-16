/*  File: OrderedListTester.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   10 April, 2018

    Test class OrderedListTester checks for the functionality of the
    OrderedList class and its methods.
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

/**
 * Test class for correct functionality of a generic ordered list.
 */
public class OrderedListTester
{
    /**
     * This code tests the operation of the OrderedList class and methods.
     *
     * @param args command-line arguments
     * @throws IOException if the output file in question cannot be opened
     */
    public static void main(String[] args) throws IOException
    {
        // instance variables
        OrderedList ordList = new OrderedList(null); // The list
        Scanner inFile = new Scanner(new File("./misc/ordlist.txt"));

        try (
                // PrintWriter object (technically an instance variable)
                PrintWriter outFile = new PrintWriter(new File(
                        "./src/output.txt")))
        {
            // Loops through each command until there are none left
            while (inFile.hasNext())
            {
                String command = inFile.next().toUpperCase();
                String input;

                switch (command)
                {
                    // For inserting a node/element
                    case "INSERT":
                        input = inFile.next();
                        ordList.insert(Integer.parseInt(input));
                        outFile.println(command + " " + input);
                        outFile.println(ordList);
                        break;
                    // For deleting a node/element
                    case "DELETE":
                        input = inFile.next();
                        outFile.println(command + " " + input);
                        if(!ordList.delete(Integer.parseInt(input)))
                        {
                            outFile.print("Cannot delete what is not there - ");
                        }
                        outFile.println(ordList);
                        break;
                    // For clearing the list
                    case "CLEAR":
                        ordList.clear();
                        outFile.println(command);
                        outFile.println(ordList);
                        inFile.nextLine();
                        break;
                    // For reversing the list
                    case "REVERSE":
                        ordList.reverse();
                        outFile.println(command);
                        outFile.println(ordList);
                        inFile.nextLine();
                        break;
                    // For typos and the like
                    default:
                        outFile.println("Incorrect method");
                        outFile.println(ordList);
                        inFile.next();
                        break;
                }
            }
        }
    }

}
