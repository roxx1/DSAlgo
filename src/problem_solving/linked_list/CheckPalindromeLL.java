package problem_solving.linked_list;

import data_structures.sll.Node;

public class CheckPalindromeLL {
    static Node left;

    public static void main(String[] args) {
        Node n3 = new Node(1, null);
        Node n2 = new Node(0, n3);
        Node n1 = new Node(2, n2);

        Node right = n1;
        left = n1;
        boolean b = checkPalindromeUtil(right);
        System.out.println(b);
    }

    public static boolean checkPalindromeUtil(Node right) {   // 2 0 1

        if (right == null) return true;

        boolean b = checkPalindromeUtil(right.getNext());

        if (b == false) return false;

        if (left == null && right == null) return true;

        boolean b1 = left.getData() == right.getData();
        left = left.getNext();
        return b1;

    }

}
