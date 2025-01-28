class Solution {
    public ListNode modifiedList(int[] excludeValues, ListNode head) {

        java.util.BitSet excludeSet = new java.util.BitSet();
        for (int val : excludeValues) {
            excludeSet.set(val);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null) {
            if (excludeSet.get(curr.next.val)) {
                curr.next = curr.next.next;  
            } else {
                curr = curr.next;  
            }
        }

        return dummy.next;
    }
}