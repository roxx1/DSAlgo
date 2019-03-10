package problem_solving.tree;

import data_structures.tree.TreeNode;

public class NodesKDistFromRoot {

    public static void main(String[] args) {
        TreeNode root = BinTree.createTree();
    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */
        int height = TreeOperations.calculateHeight(root);
        int k = 3;
        if (k < height) {
            printNodesKDisFromRoot(root, k);
        }
    }

    private static void printNodesKDisFromRoot(TreeNode root, int k) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(root.getData() + " ");
        } else {
            printNodesKDisFromRoot(root.getLeft(), k - 1);
            printNodesKDisFromRoot(root.getRight(), k - 1);
        }
    }

}
