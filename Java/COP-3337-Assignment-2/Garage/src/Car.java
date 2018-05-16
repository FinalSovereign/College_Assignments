/*  File: Car.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   13 February, 2018

    Test class Car has a license plate and a tally sticker for the Bashemin
    Parking Garage stating how many times it had to be temporarily moved out of
    the garage.
 */

/**
 * A class that represents a car, which has a registered license plate. It also
 * includes a counter for how many times the car has been moved temporarily.
 */
public class Car
{

    // instance variables
    private final String license;
    private int numMove = 0;

    /**
     * Creates a Car object.
     *
     * @param license the registered license plate number of the car
     */
    public Car(String license)
    {
        this.license = license;
    }

    /**
     * Adds to the amount of times the car was moved. This only happens if the
     * car has to be temporarily moved out of the garage.
     */
    public void moveCar()
    {
        this.numMove++;
    }

    /**
     * Returns the registered license plate number as a String.
     *
     * @return the registered license plate
     */
    public String getLicense()
    {
        return this.license;
    }

    /**
     * Returns the number of times the car was moved as an integer.
     *
     * @return the number of times the car was moved
     */
    public int getNumMove()
    {
        return this.numMove;
    }
}
