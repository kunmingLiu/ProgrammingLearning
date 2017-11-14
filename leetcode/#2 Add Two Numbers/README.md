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

------------------------------

## Better Solution
##### 1.不用寫一大堆if else來判斷兩個節點各種空值的排列組合。而是如果發現第一個節點不為Null，就把值加進sum中，並且讓第一個節點往下走;第二個節點也是如此。
    while (l1 != null || l2 != null) {
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
    }
    
##### 2.因為一開始head是null，因此必須在while中寫進if else來判斷現在head是不是null，但是每次迴圈都要判斷一次，以效率來說是不好的;因此，改成在一開始就先new好，只是最後要return的時候，不是是return head，而是return head.next。
    ListNode dummy = new ListNode(0), pre = dummy;
    ......
    return dummy.next;

##### 3.個位數＋個位數不可能發生進位值>1的情況，因此若最後一位有發生進位的時候，其實就直接new ListNode(1)就好了，不用再做％。
    if (sum != 0)
      pre.next = new ListNode(1);



