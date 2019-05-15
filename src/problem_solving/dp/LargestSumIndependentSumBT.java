package problem_solving.dp;

public class LargestSumIndependentSumBT {

    public static void main(String[] args) {
        final TreeNodeLis root = TreeNodeLis.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */

        final Integer largestSumIndependentSetBinaryTree = findLargestSumIndependentSetBinaryTree(root);
        System.out.println(largestSumIndependentSetBinaryTree);
    }

    private static Integer findLargestSumIndependentSetBinaryTree(TreeNodeLis root) {
        if (root == null) {
            return 0;
        }
        if (root.getLis() != null) {
            return root.getLis();
        }
        if (root.getLeft() == null && root.getRight() == null) {
            root.setLis(root.getData());
            return root.getLis();
        }
        Integer lisExc = findLargestSumIndependentSetBinaryTree(root.getLeft()) + findLargestSumIndependentSetBinaryTree(root.getRight());
        Integer lisInc = root.getData();
        if (root.getLeft() != null) {
            lisInc += findLargestSumIndependentSetBinaryTree(root.getLeft().getLeft()) + findLargestSumIndependentSetBinaryTree(root.getLeft().getRight());
        }
        if (root.getRight() != null) {
            lisExc += findLargestSumIndependentSetBinaryTree(root.getRight().getLeft()) + findLargestSumIndependentSetBinaryTree(root.getRight().getRight());
        }
        root.setLis(Math.max(lisExc, lisInc));
        return root.getLis();
    }
}

class TreeNodeLis {
    private TreeNodeLis left;
    private TreeNodeLis right;
    private Integer data;
    private Integer lis;

    public TreeNodeLis(Integer data) {
        this.data = data;
    }

    public TreeNodeLis getLeft() {
        return left;
    }

    public void setLeft(TreeNodeLis left) {
        this.left = left;
    }

    public TreeNodeLis getRight() {
        return right;
    }

    public void setRight(TreeNodeLis right) {
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getLis() {
        return lis;
    }

    public void setLis(Integer lis) {
        this.lis = lis;
    }

    public static TreeNodeLis createTree() {

    /*            1
             2          3
          4    5      6   7
        8   9      10      11
   */

        final TreeNodeLis t1 = new TreeNodeLis(1);
        final TreeNodeLis t2 = new TreeNodeLis(2);
        final TreeNodeLis t3 = new TreeNodeLis(3);
        final TreeNodeLis t4 = new TreeNodeLis(4);
        final TreeNodeLis t5 = new TreeNodeLis(5);
        final TreeNodeLis t6 = new TreeNodeLis(6);
        final TreeNodeLis t7 = new TreeNodeLis(7);
        final TreeNodeLis t8 = new TreeNodeLis(8);
        final TreeNodeLis t9 = new TreeNodeLis(9);
        final TreeNodeLis t10 = new TreeNodeLis(10);
        final TreeNodeLis t11 = new TreeNodeLis(11);
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
}