package problem_solving.tree;

import data_structures.tree.TreeNode;

import java.util.*;

public class DiagonalTraversalBT {

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        final Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        doDiagonalTraversal(root, diagonalMap, 0);
        Set<Map.Entry<Integer, List<Integer>>> entries = diagonalMap.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            System.out.print(entry.getKey() + "  ");
            List<Integer> entryValue = entry.getValue();
            System.out.print(entryValue);
            System.out.println();
        }
    }

    private static void doDiagonalTraversal(TreeNode root, Map<Integer, List<Integer>> diagonalMap, int diagonal) {
        if (root == null) {
            return;
        }
        List<Integer> list = diagonalMap.get(diagonal);
        if (list == null) {
            list = new ArrayList<>();
            list.add(root.getData());
            diagonalMap.put(diagonal, list);
        } else {
            list.add(root.getData());
            diagonalMap.put(diagonal, list);
        }
        doDiagonalTraversal(root.getRight(), diagonalMap, diagonal);
        doDiagonalTraversal(root.getLeft(), diagonalMap, diagonal + 1);
    }
}
