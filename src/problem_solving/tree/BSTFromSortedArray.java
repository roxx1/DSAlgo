package problem_solving.tree;

import data_structures.tree.TreeNode;

public class BSTFromSortedArray {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = createBSTFromSortedArray(arr, 0, arr.length - 1);
        TreeOperations.printInorder(root);
    }

    private static TreeNode createBSTFromSortedArray(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = TreeOperations.createNewNode(arr[mid]);
        TreeNode leftChild = createBSTFromSortedArray(arr, start, mid - 1);
        TreeNode rightChild = createBSTFromSortedArray(arr, mid + 1, end);
        root.setLeft(leftChild);
        root.setRight(rightChild);
        return root;
    }
}
