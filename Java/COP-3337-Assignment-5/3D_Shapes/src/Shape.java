/*  File: Shape.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   29 March, 2018

    Abstract class Shape simulates an unspecified 3D shape.
 */

/**
 * A class that represents an unspecified 3D shape. It does not need basic
 * setter and getter methods because both the values should only be changed once
 * and the calls to the instance variable should only happen internally.
 *
 * NOTE: This is an abstract class so an object can never be a Shape object,
 * only a Shape reference (variable). It is also the superclass for any
 * derivative shape classes.
 */
public abstract class Shape implements Comparable
{

    // instance varaible (inherited by subclasses)
    private final Point3D center;

    /**
     * Constructor for the unspecified shape, which creates its center.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param z the z-coordinate of the point
     */
    public Shape(int x, int y, int z)
    {
        this.center = new Point3D(x, y, z);
    }

    /**
     * This method calculates the distance from the center of the unspecified
     * shape and the origin (0, 0, 0).
     *
     * @return the distance from the center to the origin
     */
    public final double calcDistance()
    {
        return Math.sqrt(Math.pow(this.center.getX(), 2)
                + Math.pow(this.center.getY(), 2)
                + Math.pow(this.center.getZ(), 2));
    }

    /**
     * Abstract declaration of a method that calculates surface area that is to
     * be implemented by subclasses.
     *
     * @return surface area of the shape
     */
    public abstract double calcSurfaceArea();

    /**
     * Abstract declaration of a method that calculates volume that is to be
     * implemented by subclasses.
     *
     * @return volume of the shape
     */
    public abstract double calcVolume();

    /**
     * Overridden method to compare the Shape objects by volume, ascending.
     *
     * @param o Object to compare the current Shape to
     * @return the order between the two objects, as an integer of -1, 0, or 1
     */
    @Override
    public final int compareTo(Object o)
    {
        /*
            Explicit cast of the Object parameter because the Comparable
            interface keeps it as a general object instead of a Shape object
         */
        Shape otherObject = (Shape) o;

        if (this.calcVolume() > otherObject.calcVolume())
        {
            return 1; // This means the current Shape is after the parameter
        }
        else if (this.calcVolume() < otherObject.calcVolume())
        {
            return -1; // This means the current Shape is before the parameter
        }
        else
        {
            return 0; // This means both are equal
        }
    }

    /**
     * Overridden method to create a String representation of the center of this
     * unspecified shape.
     *
     * @return String representation of the center
     */
    @Override
    public String toString()
    {
        return this.center.toString();
    }
}
