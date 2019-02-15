package problem_solving.linked_list;

import data_structures.sll.Node;

public class LLUtils {

    private static Node head;

    public static Node createRandomNode(final Integer data) {
        return new Node(data, null);
    }

    public static Node createLinkedList(final int n) {
        Node ptr = null;
        for (int i = n; i >= 1; i--) {
            final Node node = createRandomNode(i);
            node.setNext(ptr);
            ptr = node;
        }
        return head = ptr;
    }

    public static void reverseLL() {
        if (head == null) return;
        Node temp = head;
        Node prev = null, next = null;

        while (temp != null) {
            next = temp.getNext();
            temp.setNext(prev);
            prev = temp;
            temp = next;
        }
        head = prev;
    }

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        createLinkedList(10);
        reverseLL();
        printLL();
    }

}
