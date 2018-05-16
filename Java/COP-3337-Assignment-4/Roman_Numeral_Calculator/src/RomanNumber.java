/*  File: RomanNumber.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class RomanNumber simulates a real Roman numeral up to the equivalent of the
    Arabic number +/-3999. It allows for conversion between the two systems.
 */

import java.util.ArrayList;
import Roman_Numerals.*;

/**
 * A class that represents a Roman numeral up to the equivalent of the Arabic
 * number +/-3999. It has ways of converting between the two systems.
 *
 * NOTE: This class can be amended with more Roman numerals, as long as you
 * create the classes and include the instance check in the corresponding
 * methods (getNum and createRomNum).
 */
public class RomanNumber
{

    // instance variables
    private ArrayList<RomanNumeral> romNum = new ArrayList<>(); // Roman numeral
    private boolean isNegative = false; // Designates if it is negative

    /**
     * Constructor that is used if you have the String representation of the
     * Roman numeral.
     *
     * @param romNum String representation of the Roman numeral
     */
    public RomanNumber(String romNum)
    {
        createRomNum(romNum);
    }

    /**
     * Constructor that is used if you have the Arabic numeral representation of
     * the Roman numeral.
     *
     * @param num Arabic numeral representation of the Roman numeral
     */
    public RomanNumber(int num)
    {
        createRomNum(RomanNumber.getRomNum(num));
    }

    /**
     * Simply adds a Roman numeral to the end of this Roman numeral.
     *
     * @param r a RomanNumeral object to be added to this Roman numeral
     */
    public void addRomNum(RomanNumeral r)
    {
        this.romNum.add(r);
    }

    /**
     * Adds a Roman numeral to a specific position in this Roman numeral.
     *
     * @param r a RomanNumeral object to be added to this Roman numeral
     * @param index a position in this Roman numeral
     */
    public void addRomNum(RomanNumeral r, int index)
    {
        this.romNum.add(index, r);
    }

