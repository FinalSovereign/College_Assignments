/*  File: M.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class M represents the Roman numeral M, which is equivalent to the Arabic
    numeral 1,000.
 */
package Roman_Numerals;

/**
 * A class that represents the Roman numeral, M.
 */
public class M implements RomanNumeral
{

    /**
     * Returns a String for the Roman numeral, M.
     *
     * @return the String representation of the Roman numeral
     */
    @Override
    public String getRomNumVal()
    {
        return "M";
    }

    /**
     * Returns an Arabic numeral (as an integer) for the Roman numeral, M.
     *
     * @return the Arabic numeral representation of the Roman numeral
     */
    @Override
    public int getNumVal()
    {
        return 1000;
    }
}
