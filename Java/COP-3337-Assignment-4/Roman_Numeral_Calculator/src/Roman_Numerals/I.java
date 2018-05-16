/*  File: I.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class I represents the Roman numeral I, which is equivalent to the Arabic
    numeral 1.
 */
package Roman_Numerals;

/**
 * A class that represents the Roman numeral, I.
 */
public class I implements RomanNumeral
{

    /**
     * Returns a String for the Roman numeral, I.
     *
     * @return the String representation of the Roman numeral
     */
    @Override
    public String getRomNumVal()
    {
        return "I";
    }

    /**
     * Returns an Arabic numeral (as an integer) for the Roman numeral, I.
     *
     * @return the Arabic numeral representation of the Roman numeral
     */
    @Override
    public int getNumVal()
    {
        return 1;
    }
}
