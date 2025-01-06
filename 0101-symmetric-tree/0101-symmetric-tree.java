/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return issyme(root.left,root.right);
        
    }
    boolean issyme(TreeNode a,TreeNode b)
    {
        if(a==null&&b==null)return true;
        if(a==null&&b!=null)
        {
            return false;
        }
        if(b==null&&a!=null)
        {
            return false;
        }
        if(a.val!=b.val)
        {
            return false;
        }
        return issyme(a.left,b.right)&&issyme(a.right,b.left);
    }
}