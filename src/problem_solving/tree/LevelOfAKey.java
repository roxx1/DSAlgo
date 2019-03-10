package problem_solving.tree;

import data_structures.tree.TreeNode;

public class LevelOfAKey {

    public static void main(String[] args) {
        TreeNode root = BinTree.createTree();
    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */

        int height = TreeOperations.calculateHeight(root);
        for (int i = 1; i <= height; i++) {
            boolean b = findLevelOfKey(root, i, 9);
            if (b) {
                System.out.println(i);
                break;
            }
        }

    }

    private static boolean findLevelOfKey(TreeNode root, int level, int key) { // Level Wise Search
        if (root == null) {
            return false;
        }
        if (level == 1) {
            if (root.getData() == key) {
                return true;
            }
        }

        boolean isLeft = findLevelOfKey(root.getLeft(), level - 1, key);
        boolean isRight = findLevelOfKey(root.getRight(), level - 1, key);
        return isLeft || isRight;
    }

}
