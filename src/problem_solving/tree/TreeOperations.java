package problem_solving.tree;

import data_structures.tree.TreeNode;

public final class TreeOperations {

    private TreeOperations() {
        throw new AssertionError();
    }

    public static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(calculateHeight(root.getLeft()), calculateHeight(root.getRight()));
        }
    }

    public static boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.getLeft() == null && root.getRight() == null;
    }

}
