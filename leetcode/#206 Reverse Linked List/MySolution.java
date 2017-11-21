/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode tail = new ListNode(-1);
        ListNode reverse =  recursiveReverse(head,tail);
        return tail.next;
    }
    private ListNode recursiveReverse(ListNode head , ListNode tail){
        if(head.next == null){
            tail.next = head;
            return tail.next;
        }
        tail = recursiveReverse(head.next , tail);
        head.next = null;
        tail.next = head;
        return tail.next;
    }
}
