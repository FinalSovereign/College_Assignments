/*  File: Sphere.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   29 March, 2018

    Class Sphere simulates a Sphere shape.
 */

/**
 * A class that represents a Sphere shape. It includes the center point of the
 * shape and its radius.
 */
public class Sphere extends Shape
{

    // instance variable
    private final int radius;

    /**
     * Constructor for a Sphere, which sets its center and radius.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param z the z-coordinate of the point
     * @param radius the radius of the Sphere
     */
    public Sphere(int x, int y, int z, int radius)
    {
        super(x, y, z);
        this.radius = radius;
    }

    /**
     * Implementation of an abstract method to calculate the surface area of a
     * sphere.
     *
     * @return surface area of the current Sphere
     */
    @Override
    public double calcSurfaceArea()
    {
        return (4 * Math.PI * Math.pow(this.radius, 2));
    }

    /**
     * Implementation of an abstract method to calculate the volume of a sphere.
     *
     * @return volume of the current Sphere
     */
    @Override
    public double calcVolume()
    {
        return ((4 * Math.PI * Math.pow(this.radius, 3)) / 3);
    }

    /**
     * Overridden method to create a String representation of a Sphere object.
     *
     * @return String representation of this Sphere
     */
    @Override
    public String toString()
    {
        String str = "";

        str += String.format("%s%-12s ", this.getClass().getSimpleName(), ":");
        str += String.format("%s%-15s", "Center at ", super.toString());
        str += String.format("%12s%-5s", "Radius: ", this.radius);

        return str;
    }
}
