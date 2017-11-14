Link : https://leetcode.com/problems/add-two-numbers/description/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

------------------------------

## My Solution
##### 1.用一個while迴圈，讓兩個List一直往下一個前進。如果兩個List都不是Null，就把它相加;若其中一個是Null，則就直接以另一個為主。等兩者都為Null時，就已經合併出新的List。
    while (temp1 != null || temp2 != null) {
        if (temp1 != null && temp2 != null) {
          value = value + temp1.val + temp2.val;
        } else if (temp1 != null && temp2 == null) {
            value = value + temp1.val;
        } else if (temp1 == null && temp2 != null) {
            value = value + temp2.val;
        }
        if(temp1 != null){
            temp1 = temp1.next;
        }
        if(temp2 != null){
            temp2 = temp2.next;
        }
    }

##### 2.因為會有進位的情況發生，因此若發現兩個節點相加>9的時候，用/得到要進位的數值，用%取得個位數的值。
    if(head == null){
        head = new ListNode(value%10);
        lastNode = head;
    }else{
        lastNode.next = new ListNode(value%10);
        lastNode = lastNode.next;
    }
    value = value / 10;
##### 3.當While迴圈跑完的時候，要注意最後的節點是否有進位的情況發生，若有的話，則新的List則還要再新增一個節點。
    if(value != 0){
        lastNode.next = new ListNode(value%10);
    }
