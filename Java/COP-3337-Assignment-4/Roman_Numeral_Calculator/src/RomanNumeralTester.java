/*  File: RomanNumeralTester.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Test class RomanNumeralTester checks for the functionality of the
    RomanNumeralCalculator and RomanNumber class methods.
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

/**
 * Test class for the RomanNumeralCalculator class.
 */
public class RomanNumeralTester
{

    /**
     * This code tests the operation of the RomanNumeralCalculator and
     * RomanNumber classes.
     *
     * @param args command-line arguments
     * @throws IOException if the input file in question cannot be opened
     */
    public static void main(String[] args) throws IOException
    {
        // instance variable
        Scanner inFile = new Scanner(new File("./misc/roman.txt"));

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
               Assuming the input file follows the order of [Roman numeral]
               [operation] [Roman numeral], this loop will attempt to calculate
               the expression
             */
            while (inFile.hasNext())
            {
                RomanNumber rm_1 = new RomanNumber(inFile.next());
                String op = inFile.next();
                RomanNumber rm_2 = new RomanNumber(inFile.next());

                /*
                    To save a little memory, a String array is used so that the
                    resulting String from RomanNumeralCalculator.compute(),
                    which is already formatted with a new character, can
                    correctly printed to the output file.
                */
                String[] output = RomanNumeralCalculator.compute(rm_1, rm_2, op)
                        .split("\n");
                System.out.println(output[0] + "\n" + output[1] + "\n");
                outFile.println(output[0]);
                outFile.println(output[1]);
                outFile.println();
            }
        }
    }
}
