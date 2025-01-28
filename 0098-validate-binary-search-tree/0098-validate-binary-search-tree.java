public class Solution {
    public boolean isValidBST(TreeNode root) {
        // Call the helper function with the initial range of valid values
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTHelper(TreeNode node, long lower, long upper) {
        // Base case: if the node is null, it's a valid BST
        if (node == null) {
            return true;
        }
        
        // The current node's value must be within the range [lower, upper]
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        
        // Recursively check the left and right subtrees with updated bounds
        return isValidBSTHelper(node.left, lower, node.val) &&
               isValidBSTHelper(node.right, node.val, upper);
    }
}
