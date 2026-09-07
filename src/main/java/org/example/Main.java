package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ---------------- ARRAY TEST ----------------

        int[] array = new int[4];
        array[0] = 5;
        array[1] = 10;
        array[2] = 20;

        int arrayActions = 0;

        // Move every value one spot to the right.
        for (int i = 2; i >= 0; i--)
        {
            array[i + 1] = array[i];
            arrayActions++;
        }

        // Add the new value to the front.
        array[0] = 2;
        arrayActions++;

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Array actions: " + arrayActions);


        // ---------------- LINKED LIST TEST ----------------

        linkedList list = new linkedList();

        list.addLast(5);
        list.addLast(10);
        list.addLast(20);

        int linkedListActions = 0;

        list.addFirst(2); // addFirst changes two links:
        linkedListActions++; // newNode.next = head
        linkedListActions++; // head = newNode

        System.out.println("\nLinked List: " + list);
        System.out.println("Linked List actions: " + linkedListActions);
    }
}