package problem_solving.tree;

import data_structures.tree.TreeNode;
import problem_solving.tree.util.TreeOperations;

public class BoundaryTraversal {
    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        printLeftBoundary(root);
        printLeaves(root);
        if (root.getRight() != null) {
            printRightBoundary(root.getRight());
        }
    }

    public static void printLeftBoundary(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            System.out.print(root.getData() + " ");
            printLeftBoundary(root.getLeft());
        } else if (root.getRight() != null) {
            System.out.print(" " + root.getData());
            printLeftBoundary(root.getRight());
        }
    }

    public static void printRightBoundary(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getRight() != null) {
            printRightBoundary(root.getRight());
            System.out.print(root.getData() + " ");
        } else if (root.getLeft() != null) {
            printRightBoundary(root.getLeft());
            System.out.print(" " + root.getData());
        }
    }

    public static void printLeaves(TreeNode root) {
        if (root == null) {
            return;
        }
        if (TreeOperations.isLeaf(root)) {
            System.out.print(root.getData() + " ");
        }
        printLeaves(root.getLeft());
        printLeaves(root.getRight());
    }

}

