package problem_solving.tree;

import data_structures.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class NextRightNodeBT {

    private static Queue<TreeNode> queue_n = new ArrayDeque<>();
    private static Queue<Integer> queue_l = new ArrayDeque<>();

    public static void main(String[] args) {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        int k = 10;
        final TreeNode node = findNextRightNode(root, k);
        if (node != null) {
            System.out.println(node.getData());
        } else {
            System.out.println("No Elt at right");
        }

    }

    private static TreeNode findNextRightNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        queue_n.offer(root); // root node
        queue_l.offer(0); //level of root

        while (!queue_n.isEmpty()) {
            final TreeNode frontNode = queue_n.poll();
            int level = queue_l.poll();

            if (frontNode.getData() == k) {
                if (queue_n.isEmpty() || queue_l.peek() != level) {
                    return null;
                }
                return queue_n.poll();
            } else {
                if (frontNode.getLeft() != null) {
                    queue_n.offer(frontNode.getLeft());
                    queue_l.offer(level + 1);
                }
                if (frontNode.getRight() != null) {
                    queue_n.offer(frontNode.getRight());
                    queue_l.offer(level + 1);
                }
            }
        }
        return null;
    }
}
