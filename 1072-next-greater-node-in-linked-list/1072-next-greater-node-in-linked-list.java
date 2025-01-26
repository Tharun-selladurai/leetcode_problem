class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // Convert the linked list into an array
        ListNode temp = head;
        List<Integer> values = new ArrayList<>();
        
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        int n = values.size();
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the list and use the stack to find the next greater nodes
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
                int index = stack.pop();
                answer[index] = values.get(i);
            }
            stack.push(i);
        }
        
        return answer;
    }
}
