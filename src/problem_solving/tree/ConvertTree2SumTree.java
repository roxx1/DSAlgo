package problem_solving.tree;

import data_structures.tree.TreeNode;
import problem_solving.tree.util.TreeOperations;

public class ConvertTree2SumTree {

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        convertTree2SumTree(root);
        TreeOperations.printPreorder(root);
    }

    private static int convertTree2SumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int rootData = root.getData();
        final int leftSum = convertTree2SumTree(root.getLeft());
        final int rightSum = convertTree2SumTree(root.getRight());
        root.setData(leftSum + rightSum);
        return rootData + leftSum + rightSum;
    }

}
