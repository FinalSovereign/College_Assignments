/*  File: PascalTriangle.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   22 February, 2018

    Class PascalTriangle is the framework of a Pascal's Triangle between 1 and
    13 rows, which includes a system to create it and a system to print it.
 */

/**
 * A class that represents a Pascal's Triangle between 1 and 13 rows. It
 * includes how the triangle is made and how it is printed.
 *
 * NOTE: This class creates the triangles with an additional "buffer" column on
 *       both ends for the sake of a simpler algorithm, which will lead to
 *       inefficient use of memory for very large triangles. This class can
 *       create triangles with rows greater than 13 but will not print it
 *       correctly. Use at your own risk.
 */
class PascalsTriangle
{

    // instance variables
    private int[][] triangle; // 2-D int array that represents the triangle

    /**
     * Creates a PascalsTriangle object.
     *
     * @param numRows the number of rows the triangle will have
     */
    public PascalsTriangle(int numRows)
    {
        this.createTriangle(numRows);
    }

    /**
     * Creates a Pascal's Triangle based on the number of rows given. It makes
     * an irregular 2-D array and systematically adds the entries.
     *
     * NOTE: This can be remodeled to remove the extra zero columns but it was
     * noticed too late so the idea was scraped. It involves adding a for loop
     * to initialize the first and last values of each row as 1 and the current
     * loop to work on the rest. Sorry for the oversight.
     *
     * @param numRows the number of rows the triangle will have
     */
    private void createTriangle(int numRows)
    {
        this.triangle = new int[numRows][]; // Creates the frame for the array
        this.triangle[0] = new int[3]; // Creates the first row
        this.triangle[0][1] = 1; // Sets the 1 in its position

        // Systematically adds the numbers above a given spot
        for (int i = 1; i < this.triangle.length; i++)
        {
            this.triangle[i] = new int[i + 3];

            for (int j = 1; j < this.triangle[i].length - 1; j++)
            {
                this.triangle[i][j] = this.triangle[i - 1][j - 1]
                        + this.triangle[i - 1][j];
            }
        }
    }

    /**
     * Converts the Pascal's Triangle into a formatted, printable String.
     * 
     * NOTE: This is meant to only work with 3-digit numbers in the triangle.
     * 
     * @return a String representation of the requested Pascal's Triangle
     */
    @Override
    public String toString()
    {
        String triStr = ""; // Initial String
        String space = "   "; // Designated amount of padding. [Unnecessary]
        int numRow = this.triangle.length; // Number of rows. [Unnecessary]
        // Position of the "center" of the triangle
        int pos = (numRow % 2 == 0) ? (numRow / 2) : ((numRow / 2) + 1);

        // Systematically formats the String, based on the center's position
        for (int i = 0; i < numRow; i++)
        {
            int numVal = this.triangle[i].length - 2; // # of values in the row
            int index = pos - ((i + 1) / 2); // # of spaces until a value

            // Pads the String until it reaches a value
            for (int j = 0; j < index; j++)
            {
                triStr += "   " + space;
            }

            // Pads every other row to fix the "blockiness"
            triStr += ((i + 1) % 2 == 0) ? "   " : "";

            // Appends the values and spacing to the String
            for (int j = 1; j <= numVal; j++)
            {
                int val = this.triangle[i][j];

                // Only works with 3-digit values
                if (val < 10)
                {
                    triStr += "  " + val + space;
                }
                else if (val < 100)
                {
                    triStr += " " + val + space;
                }
                else
                {
                    triStr += val + space;
                }

            }

            triStr += "\n"; // End the row's representation in the String
        }

        return triStr;
    }
}
