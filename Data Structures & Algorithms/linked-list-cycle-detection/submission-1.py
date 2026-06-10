# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return False
        slow = head
        fast = head.next

        while slow != fast and fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        return fast is not None and fast.next is not None
        
        