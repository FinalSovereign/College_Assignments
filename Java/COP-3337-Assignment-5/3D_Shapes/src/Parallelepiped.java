/*  File: Parallelepiped.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   29 March, 2018

    Class Parallelepiped simulates a (rectangular) Parallelepiped shape.
 */

/**
 * A class that represents a Parallelepiped shape. It includes the center point
 * of the shape, its length, its width and its height.
 */
public class Parallelepiped extends Shape
{

    // instance varaibles
    private final int length;
    private final int width;
    private final int height;

    /**
     * Constructor for a Parallelepiped, which sets its center, length, width
     * and height.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param z the z-coordinate of the point
     * @param length the length of the Sphere
     * @param width the width of the Sphere
     * @param height the height of the Sphere
     */
    public Parallelepiped(int x, int y, int z, int length, int width,
            int height)
    {
        super(x, y, z);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Implementation of an abstract method to calculate the surface area of a
     * parallelepiped.
     *
     * @return surface area of the current Parallelepiped
     */
    @Override
    public double calcSurfaceArea()
    {
        return ((2 * (this.length + this.width)) * this.height
                + (2 * (this.length * this.width)));
    }

    /**
     * Implementation of an abstract method to calculate the volume of a
     * Parallelepiped.
     *
     * @return volume of the current Parallelepiped
     */
    @Override
    public double calcVolume()
    {
        return (this.length * this.width * this.height);
    }

    /**
     * Overridden method to create a String representation of a Parallelepiped
     * object.
     *
     * @return String representation of this Parallelepiped
     */
    @Override
    public String toString()
    {
        String str = "";

        str += String.format("%s%-4s ", this.getClass().getSimpleName(), ":");
        str += String.format("%s%-15s", "Center at ", super.toString());
        str += String.format("%12s%-5s", "Length: ", this.length);
        str += String.format("%12s%-5s", "Width: ", this.width);
        str += String.format("%12s%-5s", "Height: ", this.height);

        return str;
    }
}
