package problem_solving.tree;

import data_structures.tree.TreeNode;
import problem_solving.tree.util.TreeOperations;

public class SpiralLevelOrderTraversal {


    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();
              /*       1
             2          3
          4    5      6   7
        8   9      10      11
   */
        int height = TreeOperations.calculateHeight(root);
        printSpiralOrder(root, height);

    }

    private static void printSpiralOrder(TreeNode root, int height) {
        boolean flag = false;
        for (int i = 0; i < height; i++) {
            flag = !flag;
            printNodeAtLevel(root, i, flag);
        }
    }


    public static void printNodeAtLevel(TreeNode root, int level, boolean flag) {
        if (root == null) return;
        if (level == 0) {
            System.out.print(root.getData() + " ");
        }
        if (flag) {
            printNodeAtLevel(root.getLeft(), level - 1, flag);
            printNodeAtLevel(root.getRight(), level - 1, flag);
        } else {
            printNodeAtLevel(root.getRight(), level - 1, flag);
            printNodeAtLevel(root.getLeft(), level - 1, flag);
        }
    }


}
