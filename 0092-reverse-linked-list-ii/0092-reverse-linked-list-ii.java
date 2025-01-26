class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head; // No need to reverse if the list is empty or the range is a single node
        }

        // Dummy node to handle edge cases like reversing from the head of the list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to the node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist
        ListNode current = prev.next; // First node of the sublist to be reversed
        ListNode next = null; // To store the next node during reversal
        ListNode prevReversed = null; // Previous node during reversal

        for (int i = 0; i <= right - left; i++) {
            next = current.next;
            current.next = prevReversed;
            prevReversed = current;
            current = next;
        }

        // Step 3: Connect the reversed sublist back to the list
        prev.next.next = current; // Connect the end of the reversed sublist
        prev.next = prevReversed; // Connect the start of the reversed sublist

        return dummy.next;
    }
}

