package problem_solving.tree;

import data_structures.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TopViewBinTree {

    public static void main(String[] args) {
        TreeNode root = BinTree.createTree();
    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */
        final Map<Integer, Integer> map = new HashMap<>();
        printTopView(root, map, 0);
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "  " + entry.getValue()));
    }

    private static void printTopView(TreeNode root, Map<Integer, Integer> map, int hd) {
        if (root == null)
            return;

        if (map.get(hd) == null) {
            map.put(hd, root.getData());
        }
        printTopView(root.getLeft(), map, hd - 1);
        printTopView(root.getRight(), map, hd + 1);
    }


}
