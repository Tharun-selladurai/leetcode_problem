class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle if the list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps
            if (slow == fast) {     // Cycle detected
                // Step 2: Find the start of the cycle
                ListNode start = head;
                while (start != slow) {
                    start = start.next; // Move start pointer one step
                    slow = slow.next;   // Move slow pointer one step
                }
                return start; // Start of the cycle
            }
        }

        return null; // No cycle
    }
}