    /**
     * Converts a RomanNumber (representing a Roman numeral) into an Arabic
     * numeral.
     *
     * @param rm the RomanNumber to be converted
     * @return a Arabic numeral (number) representation of the RomanNumber
     */
    public static int getNum(RomanNumber rm)
    {
        int num = 0; // Placeholder for the conversion

        // Checks if positive, adds to num if so.
        if (!rm.isNegative)
        {
            for (int i = 0; i < rm.romNum.size(); i++)
            {
                RomanNumeral r = rm.romNum.get(i);

                if (r instanceof C)
                {
                    try
                    {
                        if (rm.romNum.get(i + 1) instanceof M)
                        {
                            num += rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else if (rm.romNum.get(i + 1) instanceof D)
                        {
                            num += rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else
                        {
                            num += r.getNumVal();
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        num += r.getNumVal();
                    }
                }
                else if (r instanceof X)
                {
                    try
                    {
                        if (rm.romNum.get(i + 1) instanceof C)
                        {
                            num += rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else if (rm.romNum.get(i + 1) instanceof L)
                        {
                            num += rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else
                        {
                            num += r.getNumVal();
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        num += r.getNumVal();
                    }
                }
                else if (r instanceof I)
                {
                    try
                    {
                        if (rm.romNum.get(i + 1) instanceof X)
                        {
                            num += rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else if (rm.romNum.get(i + 1) instanceof V)
                        {
                            num += rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else
                        {
                            num += r.getNumVal();
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        num += r.getNumVal();
                    }
                }
                else
                {
                    num += r.getNumVal();
                }
            }
        }
        // Checks if negative, subtracts from num if so.
        else if (rm.isNegative)
        {
            for (int i = 0; i < rm.romNum.size(); i++)
            {
                RomanNumeral r = rm.romNum.get(i);

                if (r instanceof C)
                {
                    try
                    {
                        if (rm.romNum.get(i + 1) instanceof M)
                        {
                            num -= rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else if (rm.romNum.get(i + 1) instanceof D)
                        {
                            num -= rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else
                        {
                            num -= r.getNumVal();
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        num -= r.getNumVal();
                    }
                }
                else if (r instanceof X)
                {
                    try
                    {
                        if (rm.romNum.get(i + 1) instanceof C)
                        {
                            num -= rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else if (rm.romNum.get(i + 1) instanceof L)
                        {
                            num -= rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else
                        {
                            num -= r.getNumVal();
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        num -= r.getNumVal();
                    }
                }
                else if (r instanceof I)
                {
                    try
                    {
                        if (rm.romNum.get(i + 1) instanceof X)
                        {
                            num -= rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else if (rm.romNum.get(i + 1) instanceof V)
                        {
                            num -= rm.romNum.get(i + 1).getNumVal()
                                    - r.getNumVal();
                            i++;
                        }
                        else
                        {
                            num -= r.getNumVal();
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        num -= r.getNumVal();
                    }
                }
                else
                {
                    num -= r.getNumVal();
                }
            }
        }

        return num;
    }

    /**
     * Converts an Arabic numeral into the String version of its corresponding
     * Roman numeral.
     *
     * @param num the Arabic numeral to be converted
     * @return a String representation of the corresponding Roman numeral
     */
    public static String getRomNum(int num)
    {
        String romNum = ""; // Placeholder for the conversion

        if (num > 0)
        {
            romNum = RomanNumber.numToRomNum(num, romNum);
        }
        else if (num < 0)
        {
            romNum += "-";

            romNum += RomanNumber.numToRomNum(Math.abs(num), romNum);
        }

        return romNum;
    }

    /**
     * Systematically whittles down an Arabic numeral into its corresponding
     * Roman numeral (as a String).
     *
     * NOTE: This is used to save some code redundancy in the method getRomNum()
     * and should not be used in any other method.
     *
     * @param num the Arabic numeral to be converted
     * @param romNum String object to contain the Roman numeral
     * @return a String representation of the corresponding Roman numeral
     */
    private static String numToRomNum(int num, String romNum)
    {
        while (num > 0)
        {
            if (num - 1000 >= 0)
            {
                romNum += "M";
                num -= 1000;
            }
            else if (num - 900 >= 0)
            {
                romNum += "CM";
                num -= 900;
            }
            else if (num - 500 >= 0)
            {
                romNum += "D";
                num -= 500;
            }
            else if (num - 400 >= 0)
            {
                romNum += "CD";
                num -= 400;
            }
            else if (num - 100 >= 0)
            {
                romNum += "C";
                num -= 100;
            }
            else if (num - 90 >= 0)
            {
                romNum += "XC";
                num -= 90;
            }
            else if (num - 50 >= 0)
            {
                romNum += "L";
                num -= 50;
            }
            else if (num - 40 >= 0)
            {
                romNum += "XL";
                num -= 40;
            }
            else if (num - 10 >= 0)
            {
                romNum += "X";
                num -= 10;
            }
            else if (num - 9 >= 0)
            {
                romNum += "IX";
                num -= 9;
            }
            else if (num - 5 >= 0)
            {
                romNum += "V";
                num -= 5;
            }
            else if (num - 4 >= 0)
            {
                romNum += "IV";
                num -= 4;
            }
            else
            {
                romNum += "I";
                num -= 1;
            }
        }

        return romNum;
    }

    /**
     * This initially creates the Roman numeral, as represented by the
     * ArrayList-of-RomanNumeral. This should only be used in the constructor.
     *
     * @param romNum a String representation of the Roman numeral
     */
    private void createRomNum(String romNum)
    {
        // Simply forces all letters to be capital, for easier checking.
        romNum = romNum.toUpperCase();

        // Checks if the inputted Roman numeral String is empty, or "0".
        if (romNum.equals(""))
        {
            return;
        }
        // For the sake of consistence, checks to see if the String is negative.
        else if (romNum.charAt(0) == '-')
        {
            this.isNegative = true;
        }

        /*
            Checks each letter and, if a valid Roman numeral, adds it to this
            Roman numeral.
        
            NOTE: For new Roman numeral, add its object as a case statement.
         */
        for (int i = 0; i < romNum.length(); i++)
        {
            switch (romNum.charAt(i))
            {
                case 'I':
                    this.romNum.add(new I());
                    break;

                case 'V':
                    this.romNum.add(new V());
                    break;

                case 'X':
                    this.romNum.add(new X());
                    break;

                case 'L':
                    this.romNum.add(new L());
                    break;

                case 'C':
                    this.romNum.add(new C());
                    break;

                case 'D':
                    this.romNum.add(new D());
                    break;

                case 'M':
                    this.romNum.add(new M());
                    break;
            }
        }
    }

    /**
     * Creates a String representation of this Roman numeral.
     *
     * @return a String representation of the Roman numeral
     */
    @Override
    public String toString()
    {
        String romNum = ""; // Placeholder for the following operations

        // Checks for a zero value, prints out the Roman word for "none"
        if (this.romNum.isEmpty())
        {
            return "[Nulla]";
        }

        /* 
            Checks if the Roman numeral is negative, a concept which wasn't in
            the original system. For the sake of consistence, a negative sign is
            added instead of just leaving it the same as its positive version.
         */
        if (this.isNegative)
        {
            romNum = "-";
        }

        // Goes through each individual numeral in this Roman Numeral
        for (RomanNumeral rn : this.romNum)
        {
            romNum += rn.getRomNumVal();
        }

        return romNum;
    }
}
