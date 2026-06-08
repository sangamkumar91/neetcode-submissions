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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode();
        ListNode head = null;

        while(list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            if (head == null) {
                head = current;
            }
            current = current.next;
        }

        if (head == null) head = current;        
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }

        return head.next;
    }
}