public class SearchTree {

    // -------------------------
    // A. TreeNode Structure
    // -------------------------
    private class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private TreeNode root;

    // -------------------------
    // B. Core BST Operations
    // -------------------------

    // INSERT
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null)
            return new TreeNode(value);

        if (value < node.value)
            node.left = insertRecursive(node.left, value);
        else if (value > node.value)
            node.right = insertRecursive(node.right, value);
        // duplicates NOT inserted

        return node;
    }

    // SEARCH
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode node, int value) {
        if (node == null)
            return false;

        if (node.value == value)
            return true;

        if (value < node.value)
            return searchRecursive(node.left, value);
        else
            return searchRecursive(node.right, value);
    }

    // DELETE
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode node, int value) {
        if (node == null)
            return null;

        if (value < node.value) {
            node.left = deleteRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRecursive(node.right, value);
        } else {
            // Case 1: No child
            if (node.left == null && node.right == null)
                return null;

            // Case 2: One child
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            // Case 3: Two children (inorder successor)
            node.value = findMin(node.right);
            node.right = deleteRecursive(node.right, node.value);
        }

        return node;
    }

    private int findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node.value;
    }

    // -------------------------
    // Traversals
    // -------------------------

    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(TreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.value + " ");
            inorderRecursive(node.right);
        }
    }

    public void reverseOrderTraversal() {
        reverseRecursive(root);
        System.out.println();
    }

    private void reverseRecursive(TreeNode node) {
        if (node != null) {
            reverseRecursive(node.right);
            System.out.print(node.value + " ");
            reverseRecursive(node.left);
        }
    }

    public void preorderTraversal() {
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }

    public void postorderTraversal() {
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(TreeNode node) {
        if (node != null) {
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(node.value + " ");
        }
    }

    // -------------------------
    // HEIGHT
    // -------------------------
    // Empty tree height = -1
    public int getHeight() {
        return heightRecursive(root);
    }

    private int heightRecursive(TreeNode node) {
        if (node == null)
            return -1;
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }
}