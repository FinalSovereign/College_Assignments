/*  File: ShapesTester.java

    Author: Carlos Rivera
    PID:    5063909
    Date:   29 March, 2018

    Test class ShapesTester checks for the functionality of the
    Shape superclass and four derivative subclasses' class methods.
 */

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Test class for correct class hierarchy of Shape and its four subclasses.
 */
public class ShapesTester
{

    /**
     * This code tests the operation of the Shape superclass and its four
     * derivative subclasses.
     *
     * @param args command-line arguments
     * @throws IOException if the output file in question cannot be opened
     */
    public static void main(String[] args) throws IOException
    {
        // instance variables
        Shape[] shapes = new Shape[4]; // Array-of-Shapes to hold subclass objs
        ShapeComparator shape_c = new ShapeComparator(); // To sort by < dist.

        /*
            Embedded code to create one of each object, due to issues in
            automating the process with a Scanner.
         */
        shapes[0] = new Sphere(2, -7, 5, 15);
        shapes[1] = new Parallelepiped(7, 3, 9, 37, 9, 12);
        shapes[2] = new Cylinder(3, -5, 5, 13, 10);
        shapes[3] = new Cone(-5, 3, -1, 14, 11);

        /*
           This try construct opens the output file, tries to write to it and
           then closes the file automatically.
         */
        try (
                // PrintWriter object (technically an instance variable)
                PrintWriter outFile = new PrintWriter(new File(
                        "./src/output.txt")))
        {
            /*
                This first loop prints out the name, center, input data, surface
                area and volume of each object, as originally order above.
             */
            for (Shape shape : shapes)
            {
                System.out.print(shape.toString());
                System.out.printf("%12s%.3f%8s", "S. Area: ",
                        shape.calcSurfaceArea(), "");
                System.out.println(String.format("%18s%.3f", "Volume: ",
                        shape.calcVolume()));

                outFile.print(shape.toString());
                outFile.printf("%12s%.3f%8s", "S. Area: ",
                        shape.calcSurfaceArea(), "");
                outFile.println(String.format("%18s%.3f", "Volume: ",
                        shape.calcVolume()));
            }

            // Sorts the array-of-Shapes by their volumes, ascending
            Arrays.sort(shapes);
            System.out.println();
            outFile.println();

            /*
                This second loop prints out the name and volume of each object,
                after being sort by volume.
             */
            for (Shape shape : shapes)
            {
                String name = shape.getClass().getSimpleName();

                System.out.printf("%s%s ", name, ":");
                System.out.println(String.format("%" + (25 - name.length())
                        + "s%.3f", "Volume: ", shape.calcVolume()));

                outFile.printf("%s%s ", name, ":");
                outFile.println(String.format("%" + (25 - name.length())
                        + "s%.3f", "Volume: ", shape.calcVolume()));
            }

            // Sorts the array by their distance from the center, descending
            Arrays.sort(shapes, shape_c);
            System.out.println();
            outFile.println();

            /*
                This final loop prints out the name and distance from the center
                of each object, after being sort by that distance.
             */
            for (Shape shape : shapes)
            {
                String name = shape.getClass().getSimpleName();

                System.out.printf("%s%s ", name, ":");
                System.out.println(String.format("%" + (43 - name.length())
                        + "s%.3f", "Distance from the Origin: ",
                        shape.calcDistance()));

                outFile.printf("%s%s ", name, ":");
                outFile.println(String.format("%" + (43 - name.length())
                        + "s%.3f", "Distance from the Origin: ",
                        shape.calcDistance()));
            }
        }
    }
}
