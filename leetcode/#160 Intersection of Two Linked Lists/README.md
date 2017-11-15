Link : https://leetcode.com/problems/intersection-of-two-linked-lists/description/

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A: a1 → a2 → c1 → c2 → c3

B: b1 → b2 → b3 → c1 → c2 → c3

begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.

The linked lists must retain their original structure after the function returns.

You may assume there are no cycles anywhere in the entire linked structure.

Your code should preferably run in O(n) time and use only O(1) memory.

---------------------------------
## My Solution
#### 1.因為不知道兩個List何時會有交集，如果是一般的做法，可能也是用兩層Loop讓兩個List中的節點一一比對;但是這樣的時間複雜度就是o(n^2)。

#### 2.如果要產生交集的話，那就代表B當中有某個節點會出現在A中。因此，這便使用了HashMap先將A每個節點記錄下來，那這樣在檢查B的節點時候，就非常方便的知道B節點是否有出現在A當中。
    while(tempA != null){
        hashmap.put(tempA.val , tempA);
        tempA = tempA.next;
    }

#### 3.如果B節點的值當作key去hashMap找，若get的值是null，那就代表這個節點不在Ａ中;若get的值不是null，那就代表這節點是在A當中，那這個節點，也就是這題目要尋找的交集點。
    while(tempB != null){
        if(hashmap.get(tempB.val) != null){
        return tempB;
    }
        tempB = tempB.next;
    }    

---------------------------------
