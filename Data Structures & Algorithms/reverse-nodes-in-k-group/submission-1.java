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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode result = null;
        ListNode groupHead = head;
        ListNode left = null;
        while(groupHead != null) {
            // Find end of Group
            int size = k;
            ListNode start = groupHead;            
            while (size > 1 && start != null) {
                start = start.next;
                size--;
            }

            if (start == null) {
                break;
            }
            // Detach Group
            if (left != null)
                left.next = null;
            ListNode right = start.next;
            start.next = null;

            // Reverse
            groupHead = reverse(groupHead);
            if (result == null)
                result = groupHead;

            // Attach Group
            if (left != null)
                left.next = groupHead;
            while (groupHead.next != null) {
                groupHead = groupHead.next;
            }            
            groupHead.next = right;

            // Reset groupHead and left for the next iteration
            left = groupHead;
            groupHead = right;
        }
        return result;
    }
    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

}
