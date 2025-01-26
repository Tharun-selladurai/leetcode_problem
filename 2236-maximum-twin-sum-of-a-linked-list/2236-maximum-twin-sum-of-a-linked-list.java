class Solution {
    public int pairSum(ListNode head) {
        // Step 1: Use slow and fast pointers to find the middle of the list
        ListNode slow = head, fast = head;
        
        // Move slow pointer by 1 and fast pointer by 2 steps to find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the list starting from slow pointer
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Step 3: Calculate the twin sums and keep track of the maximum twin sum
        int maxTwinSum = 0;
        ListNode firstHalf = head;
        ListNode secondHalf = prev; // second half starts at the reversed list
        
        // Compare corresponding nodes from the first half and the reversed second half
        while (secondHalf != null) {
            maxTwinSum = Math.max(maxTwinSum, firstHalf.val + secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return maxTwinSum;
    }
}
