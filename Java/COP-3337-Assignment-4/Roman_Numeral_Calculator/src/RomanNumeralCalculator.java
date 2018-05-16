/*  File: RomanNumeralCalculator.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   6 March, 2018

    Class RomanNumeralCalculator creates its own implementations of the five
    basic operations (+, -, *, /, %) to work with Roman numerals (as Strings).
 */

/**
 * A class that can compute the five basic operations (+, -, *, /, %) with Roman
 * numerals.
 */
public class RomanNumeralCalculator
{

    /**
     * Computes a Roman numeral based on a left Roman numeral operand, a right
     * Roman numeral operand and the operation being done. This is returned as a
     * formatted String of the equations, both in Roman and Arabic numerals.
     *
     * @param rm_1 left Roman numeral operand
     * @param rm_2 right Roman numeral operand
     * @param op operation to be performed
     * @return a formatted String representation of the equations
     */
    public static String compute(RomanNumber rm_1, RomanNumber rm_2, String op)
    {
        RomanNumber result; // The result of the evaluation, as a Roman numeral
        String output = ""; // The formatted equations, in Roman and Arabic

        switch (op)
        {
            case "+":
                result = new RomanNumber(RomanNumber.getNum(rm_1)
                        + RomanNumber.getNum(rm_2));

                output = RomanNumeralCalculator.createOutput(rm_1, rm_2, op,
                        result, output);
                break;

            case "-":
                result = new RomanNumber(RomanNumber.getNum(rm_1)
                        - RomanNumber.getNum(rm_2));

                output = RomanNumeralCalculator.createOutput(rm_1, rm_2, op,
                        result, output);
                break;

            case "*":
                result = new RomanNumber(RomanNumber.getNum(rm_1)
                        * RomanNumber.getNum(rm_2));

                output = RomanNumeralCalculator.createOutput(rm_1, rm_2, op,
                        result, output);
                break;

            /*
                Due to limitations of the Roman Numeral system, decimals can
                only be calculated in units of "uncia" or 1/12. As such, for
                simplicity, decimals are ignored and only the floor value of the
                quotient is considered. (i.e. 2 - 0.25 = 1 instead of 1.75)
                
                It could also be possible to do the modulus of the division and
                write that as an extra numeral but I don't believe the Romans
                conceived a system to do that formally.
             */
            case "/":
                result = new RomanNumber(RomanNumber.getNum(rm_1)
                        / RomanNumber.getNum(rm_2));

                output = RomanNumeralCalculator.createOutput(rm_1, rm_2, op,
                        result, output);
                break;

            case "%":
                result = new RomanNumber(RomanNumber.getNum(rm_1)
                        % RomanNumber.getNum(rm_2));

                output = RomanNumeralCalculator.createOutput(rm_1, rm_2, op,
                        result, output);
                break;
        }

        return output;
    }

    /**
     * Creates a formatted String of the equations, both in Roman and Arabic
     * numerals.
     *
     * NOTE: This is used solely in the compute() method to reduce the amount of
     * code redundancy.
     *
     * @param rm_1 left Roman numeral operand
     * @param rm_2 right Roman numeral operand
     * @param op operation to be performed
     * @param rm_3 Roman numeral result
     * @param output String object to contain the formatted equations
     * @return a String representation of the equations
     */
    private static String createOutput(RomanNumber rm_1, RomanNumber rm_2,
            String op, RomanNumber rm_3, String output)
    {
        String check = RomanNumeralCalculator.checkOverflow(rm_3);

        output += rm_1.toString() + " " + op + " " + rm_2.toString()
                + " = " + (check.equals("") ? rm_3.toString() : check) + "\n";
        output += RomanNumber.getNum(rm_1) + " " + op + " "
                + RomanNumber.getNum(rm_2) + " = "
                + RomanNumber.getNum(rm_3);

        return output;
    }

    /**
     * Checks whether the Roman numeral supplied is a valid Roman numeral. A
     * valid Roman numeral goes up to 3,999 or MMMCMXCIX.
     *
     * @param rm the Roman numeral being checked
     * @return a String that either is blank (valid) or the overflow message
     */
    private static String checkOverflow(RomanNumber rm)
    {
        if (RomanNumber.getNum(rm) > 3999 || RomanNumber.getNum(rm) < -3999)
        {
            return "Roman Numeral Overflow";
        }

        return "";
    }
}
