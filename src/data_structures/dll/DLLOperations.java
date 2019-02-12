package data_structures.dll;

public final class DLLOperations {

    private static DoubleNode head;

    private DLLOperations() {
        throw new AssertionError();
    }

    public static DoubleNode createDoubleNode(final Integer data) {
        return new DoubleNode(data, null, null);
    }

    public static void insertAtBeg(final Integer data) {
        final DoubleNode node = createDoubleNode(data);
        if (head != null) {
            node.setNext(head);
            head.setPrev(node);
        }
        head = node;
    }

    public static void insertAtEnd(final Integer data) {
        final DoubleNode node = createDoubleNode(data);
        if (head != null) {
            DoubleNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            node.setPrev(temp);
        } else {
            head = node;
        }
    }

    public static void insertAtPos(final Integer data, int pos) {
        if (pos <= 0) return;
        final DoubleNode node = createDoubleNode(data);
        if (pos == 1) {
            node.setNext(head);
            if (head != null) {
                head.setPrev(node);
            }
            head = node;
        }

        DoubleNode temp = head;
        DoubleNode ptr = null;
        while (temp != null && pos - 1 > 0) {
            ptr = temp;
            temp = temp.getNext();
            pos--;
        }

        if (pos > 1) return;
        node.setNext(temp);
        node.setPrev(ptr);
        ptr.setNext(node);
        temp.setPrev(node);

    }

    public static void createDLL(final int n) {
        for (int i = 1; i <=n; i++) {
            insertAtEnd(i);
        }
    }

    public static void printDLL() {
        DoubleNode temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        createDLL(4);
        insertAtBeg(6);
        insertAtEnd(9);
        insertAtPos(45,3);
        printDLL();
    }


}
