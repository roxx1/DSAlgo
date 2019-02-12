package data_structures.tree;

public final class BTOperations {

    private BTOperations() {
        throw new AssertionError();
    }

    public static TreeNode createBT() {

    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */

        final TreeNode t1 = new TreeNode(1);
        final TreeNode t2 = new TreeNode(2);
        final TreeNode t3 = new TreeNode(3);
        final TreeNode t4 = new TreeNode(4);
        final TreeNode t5 = new TreeNode(5);
        final TreeNode t6 = new TreeNode(6);
        final TreeNode t7 = new TreeNode(7);
        final TreeNode t8 = new TreeNode(8);
        final TreeNode t9 = new TreeNode(9);
        final TreeNode t10 = new TreeNode(10);
        final TreeNode t11 = new TreeNode(11);
        t1.setLeft(t2);
        t1.setRight(t3);
        t2.setLeft(t4);
        t2.setRight(t5);
        t3.setLeft(t6);
        t3.setRight(t7);
        t4.setLeft(t8);
        t4.setRight(t9);
        t6.setLeft(t10);
        t7.setRight(t11);
        return t1;
    }

    public static final void inorderTraversal(final TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.getLeft());
        System.out.print(node.getData() + " ");
        inorderTraversal(node.getRight());
    }


    public static final void preOrderTraversal(final TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + "  ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public static final void postOrderTraversal(final TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getData() + "  ");
    }

    public static int countNoOfNodes(final TreeNode t) {
        if (t == null)
            return 0;
        else
            return 1 + countNoOfNodes(t.getLeft()) + countNoOfNodes(t.getRight());
    }

    public static int countNoOfLeaves(final TreeNode t) {
        if (t == null) return 0;
        if (t.getLeft() == null && t.getRight() == null) {
            return 1;
        } else {
            return countNoOfLeaves(t.getLeft()) + countNoOfLeaves(t.getRight());
        }
    }

    public static int countNoOfNONLeaves(final TreeNode t) {
        if (t == null) {
            return 0;
        } else if (t.getLeft() == null && t.getRight() == null) {
            return 0;
        } else {
            return 1 + countNoOfNONLeaves(t.getLeft()) + countNoOfNONLeaves(t.getRight());
        }
    }

    public static int countNoOfFullNodes(final TreeNode t) {
        if (t == null) return 0;
        if (t.getLeft() == null || t.getRight() == null) {
            return 0;
        } else {
            return 1 + countNoOfFullNodes(t.getLeft()) + countNoOfFullNodes(t.getRight());
        }
    }

    public static int height(final TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            final int left = height(t.getLeft());
            final int right = height(t.getRight());
            return 1 + Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        final TreeNode root = createBT();
        //inorderTraversal(root);
        //preOrderTraversal(root);
        //postOrderTraversal(root);
        System.out.println(countNoOfNodes(root));
        System.out.println(countNoOfLeaves(root));
        System.out.println(countNoOfNONLeaves(root));
        System.out.println(countNoOfFullNodes(root));
    }
}