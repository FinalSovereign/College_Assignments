/*  File: X.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class X represents the Roman numeral X, which is equivalent to the Arabic
    numeral 10.
 */
package Roman_Numerals;

/**
 * A class that represents the Roman numeral, X.
 */
public class X implements RomanNumeral
{

    /**
     * Returns a String for the Roman numeral, X.
     *
     * @return the String representation of the Roman numeral
     */
    @Override
    public String getRomNumVal()
    {
        return "X";
    }

    /**
     * Returns an Arabic numeral (as an integer) for the Roman numeral, X.
     *
     * @return the Arabic numeral representation of the Roman numeral
     */
    @Override
    public int getNumVal()
    {
        return 10;
    }
}
