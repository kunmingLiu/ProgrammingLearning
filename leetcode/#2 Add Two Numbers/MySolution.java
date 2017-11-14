class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode lastNode = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int value = 0;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null && temp2 != null) {
              value = value + temp1.val + temp2.val;
            } else if (temp1 != null && temp2 == null) {
                value = value + temp1.val;
            } else if (temp1 == null && temp2 != null) {
                value = value + temp2.val;

            }
            if(head == null){
                head = new ListNode(value%10);
                lastNode = head;
            }else{
                lastNode.next = new ListNode(value%10);//****
                lastNode = lastNode.next;
            }
            value = value / 10;
            if(temp1 != null){
                temp1 = temp1.next;
            }
            if(temp2 != null){
                temp2 = temp2.next;
            }

        }
        if(value != 0){
            lastNode.next = new ListNode(value%10);
        }
        return head;
    }
}
