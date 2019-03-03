package problem_solving.tree;

import data_structures.tree.TreeNode;

public class BinTreeSize {

    public static int calculateSize(final TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + calculateSize(root.getLeft()) + calculateSize(root.getRight());
        }
    }

    public static void main(String[] args) {
        final TreeNode t1 = BinTree.createTree();
        int size = calculateSize(t1);
        System.out.println(size);
    }
}
