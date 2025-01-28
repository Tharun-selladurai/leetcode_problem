/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;  // This will point to the node before position `a`
        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        ListNode afterB = prevA;  // This will point to the node after position `b`
        for (int i = 0; i < b - a + 2; i++) {
            afterB = afterB.next;
        }

        // Step 2: Connect `prevA` to the head of `list2`
        prevA.next = list2;

        // Step 3: Traverse to the end of `list2` and connect to `afterB`
        ListNode current = list2;
        while (current.next != null) {
            current = current.next;
        }
        current.next = afterB;

        return list1;
        
    }
}