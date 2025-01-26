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
   
        public int numComponents(ListNode head, int[] nums) {
        // Convert nums array to a HashSet for efficient lookups
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int count = 0; // Count of connected components
        boolean inComponent = false;

        // Traverse the linked list
        while (head != null) {
            if (numSet.contains(head.val)) {
                if (!inComponent) {
                    // Start of a new component
                    count++;
                    inComponent = true;
                }
            } else {
                // End of the current component
                inComponent = false;
            }
            head = head.next;
        }

        return count;
    }
    
}