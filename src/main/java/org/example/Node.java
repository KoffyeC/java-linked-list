package org.example;

// The Node class represents a single node item.
public class Node {

    int value; // The node value
    Node next; // What comes next, after that Node.

    // A single node, only needs to know its value, and what is next.
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}



