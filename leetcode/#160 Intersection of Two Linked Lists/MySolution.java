/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        HashMap<Integer , ListNode> hashmap = new HashMap();
        
        ListNode tempA = headA;
        while(tempA != null){
            hashmap.put(tempA.val , tempA);
            tempA = tempA.next;
        }
        
        ListNode tempB =  headB;
        while(tempB != null){
            if(hashmap.get(tempB.val) != null){
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }
}
