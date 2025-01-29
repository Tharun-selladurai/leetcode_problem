public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Start at the root of the BST
        while (root != null) {
            // If both p and q are smaller, move to the left child
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater, move to the right child
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If one is smaller and the other is greater, we've found the LCA
            else {
                return root;
            }
        }
        return null;
    }
}
