/*  File: Polynomial.java

    Author: Carlos Rivera (Class skeleton by Greg Shaw)
    PID:    5063909
    Date:   01 February, 2018

    A Polynomial class has an expression of terms, sorted in exponent
    ascending order
*/
import java.util.ArrayList;

/**
 * A class that represents a polynomial, an expression of terms.
 */
public class Polynomial {

    // instance variable
    private ArrayList<Term> polynomial; //ArrayList that represents a polynomial

    /**
     * Creates a Polynomial object.
     */
    public Polynomial() {
        this.polynomial = new ArrayList<Term>();
    }

    /**
     * Adds a term to the polynomial in the proper position (exponents in
     * ascending order).
     *
     * @param coeff coefficient of the term to be added
     * @param expo exponent of the term to be added
     */
    public void addTerm(int coeff, int expo) {
        int size = this.polynomial.size(); //The # of terms in the polynomial

        if (!this.polynomial.isEmpty()) {
            // Algorithm for determining where to add the term 
            if (expo < this.polynomial.get(0).getExpo()) {
                this.polynomial.add(0, new Term(coeff, expo));
            } else if (expo >= this.polynomial.get(size - 1).getExpo()) {
                this.polynomial.add(new Term(coeff, expo));
            } else {
                for (int i = 0; i < size; i++) {
                    if (expo >= this.polynomial.get(i).getExpo()) {
                        this.polynomial.add(i + 1, new Term(coeff, expo));
                        i = size;
                    }
                }
            }
        } else {
            // Default action for a polynomial with no terms
            this.polynomial.add(new Term(coeff, expo));
        }
    }

    /**
     * Returns a String representation of the Polynomial object.
     *
     * @return the polynomial as a String
     */
    @Override
    public String toString() {
        // Default case for a polynomial with no terms
        if (this.polynomial.isEmpty()) {
            return null;
        }
        
        // Combines like terms in the polynomial before printing them
        this.collectTerms();

        String poly = this.polynomial.get(0).toString(); //String representation

        // Adds more terms to the string, with a plus sign separating each one
        for (int i = 1; i < this.polynomial.size(); i++) {
            poly += " + " + this.polynomial.get(i).toString();
        }

        return poly;
    }

    /**
     * Combines all like terms in the polynomial. (Assumes coefficients are
     * positive and nonzero)
     */
    private void collectTerms() {
        ArrayList<Term> copy = new ArrayList<Term>(); // polynomial placeholder
        int coeff = 0; // Sum of the like terms' coefficients
        int size = this.polynomial.size(); // The # of terms in the polynomial

        // Systematically combines like terms.
        for (int i = 0; i <= this.polynomial.get(size - 1).getExpo(); i++) {
            for (int j = 0; j < this.polynomial.size(); j++) {
                Term x = this.polynomial.get(j);

                if (x.getExpo() == i) {
                    coeff += x.getCoeff();
                }
            }

            if (coeff != 0) {
                copy.add(new Term(coeff, i));
                coeff = 0;
            }
        }

        this.polynomial = copy;
    }

    /**
     * Multiples one polynomial with another and returns the product.
     *
     * @param p second polynomial being multiplied
     * @return the product of the polynomial multiplication
     */
    public Polynomial polyMultiply(Polynomial p) {
        Polynomial x = new Polynomial(); // Polynomial placeholder

        // Systematically multiplies two terms, one from each polynomial
        for (int i = 0; i < this.polynomial.size(); i++) {
            Term y = this.polynomial.get(i);

            for (int j = 0; j < p.polynomial.size(); j++) {
                Term z = p.polynomial.get(j);

                x.polynomial.add(new Term(y.getCoeff() * z.getCoeff(),
                        y.getExpo() + z.getExpo()));
            }
        }

        return x;
    }

    /**
     * Adds one polynomial with another and returns the sum.
     *
     * @param p second polynomial being added
     * @return the sum of the polynomial addition
     */
    public Polynomial polyAdd(Polynomial p) {
        int size; // The # of terms in the polynomial (dynamically changes)
        Polynomial x = new Polynomial(); // Polynomial placeholder

        // Copies the first polynomial into the placeholder, x.
        for (int c = 0; c < this.polynomial.size(); c++) {
            x.polynomial.add(c, this.polynomial.get(c));
        }

        // Adds all the terms from the second polynomial to the placeholder, x.
        for (int i = 0; i < p.polynomial.size(); i++) {
            Term term = p.polynomial.get(i);
            size = x.polynomial.size();

            for (int j = 0; j < size; j++) {
                if (term.getExpo()
                        >= x.polynomial.get(size - 1 - j).getExpo()) {
                    x.polynomial.add(size - j, term);
                    j = size;
                }
            }
        }
        
        return x;
    }
}
