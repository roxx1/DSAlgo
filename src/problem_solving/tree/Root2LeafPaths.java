package problem_solving.tree;

import data_structures.tree.TreeNode;

public class Root2LeafPaths {

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        int path[] = new int[11];

        printRoot2Leaf(root, path, 0);

    }

    private static void printRoot2Leaf(TreeNode root, int[] path, int len) {
        if (root == null) {
            return;
        }

        path[len++] = root.getData();
        if (TreeOperations.isLeaf(root)) {
            for (int i = 0; i < len; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        } else {
            printRoot2Leaf(root.getLeft(), path, len);
            printRoot2Leaf(root.getRight(), path, len);
        }

    }

}
