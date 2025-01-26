class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // Step 1: Calculate the length of the list
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        
        // Step 2: Find the kth node from the beginning
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        
        // Step 3: Find the kth node from the end
        ListNode second = head;
        for (int i = 1; i < length - k + 1; i++) {
            second = second.next;
        }
        
        // Step 4: Swap the values of the two nodes
        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;
        
        // Step 5: Return the modified list
        return head;
    }
}
