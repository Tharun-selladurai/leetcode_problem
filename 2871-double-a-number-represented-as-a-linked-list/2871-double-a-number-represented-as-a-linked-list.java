class Solution {
    public ListNode doubleIt(ListNode head) {
        // Step 1: Reverse the linked list
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Step 2: Double the number and handle carry
        ListNode result = null;
        ListNode temp = prev;
        int carry = 0;
        
        while (temp != null) {
            int sum = temp.val * 2 + carry;
            carry = sum / 10;  // Carry for the next node
            sum = sum % 10;    // Single digit for the current node
            
            // Create a new node with the sum and add to the result list
            ListNode newNode = new ListNode(sum);
            newNode.next = result;
            result = newNode;
            
            temp = temp.next;
        }
        
        // If there's any carry left, add a new node for the carry
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = result;
            result = newNode;
        }
        
        return result;
    }
}
