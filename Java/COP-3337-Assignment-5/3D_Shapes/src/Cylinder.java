/*  File: Cylinder.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   29 March, 2018

    Class Cylinder simulates a Cylinder shape.
 */

/**
 * A class that represents a Cylinder shape. It includes the center point of the
 * shape, its radius and its height.
 */
public class Cylinder extends Shape
{

    // instance variables
    private final int radius;
    private final int height;

    /**
     * Constructor for a Cylinder, which sets its center, radius and height.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param z the z-coordinate of the point
     * @param radius the radius of the Sphere
     * @param height the height of the Sphere
     */
    public Cylinder(int x, int y, int z, int radius, int height)
    {
        super(x, y, z);
        this.radius = radius;
        this.height = height;
    }

    /**
     * Implementation of an abstract method to calculate the surface area of a
     * cylinder.
     *
     * @return surface area of the current Cylinder
     */
    @Override
    public double calcSurfaceArea()
    {
        return ((2 * Math.PI * Math.pow(this.radius, 2))
                + (2 * Math.PI * this.radius * this.height));
    }

    /**
     * Implementation of an abstract method to calculate the volume of a
     * cylinder.
     *
     * @return surface area of the current Cylinder
     */
    @Override
    public double calcVolume()
    {
        return (Math.PI * Math.pow(this.radius, 2) * this.height);
    }

    /**
     * Overridden method to create a String representation of a Cylinder object.
     *
     * @return String representation of this Cylinder
     */
    @Override
    public String toString()
    {
        String str = "";

        str += String.format("%s%-10s ", this.getClass().getSimpleName(), ":");
        str += String.format("%s%-15s", "Center at ", super.toString());
        str += String.format("%12s%-5s", "Radius: ", this.radius);
        str += String.format("%12s%-5s", "Height: ", this.height);

        return str;
    }
}
