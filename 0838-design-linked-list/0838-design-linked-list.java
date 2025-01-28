class MyLinkedList {
    // Definition for doubly-linked list node
    private class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail; // Pointers to the head and tail of the linked list
    private int size;        // Size of the linked list

    // Initialize the linked list
    public MyLinkedList() {
        head = new Node(0); // Sentinel node for the head
        tail = new Node(0); // Sentinel node for the tail
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // Get the value of the index-th node in the linked list
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = getNodeAt(index);
        return curr.val;
    }

    // Add a node of value val before the first element
    public void addAtHead(int val) {
        Node node = new Node(val);
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;

        size++;
    }

    // Append a node of value val to the end
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;

        size++;
    }

    // Add a node of value val before the index-th node
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        Node prev = index == size ? tail.prev : getNodeAt(index).prev;
        Node next = prev.next;

        Node node = new Node(val);
        prev.next = node;
        node.prev = prev;

        node.next = next;
        next.prev = node;

        size++;
    }

    // Delete the index-th node in the linked list
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        Node curr = getNodeAt(index);
        Node prev = curr.prev;
        Node next = curr.next;

        prev.next = next;
        next.prev = prev;

        size--;
    }

    // Helper function to get the node at a specific index
    private Node getNodeAt(int index) {
        Node curr;
        if (index < size / 2) {
            // Traverse from head
            curr = head.next;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            // Traverse from tail
            curr = tail.prev;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }
}
