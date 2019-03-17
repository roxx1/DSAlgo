package problem_solving.tree;

import data_structures.tree.TreeNode;

public class BinTree2NodesCousinOrNot {

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        int result = findCousin(root, root.getLeft(), root.getRight().getLeft());
        if (result == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static int findCousin(TreeNode root, TreeNode a, TreeNode b) {
        if (level(root, a, 1) == level(root, b, 1) && !sibling(root, a, b)) {
            return 1;
        } else {
            return 0;
        }
    }


    private static int level(TreeNode root, TreeNode ptr, int level) {
        if (root == null) {
            return 0;
        }
        if (root == ptr) {
            return level;
        }
        int leftLevel = level(root.getLeft(), ptr, level + 1);
        if (leftLevel != 0) {
            return leftLevel;
        }
        return level(root.getRight(), ptr, level + 1);
    }

    private static boolean sibling(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return false;
        }
        return ((root.getLeft() == a && root.getRight() == b) ||
                (root.getLeft() == b && root.getRight() == a) || sibling(root.getLeft(), a, b) || sibling(root.getRight(), a, b));
    }

}
