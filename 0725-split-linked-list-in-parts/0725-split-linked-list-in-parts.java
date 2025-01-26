class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Calculate the total length of the linked list
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }

        // Step 2: Determine the size of each part
        int baseSize = n / k; // Minimum size of each part
        int extra = n % k;    // Extra nodes to distribute among the first few parts

        // Step 3: Split the list
        ListNode[] result = new ListNode[k];
        current = head;

        for (int i = 0; i < k; i++) {
            // Create the i-th part
            result[i] = current;
            int partSize = baseSize + (i < extra ? 1 : 0); // Determine size of this part

            // Traverse this part
            for (int j = 0; j < partSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }

            // Break the connection to the next part
            if (current != null) {
                ListNode temp = current.next;
                current.next = null;
                current = temp;
            }
        }

        return result;
    }
}

