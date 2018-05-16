/*  File: Point3D.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   29 March, 2018

    Class Point3D simulates a point in 3D space.
 */

/**
 * A class that represents a point in 3D space. It does not need basic setter
 * methods because the values should only be changed once.
 */
public class Point3D
{

    // instance variables
    private final int x;
    private final int y;
    private final int z;

    /**
     * Constructor for the point in 3D space.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param z the z-coordinate of the point
     */
    public Point3D(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Getter method for the instance variable named x, which represents the
     * x-coordinate.
     *
     * @return the x-coordinate of the point
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Getter method for the instance variable named y, which represents the
     * y-coordinate.
     *
     * @return the y-coordinate of the point
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Getter method for the instance variable named z, which represents the
     * z-coordinate.
     *
     * @return the z-coordinate of the point
     */
    public int getZ()
    {
        return this.z;
    }

    /**
     * Overridden method to create a String representation of the point in 3D
     * space.
     *
     * @return String representation of this point
     */
    @Override
    public String toString()
    {
        String str = "P(" + this.x + ", " + this.y + ", " + this.z + ")";

        return str;
    }
}
