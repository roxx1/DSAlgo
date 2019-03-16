package problem_solving.tree;

import data_structures.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BottomViewBinTree {

    public static void main(String[] args) {
        TreeNode root = BinTree.createTree();
    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */
        final Map<Integer, Integer> map = new HashMap<>();
        printBottomView(root, map, 0);
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "  " + entry.getValue()));
    }

    private static void printBottomView(TreeNode root, Map<Integer, Integer> map, int hd) {
        if(root==null)
            return;
        map.put(hd,root.getData());
        printBottomView(root.getLeft(),map,hd-1);
        printBottomView(root.getRight(),map,hd+1);

    }
}
