/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        int count = 0;
        HashMap<Integer,ListNode> hashMap = new HashMap();
        ListNode tempNode = head;
        while(tempNode != null){
            hashMap.put(++count , tempNode);
            tempNode = tempNode.next;
        }
        int index = count - n + 1;
        if(index < 1){
            return null;
        }
        if(index == count){
            ListNode node = hashMap.get(index-1);
            if(node == null){
                return null;
            }else{
                node.next = null;
            }
        }else if(index == 1){
            ListNode node = hashMap.get(index+1);
            head = node;
        }else{
            ListNode prevNode = hashMap.get(index-1);
            ListNode lastNode = hashMap.get(index+1);
            prevNode.next = lastNode;
        }
        return head;
    }
}
