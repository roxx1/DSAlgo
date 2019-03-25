package problem_solving.tree;

import data_structures.tree.TreeNode;
import problem_solving.tree.util.TreeOperations;

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
        int isSumTree2 = findIfBinTreeSumTreeApproach2(root);
        if (isSumTree2 == -1) {
            System.out.println("Not a sum tree");
        } else {
            System.out.println("sum tree");
        }
    }

    private static int findIfBinTreeSumTreeApproach2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (TreeOperations.isLeaf(root)) {
            return root.getData();
        }
        int leftSum = findIfBinTreeSumTreeApproach2(root.getLeft());
        int rightSum = findIfBinTreeSumTreeApproach2(root.getRight());

        if (leftSum == -1 || rightSum == -1) {
            return -1;
        } else if (root.getData() == leftSum + rightSum) {
            return 2 * root.getData();
        }
        return -1;
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
