public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode d1 = new ListNode(0), d2 = new ListNode(0);
        d1.next = headA;
        d2.next = headB;
        while(headA != null) {
            l1++;
            headA = headA.next;
        }
        while(headB!=null) {
            l2++;
            headB = headB.next;
        }
        int d = l2 > l1? l2-l1 : l1-l2;
        if (l2 > l1) {
            ListNode t = d1;
            d1 = d2;
            d2 = t;
        }
        for (int i = 0; i < d; i++) d1 = d1.next;
        while (d1 != d2) {
            d1 = d1.next;
            d2 = d2.next;
        }
        return d1;
    }
}
