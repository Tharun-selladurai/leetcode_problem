class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: if there is only one node
        if (head == null || head.next == null) {
            return null;  // Removing the only node in the list
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move slow by 1 step and fast by 2 steps until fast reaches the end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Now `slow` is at the middle node, and `prev` is the node before it
        if (prev != null) {
            prev.next = slow.next;  // Remove the middle node
        }
        
        return head;
    }
}
