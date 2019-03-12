package problem_solving.tree;

import data_structures.tree.TreeNode;

public class BinTreeVerticalOrder {

    static Integer min = Integer.MAX_VALUE;
    static Integer max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();
       /*          1
             2          3
          4    5      6   7
        8   9      10      11
      */
        printBinTreeInVerticalOrderApproach1(root);
    }

    private static void printBinTreeInVerticalOrderApproach1(final TreeNode root) {
        if (root == null) return;
        // calculate range of horizontal Distance
        findMinMaxHdRange(root, 0);

        for (int i = min; i <= max; i++) {
            printNodesAtGivenHd(root, i, 0);
        }
    }

    private static void findMinMaxHdRange(TreeNode root, Integer hd) {
        if (root == null) {
            return;
        }
        if (hd < min) {
            min = hd;
        }
        if (hd > max) {
            max = hd;
        }
        findMinMaxHdRange(root.getLeft(), hd - 1);
        findMinMaxHdRange(root.getRight(), hd + 1);
    }

    private static void printNodesAtGivenHd(TreeNode root, int i, int curr_hd) {
        if (root == null) return;
        if (curr_hd == i) {
            System.out.println(i + "  => " + root.getData() + "  ");
        }
        printNodesAtGivenHd(root.getLeft(), i, curr_hd - 1);
        printNodesAtGivenHd(root.getRight(), i, curr_hd + 1);
    }

}
