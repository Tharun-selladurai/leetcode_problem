class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            // If the tree is empty, insert the new node as the root
            return new TreeNode(val);
        }
        
        // Start from the root and search for the correct place to insert
        if (val < root.val) {
            // Go to the left subtree if the value is smaller
            root.left = insertIntoBST(root.left, val);
        } else {
            // Go to the right subtree if the value is greater
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;  // Return the unchanged root
    }
}