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
    public void reorderList(ListNode head) {
        ListNode even = new ListNode();
        ListNode odd = null;
        ListNode current = head;

        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }

        int split = size/2;
        current = head;
        // Break linked list
        while(split > 0) {
            current = current.next;
            split--;
        }
        ListNode splitHead = current.next;
        current.next = null;

        //Reverse splithead
        ListNode prev = null;
        while(splitHead != null) {
            ListNode next = splitHead.next;
            if (next == null) {
                splitHead.next = prev;
                prev = splitHead;
                break;
            }

            ListNode nextnext = next.next;
            next.next = null;
            
            splitHead.next = prev;
            next.next = splitHead;
            splitHead = nextnext;
            prev = next;
        }
        odd = prev;
        even = head;
        printList(even, "odd");
        printList(odd, "odd");
        printList(odd, "odd");
        while (even != null && odd != null) {
            ListNode nextEven = even.next;
            ListNode nextOdd = odd.next;
            even.next = odd;
            odd.next = nextEven;
            even = nextEven;
            odd = nextOdd;
        }
    }

    public void printList(ListNode n, String name) {
        System.out.println(name);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}
