/*  File Term.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   01 February, 2018

    A Term class has the coefficient and exponent of a mathematical term
*/

/**
 * A class to represent a term in a mathematical expression. It assumes that
 * the variable is always x so the class is made up of a coefficient and an
 * exponent.
 */
public class Term {

    // instance variables
    private int coeff; //coefficient variable
    private int expo; //exponent variable

    /**
     * Creates a Term object.
     *
     * @param coeff the coefficient of the term
     * @param expo the exponent of the term
     */
    public Term(int coeff, int expo) {
        this.coeff = coeff;
        this.expo = expo;
    }

    /**
     * Returns a String representation of the Term object.
     *
     * @return the coefficient, variable and/or exponent (if applicable) as a
     * String
     */
    public String toString() {
        String term = "";

        // Checks for special cases with coefficients and exponents
        if (this.coeff == 1) {

        } else {
            term += "" + this.coeff;
        }

        if (this.expo == 0) {

        } else if (this.expo == 1) {
            term += "x";
        } else {
            term += "x^" + this.expo;
        }

        return term;
    }

    /**
     * Returns the coefficient of the Term object.
     *
     * @return the coefficient of the term
     */
    public int getCoeff() {
        return this.coeff;
    }

    /**
     * Returns the exponent of the Term object.
     *
     * @return the exponent of the term
     */
    public int getExpo() {
        return this.expo;
    }
}
