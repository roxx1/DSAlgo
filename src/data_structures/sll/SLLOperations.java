package data_structures.sll;

public final class SLLOperations {

    private SLLOperations() {
        throw new AssertionError();
    }

    private static Node head;


    public static void insertAtBeginning(final Integer data) {
        final Node n = createRandomNode(data);
        n.setNext(head);
        head = n;
    }

    public static void insertAtEnd(final Integer data) {
        if (head == null) {
            insertAtBeginning(data);
        }
        Node temp = head;
        while (temp != null && temp.getNext() != null) {
            temp = temp.getNext();
        }
        final Node n = createRandomNode(data);
        temp.setNext(n);
    }

    public static void insertAtPos(final Integer data, Integer pos) {
        if (pos <= 0) return;

        if (pos == 1) {
            insertAtBeginning(data);
        }

        Node temp = head;
        Node ptr = null;
        while (temp != null && pos > 1) {
            ptr = temp;
            temp = temp.getNext();
            pos--;
        }

        if (pos > 1) {
            return;
        }

        final Node n = createRandomNode(data);
        n.setNext(temp);
        ptr.setNext(n);
    }

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

    public static void deleteNode(final Integer data) {
        if (head == null)
            return;

        Node temp = head;
        final Node next = temp.getNext();

        // if dequeue head node
        if (temp.getData().equals(data)) {
            if (next == null) {
                head = null;
            } else {
                head = next;
                temp.setNext(null);
            }
        } else {
            // traverse the list
            while (temp != null) {
                if (next != null && next.getData().equals(data)) {
                    temp.setNext(next.getNext());
                    next.setNext(null);
                    break;
                }
                temp = next;
            }
        }
    }

    public static void moveLastNode2Front() {
        if (head == null || head.getNext() == null) {
            return;
        }

        Node temp = head;
        Node ptr = null;
        while (temp != null && temp.getNext() != null) {
            ptr = temp;
            temp = temp.getNext();
        }

        ptr.setNext(null);
        temp.setNext(head);
        head = temp;

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

    public static void reverseLLUsingRecursion(Node start, Node prev) {
        if (start != null) {
            Node next = start.getNext();
            start.setNext(prev);
            reverseLLUsingRecursion(next, start);
        } else {
            head = prev;
        }
    }

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }

    public static void printLLUsingRecursion(final Node start) {
        if (start == null) {
            return;
        }
        System.out.print(start.getData() + " ");
        printLLUsingRecursion(start.getNext());
    }

    public static Node getHead() {
        return head;
    }

    public static void main(String[] args) {
        final Node start = createLinkedList(10);
        //deleteNode(1);
        //insertAtBeginning(12);
        //insertAtPos(15, 4);
        //insertAtEnd(14);
        //moveLastNode2Front();
        //moveLastNode2Front();
        //reverseLL();
        reverseLLUsingRecursion(head, null);
        printLLUsingRecursion(head);
    }


}
