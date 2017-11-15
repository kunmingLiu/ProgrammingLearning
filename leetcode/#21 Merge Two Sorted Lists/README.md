link : https://leetcode.com/problems/merge-two-sorted-lists/description/

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

----------------------------
## My Solution
##### 1.因為不希望在while迴圈每次都要判斷head是否為null，所以在一開始先將head初始化;只是最後return的是head.next。
    ListNode head = new ListNode(0); 
    return head.next;
    
##### 2.因為要做排序，因此如果l1跟l2都不是null，那就將兩個節點做比較，看誰比較小就用誰。
    if(temp1 != null && temp2 != null){
        if(temp1.val > temp2.val){
            tail.next = temp2;
            temp2 = temp2.next;
        }else{
            tail.next = temp1;
            temp1 = temp1.next;
        }
    }
##### 3.若其中一方已經是null，那就直接以不是null的為主。
    else if(temp1 != null){
        tail.next = temp1;
        temp1 = temp1.next;
    }
    else if(temp2 != null){
        tail.next = temp2;
        temp2 = temp2.next;
    }

----------------------------
## Better Solution
##### 1.每次做的事情都相同，只是比較的節點會有所不同而已。因此可以使用遞迴的方式來處理。
    if(l1.val > l2.val) {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
