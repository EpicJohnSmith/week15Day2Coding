package coding;

public class Main
{
    public static void main(String[] args)
    {

        SearchTree tree = new SearchTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80, 35, 45}; // inserting some values because I feel like it.

        for (int value : values) {
            tree.insert(value);
        }

        // Traversals
        // Here are the traversals that I needed help with, all right here:
        System.out.println("Inorder Traversal:");
        tree.inorderTraversal();

        System.out.println("Reverse Order Traversal:");
        tree.reverseOrderTraversal();

        System.out.println("Preorder Traversal:");
        tree.preorderTraversal();

        System.out.println("Postorder Traversal:");
        tree.postorderTraversal();

        // Search Tests
        System.out.println("Search for 40: " + tree.search(40)); // exists
        System.out.println("Search for 100: " + tree.search(100)); // does not exist
                                                            // so everything that I had confusion in the tree stuff goes here. Huh.
        // Deletions
        System.out.println("Deleting leaf node: 20");
        tree.delete(20);

        System.out.println("Deleting node with two children: 30");
        tree.delete(30);

        // Updated Traversals
        System.out.println("Updated Inorder Traversal:");
        tree.inorderTraversal();

        System.out.println("Updated Reverse Order Traversal:");
        tree.reverseOrderTraversal();

        // Height
        System.out.println("Tree Height: " + tree.getHeight());
    }
}