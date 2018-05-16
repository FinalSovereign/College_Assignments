/*  File: ShapeComparator.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   29 March, 2018

    Class ShapeComparator is an additional class needed to "re-sort" an array of
    Shape objects.
 */

import java.util.Comparator;

/**
 * A class that compares Shapes objects by their center's distance from the
 * origin. It will be used to sort an array of Shapes by this condition in
 * descending order.
 */
public class ShapeComparator implements Comparator
{

    /**
     * Overridden method to compare the Shape objects by their center's distance
     * from the origin, descending.
     *
     * @param firstObject First object to compare
     * @param secondObject Second object to compare
     * @return the order between the two objects, as an integer of -1, 0, or 1
     */
    @Override
    public int compare(Object firstObject, Object secondObject)
    {
        // Explicit casting of the two Object parameters
        Shape s1 = (Shape) firstObject;
        Shape s2 = (Shape) secondObject;

        // Store the method results in a variable to stop needless processing 
        double d1 = s1.calcDistance();
        double d2 = s2.calcDistance();

        if (d1 < d2)
        {
            return 1; // Puts object firstObject ahead of secondObject
        }
        else if (d1 > d2)
        {
            return -1; // Puts object secondObject ahead of firstObject
        }
        else
        {
            return 0; // Both are equal
        }
    }
}
