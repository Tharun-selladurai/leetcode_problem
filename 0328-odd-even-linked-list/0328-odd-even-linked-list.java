class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If the list has 0 or 1 node, no rearrangement is needed
        }

        ListNode odd = head; // Start with the first (odd) node
        ListNode even = head.next; // Start with the second (even) node
        ListNode evenHead = even; // Keep track of the head of the even list

        while (even != null && even.next != null) {
            odd.next = even.next; // Connect odd to the next odd-indexed node
            odd = odd.next; // Move the odd pointer forward

            even.next = odd.next; // Connect even to the next even-indexed node
            even = even.next; // Move the even pointer forward
        }

        odd.next = evenHead; // Connect the end of the odd list to the head of the even list
        return head;
    }
}

