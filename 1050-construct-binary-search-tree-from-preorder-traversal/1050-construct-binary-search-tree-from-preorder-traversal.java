public class Solution {
    private int index = 0;  // Keeps track of the current index in preorder array

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int lower, int upper) {
        if (index == preorder.length) {
            return null;
        }

        int value = preorder[index];
        
        // If the current value is out of the valid range, return null
        if (value < lower || value > upper) {
            return null;
        }

        // Move to the next element
        index++;

        // Create the root node for the current subtree
        TreeNode root = new TreeNode(value);

        // Recursively build the left subtree (all values must be less than current value)
        root.left = helper(preorder, lower, value);
        
        // Recursively build the right subtree (all values must be greater than current value)
        root.right = helper(preorder, value, upper);

        return root;
    }
}
