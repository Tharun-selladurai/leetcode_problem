class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // Flatten the left subtree
        flatten(root.left);
        
        // Flatten the right subtree
        flatten(root.right);
        
        // If the left child is not null, we need to attach it to the right of the current node
        if (root.left != null) {
            // Find the rightmost node of the left subtree
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            
            // Traverse to the end of the new right subtree (original left subtree)
            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }
            
            // Attach the original right subtree to the rightmost node
            current.right = temp;
        }
    }
}
