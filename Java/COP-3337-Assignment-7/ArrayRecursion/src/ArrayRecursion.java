/*  File: ArrayRecursion.java
 *
 *  Programmer: Carlos Rivera
 *  PID: 5063909
 *  Date: 19 April 2018 
 *
 */

import java.util.Random;

public class ArrayRecursion
{
    // instance var's

    private int[] list;		// array of ints
    private int count = 0;	// number of elements used

    /**
     * Create an ArrayRecursion object. Create an array with between 10 and 15
     * elements, and fill it with random positive 2-digit ints
     */
    public ArrayRecursion()
    {
        Random r = new Random();
        count = r.nextInt(6) + 10;
        list = new int[count];

        for (int i = 0; i < count; i++)
        {
            list[i] = r.nextInt(90) + 10;
        }
    }

    /*
    * Return the list as a string
    * @return a string containing all ints stored in list
     */
    @Override
    public String toString()
    {
        String out = "";
        for (int i = 0; i < count; i++)
        {
            out += list[i] + "  ";
        }
        return out + "\n";
    }

    /**
     * Reverse the order of the values stored in the list. (called by client to
     * reverse list using first algorithm)
     */
    public void reverse()
    {
        reverseRecurse(list, 0, count);
    }

    // recursive "helper" method to reverse the values stored in the list 
    // (called by public method reverse1())
    private void reverseRecurse(int[] list, int start, int count)
    {
        if (start >= count)
        {
            return;
        }

        int temp = list[count - 1];
        list[count - 1] = list[start];
        list[start] = temp;

        reverseRecurse(list, start + 1, count - 1);
    }

    /*
    * Returns the index of the largest value in the array.
    * @return the index of the largest value in the array
     */
    public int getIndexOfLargest()
    {
        return recursiveGetIndexOfLargest(list, count);
    }

    // recursive "helper" method to return index of largest value
    // (called by public method getLargest())
    private int recursiveGetIndexOfLargest(int[] list, int count)
    {
        int num = count - 1;
        int temp = 0;

        if (count > 1)
        {
            temp = recursiveGetIndexOfLargest(list, count - 1);
        }

        if (list[temp] > list[num])
        {
            num = temp;
        }

        if (count == list.length)
        {
            if (list[count - 1] > list[num])
            {
                return count - 1;
            }
        }

        return num;
    }

    /*
    * Sort the array in ascending order using the selection sort
     */
    public void sort()
    {
        recursiveSort(list, count);
    }

    // recursive "helper" method to sort the array
    // (called by public method sort())
    private void recursiveSort(int[] list, int count)
    {
        int indexLargest = recursiveGetIndexOfLargest(list, count);

        int temp = list[count - 1];
        list[count - 1] = list[indexLargest];
        list[indexLargest] = temp;

        if (count > 1)
        {
            recursiveSort(list, count - 1);
        }
    }

    public static void main(String[] args)
    {
        ArrayRecursion list = new ArrayRecursion();

        System.out.println("\nOriginal:  " + list);
        list.reverse();
        System.out.println("\nReversed:    " + list);

        System.out.println("Largest value is at index: "
                + list.getIndexOfLargest());
        list.sort();
        System.out.println("\nSorted:    " + list);
    }
}
