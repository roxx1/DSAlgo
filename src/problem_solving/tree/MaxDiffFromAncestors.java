package problem_solving.tree;

import data_structures.tree.TreeNode;

public class MaxDiffFromAncestors {
    private static Integer res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        findMaxDiffFromAncestors(root);
        System.out.println(res);
    }

    private static int findMaxDiffFromAncestors(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (TreeOperations.isLeaf(root)) {
            return root.getData();
        }
        int leftMin = findMaxDiffFromAncestors(root.getLeft());
        int rightMin = findMaxDiffFromAncestors(root.getRight());
        int min = Math.min(leftMin, rightMin);
        res = Math.max(res, root.getData() - min);
        return Math.min(root.getData(), min);
    }
}
