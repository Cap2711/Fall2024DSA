package com.keyin3;

public class LinkedList {
    Node head;

    // Delete
    public void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            head = head.next;
            System.out.println("Deleted node " + key);
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node " + key + " not found.");
            return;
        }

        previous.next = current.next;
        System.out.println("Deleted node " + key);
    }

    // Insert
    public void insertNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Display the list
    public void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " - ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertNode(10);
        list.insertNode(20);
        list.insertNode(30);
        list.insertNode(40);
        list.insertNode(50);

        System.out.println("List:");
        list.displayList();

        list.deleteNode(10);
        list.displayList();

        list.deleteNode(50);
        list.displayList();

        list.deleteNode(30);
        list.displayList();

        list.deleteNode(100);
        list.displayList();
    }
}
