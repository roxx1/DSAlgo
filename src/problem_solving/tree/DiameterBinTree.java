package problem_solving.tree;

import data_structures.tree.TreeNode;
import javafx.util.Pair;

public class DiameterBinTree {

    public static void main(String[] args) {
        TreeNode root = BinTree.createTree();
    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */
        Pair<Integer, Integer> pair = findHeightDiameter(root);
        System.out.println(pair.getValue());
    }

    private static Pair<Integer, Integer> findHeightDiameter(final TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }
        final Pair<Integer, Integer> lefto = findHeightDiameter(root.getLeft());
        final Pair<Integer, Integer> righto = findHeightDiameter(root.getRight());
        int height = 1 + Math.max(lefto.getKey(), righto.getKey());
        int rootDia = lefto.getKey() + righto.getKey(); // left height + right height
        int leftD = lefto.getValue();
        int rightD = righto.getValue();
        int diameter = Math.max(rootDia, Math.max(leftD, rightD)); // max(fromRootHeightSum, max(leftd, rightd));
        //System.out.println(root.getData() + "=>  height " + height + " diameter  " + diameter);
        return new Pair<>(height, diameter);
    }

}
