public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Get sorted elements from both trees using in-order traversal
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        
        // Merge the two sorted lists
        return mergeSortedLists(list1, list2);
    }
    
    // In-order traversal to get sorted elements from the BST
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
    
    // Merge two sorted lists into one sorted list
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        
        // Use two pointers to merge the lists
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }
        
        // Add any remaining elements from list1
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }
        
        // Add any remaining elements from list2
        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }
        
        return result;
    }
}
