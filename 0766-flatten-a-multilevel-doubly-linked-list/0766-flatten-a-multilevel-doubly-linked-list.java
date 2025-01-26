class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        
        while (curr != null) {
            if (curr.child != null) {
                // Step 1: Flatten the child list
                Node child = curr.child;
                curr.child = null;  // Set child pointer to null
                
                // Step 2: Find the last node of the child list
                Node temp = child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                
                // Step 3: Connect the child list to the current node
                temp.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = temp;  // Connect the previous pointer of the next node
                }
                
                // Step 4: Connect the current node to the child
                curr.next = child;
                child.prev = curr;
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}
