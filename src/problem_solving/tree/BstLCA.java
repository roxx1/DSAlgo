package problem_solving.tree;

import data_structures.tree.BSTOperations;
import data_structures.tree.TreeNode;

public class BstLCA {

    public static void main(String[] args) {
        final TreeNode root = BSTOperations.createBST();
         /*
                10
             6     16
           4   9  13
         */

        final TreeNode lcsNode = LCS(root, 13, 6);
        if (lcsNode != null) {
            System.out.println(lcsNode.getData());
        }
    }

    private static TreeNode LCS(TreeNode root, int a, int b) {
        if (root == null) {
            return null;
        } else if (root.getData() < a && root.getData() < b) {
            return LCS(root.getRight(), a, b);
        } else if (root.getData() > a && root.getData() > b) {
            return LCS(root.getLeft(), a, b);
        } else
            return root;
    }
}
