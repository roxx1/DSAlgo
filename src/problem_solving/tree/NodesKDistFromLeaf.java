package problem_solving.tree;

import data_structures.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class NodesKDistFromLeaf {

    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        int path[] = new int[11];
        int k = 2;
        findNodesKDistFromLeaf(root, path, 0, k);
        System.out.println(set);
    }

    private static void findNodesKDistFromLeaf(TreeNode root, int[] path, int len, int k) {
        if (root == null) {
            return;
        }
        path[len] = root.getData();
        if (TreeOperations.isLeaf(root)) {
            // store Nodes at Dist K
            if (len >= k)
                set.add(path[len - k]);
        }
        findNodesKDistFromLeaf(root.getLeft(), path, len + 1, k);
        findNodesKDistFromLeaf(root.getRight(), path, len + 1, k);
    }
}
