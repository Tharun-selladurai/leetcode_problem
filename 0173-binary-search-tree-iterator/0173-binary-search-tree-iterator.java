class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);  // Initialize stack with leftmost path
    }

    // Returns the next smallest number
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeft(node.right);  // Add right subtree nodes
        }
        return node.val;
    }

    // Returns true if there are still elements in the traversal
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Push all left children onto the stack
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}