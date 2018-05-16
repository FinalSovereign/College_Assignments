/*  File: RomanNumeral.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Interface RomanNumeral provides a framework for what each valid Roman
    numeral class must have to function properly.
 */

package Roman_Numerals;

/**
 * An interface that represents any Roman numeral.
 */
public interface RomanNumeral
{
    /**
     * Abstraction of a method that returns a String for the Roman numeral.
     *
     * @return the String representation of the Roman numeral
     */
    String getRomNumVal();
    
    /**
     * Abstraction of a method that returns an Arabic numeral (as an integer)
     * for the Roman numeral.
     *
     * @return the Arabic numeral representation of the Roman numeral
     */
    int getNumVal();
}
