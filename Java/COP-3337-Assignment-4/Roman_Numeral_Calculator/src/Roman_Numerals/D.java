/*  File: D.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class D represents the Roman numeral D, which is equivalent to the Arabic
    numeral 500.
 */
package Roman_Numerals;

/**
 * A class that represents the Roman numeral, D.
 */
public class D implements RomanNumeral
{

    /**
     * Returns a String for the Roman numeral, D.
     *
     * @return the String representation of the Roman numeral
     */
    @Override
    public String getRomNumVal()
    {
        return "D";
    }

    /**
     * Returns an Arabic numeral (as an integer) for the Roman numeral, D.
     *
     * @return the Arabic numeral representation of the Roman numeral
     */
    @Override
    public int getNumVal()
    {
        return 500;
    }
}
