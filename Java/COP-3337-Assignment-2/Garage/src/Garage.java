/*  File: Garage.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   13 February, 2018

    Class Garage has a parking lot of at most 10 spots and a system to count how
    many cars are in the lot at the moment.
 */

/**
 * A class that represents a garage that has at most 10 parking spots. It
 * includes how said garage will handle arrivals and departures.
 *
 * NOTE: This class assumes that cars are parked starting from lot 10 to lot 1.
 *       If the parking system is from lot 1 to lot 10, either the assignment
 *       of lots in the code (i.e. the index of the Garage array) or the printed
 *       value of the lot number must be modified.
 */
public class Garage
{

    // instance variables
    private final int CAP = 10; // "Magic number" for maximum # of parking spots
    private Car[] garage = new Car[CAP]; // Car array that represents the lot
    private int numCars = 0; // Counter for how many cars are in the garage

    /**
     * Decides whether the current car can enter the parking garage or not. If
     * it can enter, it is assigned a spot. If it can't because the garage is
     * full, it will be told to leave.
     *
     * @param car the current car who wants to enter the garage
     * @return the action the garage takes for the current car
     */
    public String arrive(Car car)
    {
        // The system checks to see if the garage is not full.
        if (this.numCars < this.CAP)
        {
            boolean isThere = false;

            // Checks to see if a car with the same license is already parked.
            for (int i = this.CAP - 1; i > this.CAP - this.numCars; i--)
            {
                if (this.garage[i].getLicense().equalsIgnoreCase(
                        car.getLicense()))
                {
                    isThere = true;
                    i = this.numCars;
                }
            }

            // If already parked, the garage will not let the "imposter" car in.
            if (isThere)
            {
                return ("Car " + car.getLicense() + " is already "
                        + " parked in the garage.");
            }

            // This assigns the car its parking spot and adds to the car count.
            this.garage[this.CAP - 1 - this.numCars] = car;
            this.numCars++;

            return ("Car " + car.getLicense() + " has arrived and"
                    + " parks in lot " + (this.CAP - this.numCars + 1) + ".");
        }
        else
        {
            // If the garage is full, it tells the car to leave.
            return ("The Bashemin Parking Garage is full and car "
                    + car.getLicense() + " is not allowed in.");
        }
    }

    /**
     * Decides whether the current car can exit the parking garage or not. If it
     * can exit, it means it is already in the garage and it allowed to leave.
     * If it can't because the car is not there, it will disregard the order.
     *
     * @param car the current car who wants to exit the garage
     * @return the action the garage takes for the current car
     */
    public String depart(Car car)
    {
        // The system checks to see if the garage is not empty.
        if (this.numCars > 0)
        {
            boolean isParked = false;
            int lot = -1;

            // Checks to see if a car with the same license is already parked.
            for (int i = this.CAP - 1; i > this.CAP - 1 - this.numCars; i--)
            {
                if (this.garage[i].getLicense().equalsIgnoreCase(
                        car.getLicense()))
                {
                    isParked = true;
                    lot = i;
                    i = -1;
                }
            }

            /*
                If already parked, the garage will let the car leave. If there
                are cars in front the one that needs to leave, they will be
                temporarily moved out of the garage.
             */
            if (isParked)
            {
                int index = this.CAP - 1;
                Car copy = this.garage[lot];

                // Temporarily moves cars in front of the one that needs to exit
                while (index > lot)
                {
                    this.garage[index].moveCar();
                    index--;
                }

                index--;

                /*
                    Moves all the cars behind the one that left up one parking
                    spot.
                 */
                for (int i = index; i > this.CAP - 1 - this.numCars; i--)
                {
                    this.garage[i + 1] = this.garage[i];
                }

                this.garage[this.CAP - this.numCars] = null;
                this.numCars--;

                return ("Car " + copy.getLicense()
                        + " has departed. It was moved "
                        + copy.getNumMove() + " time(s).");
            }
            else
            {
                return ("Car " + car.getLicense() + " is not "
                        + "parked in the garage.");
            }
        }
        else
        {
            return ("The garage is empty so Car " + car.getLicense()
                    + " cannot possibly be parked in the lot");
        }
    }

    /**
     * Prints out a visualization of the garage lot.
     *
     * NOTE: This method is used solely to bug test the arrive() and depart()
     * methods and should not be accessed in standard use of the program, unless
     * you want to print out the garage contents.
     */
    private void printGarage()
    {
        // Prints the "top" part of the lot
        for (int i = this.CAP; i > 0; i--)
        {
            System.out.print("======== ");
        }
        System.out.println();

        // Prints the car in that lot (if there is one)
        for (int i = this.CAP - 1; i > this.CAP - 1 - this.numCars; i--)
        {
            System.out.print(" " + this.garage[i].getLicense() + "  ");
        }
        System.out.println();

        // Prints the "bottom" part of the lot
        for (int i = this.CAP; i > 0; i--)
        {
            System.out.print("======== ");
        }
        System.out.println();
    }
}
