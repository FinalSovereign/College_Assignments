/*  File: PascalTriangleTester.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   22 February, 2018

    Test class PascalTriangleTester checks for the functionality of the
    PascalTriangle class methods.
 */

import javax.swing.JOptionPane;

/**
 * Test class for the PascalTriangle class.
 */
public class PascalsTriangleTester
{

    /**
     * This code tests the operation of the PascalTriangle class, to see if it
     * can correctly create and display a Pascal's Triangle. It also asks for
     * user input for a customizable triangle, with while loops to prevent
     * incorrect inputs from being used.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        // instance variables
        int numRows = 0;
        boolean retry = true;
        boolean validIn = false;

        /*
            This first while loop is for checking if the user wants to make
            another triangle.
         */
        while (retry)
        {
            /*
                This second while loop is for checking if the input is an
                integer between 1 and 13, inclusive.
            
                NOTE: A single boolean is used for this loop and the following
                      loop solely to save the memory. In this program, it would
                      not matter if a second boolean was used but the
                      opportunity was there to optimize, even if it was minor.
             */
            while (!validIn)
            {
                /*
                    This third while loop is for checking if the input is an
                    actual integer. Sadly, it is a precise method so if you
                    input any characters that are not numbers it will not be
                    accepted. (i.e. "12" is fine but " 12" is not)
                 */
                while (!validIn)
                {
                    /*
                        This try-catch block is here to catch any thrown
                        exceptions from the Integer.parseInt() method and give a
                        warning message before asking for a new input.
                     */
                    try
                    {
                        numRows = Integer.parseInt(JOptionPane.showInputDialog(
                                null, "Input a valid integer between 1 and 13:",
                                "Enter an Integer", JOptionPane.PLAIN_MESSAGE));
                        validIn = true;
                    } catch (NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null,
                                "Invalid input. Please input a real integer.",
                                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Resets the boolean so it does not exit the second loop
                validIn = false;

                // Checks if the input is within the acceptable limits
                if (numRows >= 1 && numRows <= 13)
                {
                    validIn = true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "Invalid integer. Please input another one.",
                            "Invalid Integer", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Creates the triangle with the requested rows and prints it
            PascalsTriangle pascals = new PascalsTriangle(numRows);
            System.out.println(pascals.toString());

            // Asks if the user wants to create another triangle
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to "
                    + "make another Pascal's Triangle?", "Want to Retry?",
                    JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION)
            {
                validIn = false;
            }
            else if (choice == JOptionPane.NO_OPTION)
            {
                retry = false;
            }
        }
    }

}
