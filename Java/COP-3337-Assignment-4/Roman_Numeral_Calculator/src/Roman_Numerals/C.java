/*  File: C.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class C represents the Roman numeral C, which is equivalent to the Arabic
    numeral 100.
 */
package Roman_Numerals;

/**
 * A class that represents the Roman numeral, C.
 */
public class C implements RomanNumeral
{

    /**
     * Returns a String for the Roman numeral, C.
     *
     * @return the String representation of the Roman numeral
     */
    @Override
    public String getRomNumVal()
    {
        return "C";
    }

    /**
     * Returns an Arabic numeral (as an integer) for the Roman numeral, C.
     *
     * @return the Arabic numeral representation of the Roman numeral
     */
    @Override
    public int getNumVal()
    {
        return 100;
    }
}
