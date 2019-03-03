package problem_solving.tree;

import data_structures.tree.TreeNode;

public class TwoBinTreeIdenticalOrNot {

    public static boolean checkIdentical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null) {
            return (t1.getData() == t2.getData()
                    && checkIdentical(t1.getLeft(), t2.getLeft())
                    && checkIdentical(t1.getRight(), t2.getRight()));
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TreeNode root = BinTree.createTree();

        BinTree b1 = new BinTree();
        TreeNode root2 = b1.clone();

        boolean checkIdentical = checkIdentical(root, root2);
        System.out.println(checkIdentical);
    }

}
