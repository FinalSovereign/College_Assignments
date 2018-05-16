/*  File: GarageTester.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   13 February, 2018

    Test class GarageTester checks for the functionality of the Garage class
    methods.
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

/**
 * Test class for the Garage class.
 */
public class GarageTester
{

    /**
     * This code tests the operation of the Garage and Car classes, to see if it
     * can simulate a real garage.
     *
     * @param args command-line arguments
     * @throws IOException if the input file in question cannot be opened
     */
    public static void main(String[] args) throws IOException
    {
        // instance variables
        Garage lane = new Garage();
        Scanner inFile = new Scanner(new File("./misc/garage.txt"));

        /*
           This try construct opens the output file, tries to write to it and
           then closes the file automatically.
         */
        try (
                // PrintWriter object (technically an instance variable)
                PrintWriter outFile = new PrintWriter(new File(
                        "./src/output.txt")))
        {
            /*
               Assuming the input file follows the order of [license] [action],
               this loop will determine what each car wants to do and attempts
               to see if it can be done.
             */
            while (inFile.hasNext())
            {
                Car car = new Car(inFile.next());

                String action = inFile.next();

                if (action.equalsIgnoreCase("ARRIVE"))
                {
                    outFile.println(lane.arrive(car));
                }
                else if (action.equalsIgnoreCase("DEPART"))
                {
                    outFile.println(lane.depart(car));
                }
                else
                {
                    outFile.println("Action not recognized. Current car"
                            + "information is discarded");
                }
            }
        }
    }

}
