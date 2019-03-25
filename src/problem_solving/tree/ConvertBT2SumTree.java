package problem_solving.tree;

import data_structures.tree.TreeNode;
import problem_solving.tree.util.TreeOperations;

public class ConvertBT2SumTree {

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */

        convertTreeToSumTree(root);
        TreeOperations.printInorder(root);

    }

    private static void convertTreeToSumTree(TreeNode root) {
        if (root == null || TreeOperations.isLeaf(root)) {
            return;
        }
        int leftSum = 0;
        int rightSum = 0;
        convertTreeToSumTree(root.getLeft());
        convertTreeToSumTree(root.getRight());
        if (root.getLeft() != null) {
            leftSum = root.getLeft().getData();
        }
        if (root.getRight() != null) {
            rightSum = root.getRight().getData();
        }
        int diff = leftSum + rightSum - root.getData();
        if (diff > 0) {
            root.setData(root.getData() + diff);
        } else if (diff < 0) {
            increment(root, -diff);
        }
    }

    private static void increment(TreeNode root, int diff) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            root.getLeft().setData(root.getLeft().getData() + diff);
            increment(root.getLeft(), diff);
        } else if (root.getRight() != null) {
            root.getRight().setData(root.getRight().getData() + diff);
            increment(root.getRight(), diff);
        }
    }
}
