package problem_solving.tree;

import data_structures.tree.TreeNode;
import problem_solving.tree.util.TreeOperations;

public class MultSumOfNodesAtSameLevel {

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        int height = TreeOperations.calculateHeight(root);
        int mult = 1;
        for (int i = 0; i < height; i++) {
            int sum = calculateSumAtLevel(root, 0, i);
            mult = mult * sum;
        }
        System.out.println(mult);
    }

    private static int calculateSumAtLevel(TreeNode root, int sum, int level) {
        if (root == null) {
            return 0;
        }
        if (level == 0) {
            return sum = sum + root.getData();
        }
        return calculateSumAtLevel(root.getLeft(), sum, level - 1)
                + calculateSumAtLevel(root.getRight(), sum, level - 1);
    }
}
