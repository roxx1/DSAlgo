package problem_solving.tree;

import data_structures.tree.TreeNode;

public class BinTreeLCS {

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */

        TreeNode node = findBinLCA(root, 8, 11);
        if (node != null) {
            System.out.println(node.getData());
        }

    }

    private static TreeNode findBinLCA(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        } else if (root.getData() == p || root.getData() == q) {
            return root;
        }
        TreeNode left = findBinLCA(root.getLeft(), p, q);
        TreeNode right = findBinLCA(root.getRight(), p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

}
