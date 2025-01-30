class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted
        }

        ListNode dummy = new ListNode(0); // Dummy node for sorted part
        ListNode curr = head; // Current node to be inserted

        while (curr != null) {
            ListNode prev = dummy; // Start from the beginning of sorted list
            ListNode next = curr.next; // Save next node to process

            // Find the correct insertion position
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in original list
            curr = next;
        }

        return dummy.next;
    }
}
