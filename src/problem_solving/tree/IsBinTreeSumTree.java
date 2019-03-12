package problem_solving.tree;

import data_structures.tree.TreeNode;

public class IsBinTreeSumTree {
    public static void main(String[] args) {
        TreeNode root = BinTree.createTree();
    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */
        boolean isSumTree = findIfBinTreeSumTree(root);
        System.out.println(isSumTree);
    }

    private static boolean findIfBinTreeSumTree(TreeNode root) {
        if (root == null) {
            return true;
        } else if (TreeOperations.isLeaf(root)) {
            return true;
        }
        boolean isRootSumTree = root.getData() == (root.getLeft() != null ? root.getLeft().getData() : 0) + (root.getRight() != null ? root.getRight().getData() : 0);
        boolean isleftSumTree = findIfBinTreeSumTree(root.getLeft());
        boolean isRightSumTree = findIfBinTreeSumTree(root.getRight());
        return isRootSumTree && isleftSumTree && isRightSumTree;
    }
}
