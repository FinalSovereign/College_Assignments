/*  File: OrderedList.java

    Author: Carlos Rivera (Node class by Greg Shaw)
    PID:    5063909
    Date:   10 April, 2018

    Class OrderedList contains methods that insert, discard, clear, reverse and
    (privately) sort a linked list.
 */
public class OrderedList<E extends Comparable>
{

    // instance variables
    private Node head;
    private boolean isDescending = false;

    // default constructor for an OrderedList object
    public OrderedList(E x)
    {
        // Null check
        if (x == null)
        {
            this.head = null;
        }
        else
        {
            this.head = new Node(x);
        }
    }

    /**
     * This method inserts a Node containing the parameter element into the
     * ordered list in its correct position. To better facilitate this,
     * additional private methods were made for sorting and descending lists.
     *
     * @param x Node element to make into a Node and insert
     */
    public void insert(E x)
    {
        Node y = new Node(x);

        // Null check
        if (this.isEmpty())
        {
            this.head = y;
        }
        // Last node check
        else if (this.head.next == null)
        {
            this.head.next = y;
        }
        // Descending check
        else if (this.isDescending)
        {
            this.insertDescending(y);
        }
        else
        {
            boolean isInserted = false;
            Node back;
            Node temp = this.head;

            if (temp.info.compareTo(y.info) < 0)
            {
                y.next = temp.next;
                this.head.next = y;
                isInserted = true;
            }

            while (!isInserted && temp.next != null)
            {
                back = temp;
                temp = temp.next;

                if (temp.info.compareTo(y.info) < 0)
                {
                    y.next = temp;
                    back.next = y;
                    isInserted = true;
                }
            }

            this.sort(); // Sorts the list after insertion
        }
    }

    /**
     * Private method to insert a Node into a descending list.
     */
    private void insertDescending(Node y)
    {
        // Null check
        if (this.isEmpty())
        {
            this.head = y;
        }
        // Last node check
        else if (this.head.next == null)
        {
            this.head.next = y;
        }
        else
        {
            boolean isInserted = false;
            Node back;
            Node temp = this.head;

            if (temp.info.compareTo(y.info) < 0)
            {
                y.next = temp;
                this.head = y;
                isInserted = true;
            }

            while (!isInserted && temp.next != null)
            {
                back = temp;
                temp = temp.next;

                if (temp.info.compareTo(y.info) > 0)
                {
                    y.next = temp;
                    back.next = y;
                    isInserted = true;
                }
            }

            this.sortDescending(); // Sorts the list after insertion
        }
    }

    /**
     * Private method to sort/order an ascending list.
     */
    private void sort()
    {
        boolean isSorted = false;
        Node start;
        Node back = this.head;
        Node temp = this.head.next;

        while (!isSorted)
        {
            if (temp != this.head && temp.next == null)
            {
                start = null;
                back = this.head;
                temp = this.head.next;
            }

            int count = 0;

            while (back.next != null)
            {
                start = back;
                back = temp;

                if (temp.next != null)
                {
                    temp = temp.next;
                }

                if (back.info.compareTo(temp.info) > 0)
                {
                    start.next = temp;
                    back.next = temp.next;
                    temp.next = back;
                    count++;
                }
            }

            if (count == 0)
            {
                isSorted = true;
            }
        }
    }

    /**
     * Private method to sort/order a descending list.
     */
    private void sortDescending()
    {
        boolean isSorted = false;
        Node start;
        Node back = this.head;
        Node temp = this.head.next;

        while (!isSorted)
        {
            if (temp != this.head && temp.next == null)
            {
                start = null;
                back = this.head;
                temp = this.head.next;
            }

            int count = 0;

            while (back.next != null)
            {
                start = back;
                back = temp;

                if (temp.next != null)
                {
                    temp = temp.next;
                }

                if (back.info.compareTo(temp.info) < 0)
                {
                    start.next = temp;
                    back.next = temp.next;
                    temp.next = back;
                    count++;
                }
            }

            if (count == 0)
            {
                isSorted = true;
            }
        }
    }

    /**
     * This method attempts to find a Node with the parameter element and, if
     * successfully found, will "delete" the Node. This method will return a
     * boolean value corresponding to the result of the search.
     *
     * @param x Node element to be found
     * @return a boolean value in reference to whether a Node containing the
     * parameter element was deleted
     */
    public boolean delete(E x)
    {
        // Null check
        if (this.isEmpty())
        {
            return false;
        }

        boolean check = false;

        Node back;
        Node temp = this.head;

        if (temp.info.equals(x))
        {
            this.head = this.head.next;
            return true;
        }

        while (!check && temp.next != null)
        {
            back = temp;
            temp = temp.next;

            if (temp.info.equals(x))
            {
                back.next = temp.next;
                check = true;
            }
        }

        return check;
    }

    /**
     * This method reverses the order of elements/Nodes in the ordered list.
     * This means an ascending list is now descending and vice versa.
     */
    public void reverse()
    {
        if (!this.isEmpty())
        {
            boolean isReversed = false;

            Node temp;
            Node secLast = this.secondLastNode();
            Node newHead = secLast.next;
            newHead.next = secLast;

            while (!isReversed)
            {
                if (secLast != this.head)
                {
                    secLast.next = null;
                    temp = secLast;
                    secLast = this.secondLastNode();
                    temp.next = secLast;
                }
                else
                {
                    secLast.next = null;
                    this.head = newHead;
                    isReversed = true;
                    this.isDescending = !this.isDescending;
                }
            }
        }
    }

    /**
     * This method finds the second-to-last Node in the ordered list.
     *
     * NOTE: This is a modified version of the lastNode() method by Greg Shaw.
     *
     * @return the second-to-last Node in the ordered list
     */
    private Node secondLastNode()
    {
        Node back = null;
        Node temp = this.head;

        while (temp.next != null)
        {
            back = temp;
            temp = temp.next;
        }

        return back;
    }

    /**
     * Clears the ordered list of all its elements.
     */
    public void clear()
    {
        this.head = null;
    }

    /**
     * Returns whether or not the ordered list is empty.
     *
     * @return a boolean value based on whether or not the head Node is null
     */
    public boolean isEmpty()
    {
        return (this.head == null);
    }

    /**
     * Overridden method to create a String representation of the ordered list.
     *
     * @return String representation of the ordered list
     */
    @Override
    public String toString()
    {
        // Null check with a null response
        if (this.head == null)
        {
            return "This list is empty";
        }

        String str = "";
        str += this.head.info;

        Node temp = this.head;

        if (temp.next != null)
        {
            temp = temp.next;

            while (temp.next != null)
            {
                str += ", ";
                str += temp.info;

                temp = temp.next;
            }

            str += ", ";
            str += temp.info;
        }

        return str;
    }

    /**
     * This is an internal Node class done by Greg Shaw, as posted on his
     * Programming II site.
     *
     * @param <E> An element type that extends the Comparable interface
     */
    class Node<E extends Comparable>
    {

        E info;		// each node stores an object of a class to be
        // determined later...
        Node next;		// ...and a pointer to another node

        // Create a Node object 
        Node(E x)		// constructor takes one param of class E
        {
            info = x;	// set info portion to parameter passed
            next = null;	// not necessary, null is default value
        }
    }
}
