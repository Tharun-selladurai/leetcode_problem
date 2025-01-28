from random import random

class Solution:

    def __init__(self, head: ListNode):
        self.head = head        

    def getRandom(self) -> int:
        cur_node = self.head
        counter = 1
        choice = -1
    
        while not cur_node is None:
            if random() < 1/counter:
                choice = cur_node.val
            cur_node = cur_node.next
            counter += 1
        return choice