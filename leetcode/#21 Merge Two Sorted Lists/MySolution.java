class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); 
        ListNode tail = head;
        ListNode temp1 = l1;
        ListNode temp2  =l2;
        while(temp1 != null || temp2 != null){
            
            if(temp1 != null && temp2 != null){
                if(temp1.val > temp2.val){
                    tail.next = temp2;
                    temp2 = temp2.next;
                }else{
                    tail.next = temp1;
                    temp1 = temp1.next;
                }
            }
            else if(temp1 != null){
                tail.next = temp1;
                temp1 = temp1.next;
            }
            else if(temp2 != null){
                tail.next = temp2;
                temp2 = temp2.next;
            }
             tail = tail.next;
            
            
        }
        return head.next;
    }
}