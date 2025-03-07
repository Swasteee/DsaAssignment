
//Question Number 3 B solutions

package com.example.dsa.example;

public class BusService {

    // Node class to define a linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to reverse a part of the linked list
    public static ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverse(next, k);
        }

        return prev;
    }

    // Function to optimize the boarding process
    public static ListNode optimizeBoarding(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        return reverse(head, k);
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to run the code
    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        System.out.println("Original list:");
        printList(head);

        ListNode optimizedHead = optimizeBoarding(head, k);

        System.out.println("Optimized list with k = " + k + ":");
        printList(optimizedHead);

        // Another example with k = 3
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        k = 3;
        System.out.println("Original list:");
        printList(head);

        optimizedHead = optimizeBoarding(head, k);

        System.out.println("Optimized list with k = " + k + ":");
        printList(optimizedHead);
    }
}


