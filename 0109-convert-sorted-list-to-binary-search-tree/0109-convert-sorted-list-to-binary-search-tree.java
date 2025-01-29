class Solution {
    private ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = getSize(head);  // Step 1: Get the size of the linked list
        return sortedListToBSTHelper(0, size - 1);  // Step 2: Recursively build the tree
    }
    
    // Step 1: Get the size of the linked list
    private int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    
    // Step 2: Recursively build the BST
    private TreeNode sortedListToBSTHelper(int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;  // Find the middle element
        TreeNode leftChild = sortedListToBSTHelper(left, mid - 1);  // Build the left subtree
        
        // The current node is the middle element
        TreeNode root = new TreeNode(head.val);
        root.left = leftChild;
        
        // Move the head pointer to the next element in the linked list
        head = head.next;
        
        root.right = sortedListToBSTHelper(mid + 1, right);  // Build the right subtree
        
        return root;
    }
}
