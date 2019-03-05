package data_structures.tree;

public final class BSTOperations {

    private static TreeNode root;

    public static void insertNode(TreeNode treeNode, TreeNode parent, final int data) {
        if (treeNode == null) {
            TreeNode node = new TreeNode(data);
            if (root == null) {
                root = node;
                return;
            }
            if (parent.getData() >= data) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        } else if (treeNode.getData() >= data) {
            insertNode(treeNode.getLeft(), treeNode, data);
        } else {
            insertNode(treeNode.getRight(), treeNode, data);
        }
    }

    public static TreeNode createBST() {
        final TreeNode t13 = new TreeNode(13);
        final TreeNode t4 = new TreeNode(4);
        final TreeNode t6 = new TreeNode(6);
        final TreeNode t7 = new TreeNode(7);
        final TreeNode t16 = new TreeNode(16);
        final TreeNode t9 = new TreeNode(9);
        final TreeNode t10 = new TreeNode(10);

        root = t10;

        t6.setLeft(t4);
        t6.setRight(t9);

        t9.setLeft(t7);

        t10.setLeft(t6);
        t10.setRight(t16);

        t16.setLeft(t13);

        /*
                10
             6     16
           4   9  13
         */
        return root;
    }

    public static void printTree(final TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.getLeft());
        System.out.println(root.getData());
        printTree(root.getRight());
    }

    public static void deleteNode(final int data) {
        final TreeNode nodeToDelete = find(root, data);
        final TreeNode parent = findParentOfNode(root, null, data);
        boolean isLeft = false;
        if (parent != null)
            isLeft = (parent.getLeft() == nodeToDelete);
        if (nodeToDelete == null) {
            System.out.println("Node with data " + data + " not found ");
            return;
        } else if (isLeaf(nodeToDelete)) {
            parent.setRight(null);
            parent.setLeft(null);
        } else if (isHavingSingleLeaf(nodeToDelete)) {
            if (nodeToDelete.getLeft() != null) {
                if (isLeft) {
                    parent.setLeft(nodeToDelete.getLeft());
                } else
                    parent.setRight(nodeToDelete.getLeft());
            } else {
                if (isLeft) {
                    parent.setLeft(nodeToDelete.getRight());
                } else {
                    parent.setRight(nodeToDelete.getRight());
                }
            }
        } else {
            // find inorder predecessor(left subtree max)
            final TreeNode max = findMax(nodeToDelete.getLeft());
            if (max != null) {
                final TreeNode parentMax = findParentOfNode(root, null, max.getData());
                if (parentMax == null) {
                    return;
                }
                nodeToDelete.setData(max.getData());
                if (parentMax.getLeft() == max) {
                    parentMax.setLeft(null);
                } else {
                    parentMax.setRight(null);
                }
            }
        }
    }

    public static boolean isHavingSingleLeaf(final TreeNode node) {
        if (node == null || (node.getLeft() != null && node.getRight() != null))
            return false;
        return true;
    }

    public static boolean isLeaf(final TreeNode node) {
        return node != null && (node.getLeft() == null && node.getRight() == null);
    }

    public static TreeNode find(TreeNode treeNode, final int data) {
        if (treeNode == null) return null;
        if (treeNode.getData() == data) {
            return treeNode;
        } else if (data < treeNode.getData()) {
            return find(treeNode.getLeft(), data);
        } else {
            return find(treeNode.getRight(), data);
        }
    }

    public static TreeNode findParentOfNode(TreeNode node, TreeNode parent, final int data) {
        if (node == null) return null;
        if (node.getData() == data) {
            return parent;
        } else if (data < node.getData()) {
            return findParentOfNode(node.getLeft(), node, data);
        } else {
            return findParentOfNode(node.getRight(), node, data);
        }
    }

    public static TreeNode findMax(TreeNode treeNode) {
        if (treeNode == null) return null;
        while (treeNode.getRight() != null) {
            treeNode = treeNode.getRight();
        }
        return treeNode;
    }

    public static TreeNode findMin(TreeNode treeNode) {
        if (treeNode == null) return null;
        while (treeNode.getLeft() != null) {
            treeNode = treeNode.getLeft();
        }
        return treeNode;
    }

    public static boolean isComplete(final TreeNode node) {
        if (node == null) {
            return true;
        } else if (isLeaf(node)) {
            return true;
        } else if (node.getLeft() != null && node.getRight() != null) {
            return isComplete(node.getLeft()) && isComplete(node.getRight());
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        createBST();
        System.out.println("root =>" + root.getData());

        deleteNode(16);
        deleteNode(9);
        deleteNode(10);
        printTree(root);

    }

}
