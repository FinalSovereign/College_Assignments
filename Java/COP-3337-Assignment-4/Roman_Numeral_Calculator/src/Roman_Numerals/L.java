/*  File: L.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class L represents the Roman numeral L, which is equivalent to the Arabic
    numeral 50.
 */
package Roman_Numerals;

/**
 * A class that represents the Roman numeral, L.
 */
public class L implements RomanNumeral
{

    /**
     * Returns a String for the Roman numeral, L.
     *
     * @return the String representation of the Roman numeral
     */
    @Override
    public String getRomNumVal()
    {
        return "L";
    }

    /**
     * Returns an Arabic numeral (as an integer) for the Roman numeral, L.
     *
     * @return the Arabic numeral representation of the Roman numeral
     */
    @Override
    public int getNumVal()
    {
        return 50;
    }
}
