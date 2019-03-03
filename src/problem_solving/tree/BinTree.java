package problem_solving.tree;

import data_structures.tree.TreeNode;

public class BinTree implements Cloneable {

    static TreeNode t1 = null;
    static TreeNode t1Clone = null;

    public static TreeNode createTree() {

    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */

        t1 = new TreeNode(1);
        final TreeNode t2 = new TreeNode(2);
        final TreeNode t3 = new TreeNode(3);
        final TreeNode t4 = new TreeNode(4);
        final TreeNode t5 = new TreeNode(5);
        final TreeNode t6 = new TreeNode(6);
        final TreeNode t7 = new TreeNode(7);
        final TreeNode t8 = new TreeNode(8);
        final TreeNode t9 = new TreeNode(9);
        final TreeNode t10 = new TreeNode(10);
        final TreeNode t11 = new TreeNode(11);
        t1.setLeft(t2);
        t1.setRight(t3);
        t2.setLeft(t4);
        t2.setRight(t5);
        t3.setLeft(t6);
        t3.setRight(t7);
        t4.setLeft(t8);
        t4.setRight(t9);
        t6.setLeft(t10);
        t7.setRight(t11);
        return t1;
    }

    @Override
    protected TreeNode clone() throws CloneNotSupportedException {
        /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */

        t1Clone = new TreeNode(1);
        final TreeNode t2 = new TreeNode(2);
        final TreeNode t3 = new TreeNode(3);
        final TreeNode t4 = new TreeNode(4);
        final TreeNode t5 = new TreeNode(5);
        final TreeNode t6 = new TreeNode(6);
        final TreeNode t7 = new TreeNode(7);
        final TreeNode t8 = new TreeNode(8);
        final TreeNode t9 = new TreeNode(9);
        final TreeNode t10 = new TreeNode(10);
        final TreeNode t11 = new TreeNode(11);
        t1Clone.setLeft(t2);
        t1Clone.setRight(t3);
        t2.setLeft(t4);
        t2.setRight(t5);
        t3.setLeft(t6);
        t3.setRight(t7);
        t4.setLeft(t8);
        t4.setRight(t9);
        t6.setLeft(t10);
        t7.setRight(t11);
        return t1Clone;
    }

    public static void main(String[] args) {
        createTree();
    }

}
