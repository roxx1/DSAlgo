package problem_solving.tree;

import data_structures.tree.TreeNode;

public class IsFoldableBT {

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        final boolean foldableTree = checkIfFoldableTree(root);
        System.out.println(foldableTree);
    }

    private static boolean checkIfFoldableTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isFoldableUtil(root.getLeft(), root.getRight());
    }

    private static boolean isFoldableUtil(TreeNode n1, TreeNode n2) { // root->left,root->right
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return isFoldableUtil(n1.getLeft(), n2.getRight()) && isFoldableUtil(n1.getRight(), n2.getLeft());
    }
}
