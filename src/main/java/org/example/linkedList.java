package org.example;

import java.util.NoSuchElementException;

// This class represents multiple Nodes (or in other words, the entire Node list).
public class linkedList {


    Node head; // This is the first node in the entire list


    // Creating an empty constructor, allows me to create an empty linked list before adding any Nodes.
    linkedList()
    {
        // Head is null, so if the linkedList wants to start empty, it won't create errors.
        this.head = null;
    }


    // Checks if the linkedList is empty
    public boolean isEmpty() // No linkedList parameter is needed since we are already in the linkedList class.
    {
        if (head == null) // We are only using one condition because if the head is not null, there is at least one node. Otherwise, the linkedList is empty.
        {
            return true;
        }
        return false;
    }


    // Adds a new node to the front of the linkedList
    void addFirst(int firstValue)
    {
        Node newNode = new Node(firstValue); // Creates a new node that will serve as the first Node in the linkedList.
        newNode.next = head; // The original head becomes to the next value.
        head = newNode; // The new Node then becomes the head.
    }


    void addLast(int value)
    {
        Node lastNode = new Node(value);

        /*
         * If the linkedList is empty, the lastNode (the recently added one) becomes the head.
         * Then the method stops to prevent errors.
         */
        if (isEmpty())
        {
            head = lastNode; // Sets the last node to head.
            return; // Stops the method
        }

        /*
         * While the next value in the linkedList is not empty (or in other words it's next value isn't null):
         *
         *                 head → [5] → [10] → [20] → null
         *                                       ↑
         *                                   tempHead
         */
        Node tempHead; //Creates a Node reference variable.
        tempHead = head; // tempHead is pointing to the same node that head is pointing to. tempHead is not seperate from the linkedList.

        while (tempHead.next != null)
        {
            tempHead = tempHead.next; // Sets the current node to it's next value;
        }

        tempHead.next = lastNode; // This sets the next value (which is null) to the new Node's value.
    }


    // Checks the size of the linkedList
    int size()
    {
        int count = 0;

        Node tempHead; //Creates a Node reference variable.
        tempHead = head; // tempHead is pointing to the same node that head is pointing to. tempHead is not seperate from the linkedList.

        /*
         * Without changing the actual linkedlist,
         * we are moving through the list using
         * a temporary Node to iterate through it.
         */

        /*
         * tempHead != null -> Checks to make sure the linkedList doesn't start empty,
         * and makes sure that it keeps going until the last node is passed rather than skipping it.
         */
        while (tempHead != null)
        {
            tempHead = tempHead.next; // Sets the current node to it's next value;
            count++;
        }

        return count;
    }


    // Return the value at index (0-based).
    int get(int index)
    {
        // Throws IndexOutOfBoundsException errors when the index is not valid
        if ((index < 0) || (index >= size()))
        {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

       int i = 0; // The variable we use to iterate through the linkedList

       Node tempHead;
       tempHead = head; // tempHead is pointing to the same node that head is pointing to.

        while (i < index) // The variable "i" starts at zero, so we can use the less than symbol.
        {
            tempHead = tempHead.next; // Sets the current node to it's next value;
            i++; // Increases the iteration variable to reach the desired index.
        }

        return tempHead.value; // Return the Node's value at the specified index.
    }


    // Returns true if value appears anywhere in the list.
    boolean contains(int value)
    {
        Node tempHead; // Temporary node.
        tempHead = head; // tempHead is now pointing to the same node that head is pointing to.

        int i = 0; // Iteration index
        while (i < size())
        {
            if (tempHead.value == value)
            {
                return true;
            }

            tempHead = tempHead.next;
            i++;
        }
        return false;
    }


    // Remove and return the first value. Throw NoSuchElementException if the list is empty.
    int removeFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The linkedList is empty.");
        }

        Node tempHead;
        tempHead = head;

        // This saves the original head's value to be returned.
        int oldHeadValue;
        oldHeadValue = tempHead.value;

        // This sets the head to the next Node after head.
        head = head.next;

        return oldHeadValue;
    }


    // Remove the first node holding value. Return true if something was removed, false otherwise.
    boolean remove(int value)
    {
        if (contains(value) == false)
        {
            return false;
        }

        // Handles removing the head first, if it matches the value.
        if (head.value == value)
        {
            head = head.next;
            return true;
        }

        Node prev = head; // The first value becomes the previous node
        Node current = head.next; // The second value becomes the current.

        while (current != null) // The variable "i" starts at zero, so we can use the less than symbol.
            {
                if (current.value == value)
                {
                    // Moves the previous and temporary Head pointers up one, so prev stays behind tempHead.
                    prev.next = current.next;
                    return true;
                }

                // Help from ChatGPT
                prev = current;
                current = current.next;

            }

        return false; // Return the Node's value at the specified index.
    }

    // Used ChatGPT-5.6 Sol
    public String toString()
    {
        StringBuilder result = new StringBuilder("[");

        Node current = head;

        while (current != null)
        {
            result.append(current.value);

            // Only add ", " if there is another node after this one.
            if (current.next != null)
            {
                result.append(", ");
            }

            current = current.next;
        }

        result.append("]");

        return result.toString();
    }



}
