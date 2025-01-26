import java.math.BigInteger;

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Start from the head of the list
        ListNode curr = head;

        // Traverse the list
        while (curr != null && curr.next != null) {
            // Calculate the GCD of the current node and the next node
            int gcdValue = gcd(curr.val, curr.next.val);
            
            // Create a new node with the GCD value
            ListNode newNode = new ListNode(gcdValue);
            
            // Insert the new node between the current node and the next node
            newNode.next = curr.next;
            curr.next = newNode;
            
            // Move to the next node in the list (skipping the new node)
            curr = curr.next.next;
        }

        return head;
    }
    
    // Helper function to calculate GCD of two numbers
    private int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
}
