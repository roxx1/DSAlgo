package problem_solving.tree;

import data_structures.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderAlternativeExtremeNode {

    private static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        final int levelPath[] = new int[11];
        final int height = TreeOperations.calculateHeight(root);
        boolean flag = true;
        for (int i = 0; i < height; i++) {
            findAlternativeExtremeNodeAtLevel(root, i);
            if (flag) {
                System.out.println(list.get(0));
            } else {
                System.out.println(list.get(list.size() - 1));
            }
            list.clear();
            flag = !flag;
        }

    }


    private static void findAlternativeExtremeNodeAtLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            list.add(root.getData());
        }
        findAlternativeExtremeNodeAtLevel(root.getLeft(), level - 1);
        findAlternativeExtremeNodeAtLevel(root.getRight(), level - 1);
    }
}
