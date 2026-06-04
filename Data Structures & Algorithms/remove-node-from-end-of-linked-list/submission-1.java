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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        if (head.next == null) return null;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        // if n is equal to size, that mean first element needs to be deleted
        if (fast == null) {
            return head.next;
        }

        // after this slow will point to the prev node of the one that needs to be deleted.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;
        return head;
    }
}
