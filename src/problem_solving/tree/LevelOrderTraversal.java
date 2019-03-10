package problem_solving.tree;

import data_structures.tree.TreeNode;

public class LevelOrderTraversal {

    public static void printLevelOrderTraversal(TreeNode root) {
        final int height = TreeOperations.calculateHeight(root);
        for (int i = 0; i < height; i++) {
            // print node at a height i
            printNodeAtLevel(root, i);
        }
    }

    private static void printNodeAtLevel(TreeNode root, int i) {
        if (root == null) {
            return;
        } else if (i == 0) {
            System.out.print(root.getData() + " ");
        } else {
            printNodeAtLevel(root.getLeft(), i - 1);
            printNodeAtLevel(root.getRight(), i - 1);
        }
    }



    public static void main(String[] args) {
        TreeNode node = BinTree.createTree();
           /*       1
             2          3
          4    5      6   7
        8   9      10      11
   */
        printLevelOrderTraversal(node);
    }

}
