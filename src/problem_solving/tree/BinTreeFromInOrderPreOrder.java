package problem_solving.tree;

import data_structures.tree.TreeNode;
import problem_solving.tree.util.TreeOperations;

public class BinTreeFromInOrderPreOrder {

    public static void main(String[] args) {
        int[] pre = new int[]{4, 2, 1, 3, 6, 5, 7};
        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = constructBinTreeInPre(in, pre, 0, pre.length - 1);
        TreeOperations.printInorder(root);
    }

    static int preIndex = 0;

    private static TreeNode constructBinTreeInPre(int[] in, int[] pre, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = TreeOperations.createNewNode(pre[preIndex++]);
        if (start == end) {
            return root;
        }
        int index = searchElement(root.getData(), in, start, end);
        if (index == -1) {
            return null;
        }
        root.setLeft(constructBinTreeInPre(in, pre, start, index - 1));
        root.setRight(constructBinTreeInPre(in, pre, index + 1, end));
        return root;
    }

    private static int searchElement(int data, int[] in, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (in[i] == data) {
                return i;
            }
        }
        return -1;
    }


}
