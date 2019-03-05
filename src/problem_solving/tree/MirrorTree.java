package problem_solving.tree;

import data_structures.tree.TreeNode;

public class MirrorTree {

    private static TreeNode createMirrorTree(TreeNode root) {
        if (root == null) return null;
        createMirrorTree(root.getLeft());
        createMirrorTree(root.getRight());
        SwapChilds(root);
        return root;
    }

    private static void SwapChilds(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
    }

    public static void main(String[] args) {
        TreeNode root = BinTree.createTree();
        TreeNode mirrorRoot = createMirrorTree(root);
        //LevelOrderTraversal.printLevelOrderTraversal(mirrorRoot);
    }

}
