/*  File: Cone.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   29 March, 2018

    Class Cone simulates a Cone shape.
 */

/**
 * A class that represents a Cone shape. It includes the center point of the
 * shape, its radius and its height.
 */
public class Cone extends Shape
{

    // instance variables
    private final int radius;
    private final int height;

    /**
     * Constructor for a Cone, which sets its center, radius and height.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param z the z-coordinate of the point
     * @param radius the radius of the Sphere
     * @param height the height of the Sphere
     */
    public Cone(int x, int y, int z, int radius, int height)
    {
        super(x, y, z);
        this.radius = radius;
        this.height = height;
    }

    /**
     * Implementation of an abstract method to calculate the surface area of a
     * cone.
     *
     * @return surface area of the current Cone
     */
    @Override
    public double calcSurfaceArea()
    {
        return (Math.PI * this.radius
                * (this.radius + Math.sqrt(
                        Math.pow(this.radius, 2)
                        + Math.pow(this.height, 2))));
    }

    /**
     * Implementation of an abstract method to calculate the volume of a cone.
     *
     * @return surface area of the current Cone
     */
    @Override
    public double calcVolume()
    {
        return ((Math.PI * Math.pow(this.radius, 2) * this.height) / 3);
    }

    /**
     * Overridden method to create a String representation of a Cone object.
     *
     * @return String representation of this Cone
     */
    @Override
    public String toString()
    {
        String str = "";

        str += String.format("%s%-14s ", this.getClass().getSimpleName(), ":");
        str += String.format("%s%-15s", "Center at ", super.toString());
        str += String.format("%12s%-5s", "Radius: ", this.radius);
        str += String.format("%12s%-5s", "Height: ", this.height);

        return str;
    }
}
