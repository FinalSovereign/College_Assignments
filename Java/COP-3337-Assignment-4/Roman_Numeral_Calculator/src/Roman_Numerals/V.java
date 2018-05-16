/*  File: V.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class V represents the Roman numeral V, which is equivalent to the Arabic
    numeral 5.
 */
package Roman_Numerals;

/**
 * A class that represents the Roman numeral, V.
 */
public class V implements RomanNumeral
{

    /**
     * Returns a String for the Roman numeral, V.
     *
     * @return the String representation of the Roman numeral
     */
    @Override
    public String getRomNumVal()
    {
        return "V";
    }

    /**
     * Returns an Arabic numeral (as an integer) for the Roman numeral, V.
     *
     * @return the Arabic numeral representation of the Roman numeral
     */
    @Override
    public int getNumVal()
    {
        return 5;
    }
}
