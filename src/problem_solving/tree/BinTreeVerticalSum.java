package problem_solving.tree;

import data_structures.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinTreeVerticalSum {

    static Integer min = Integer.MAX_VALUE;
    static Integer max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();
       /*          1
             2          3
          4    5      6   7
        8   9      10      11
      */
        findMinMaxHdRange(root, 0);
        findBinTreeVerticalSumApproach1(root);
        System.out.println("--------------------------------------------------------------------------------");
        findBinTreeVerticalSumApproach2(root);
    }

    private static void findBinTreeVerticalSumApproach2(TreeNode root) {
        for (int i = min; i <= max; i++) {
            int sum = printVerticalSumAtHdApproach2(root, i, 0);
            System.out.println(sum);
        }
    }

    private static int printVerticalSumAtHdApproach2(TreeNode root, int i, int hd) {
        if (root == null) {
            return 0;
        } else if (i == hd) {
            return root.getData() + printVerticalSumAtHdApproach2(root.getLeft(), i, hd - 1) + printVerticalSumAtHdApproach2(root.getRight(), i, hd + 1);
        }
        int left = printVerticalSumAtHdApproach2(root.getLeft(), i, hd - 1);
        int right = printVerticalSumAtHdApproach2(root.getRight(), i, hd + 1);
        return left + right;
    }

    private static void findBinTreeVerticalSumApproach1(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = min; i <= max; i++) {
            map.put(i, 0);
            // can be improved by traversing only once and simply put in Map having hd as key and sum as value
            printVerticalSumAtHdApproach1(root, i, 0, map);
        }

        map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "  " + e.getValue()));
    }

    private static void printVerticalSumAtHdApproach1(TreeNode root, int i, int hd, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        } else if (i == hd) {
            Integer curr_sum = map.get(i);
            map.put(i, curr_sum + root.getData());
        }
        printVerticalSumAtHdApproach1(root.getLeft(), i, hd - 1, map);
        printVerticalSumAtHdApproach1(root.getRight(), i, hd + 1, map);
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


}
