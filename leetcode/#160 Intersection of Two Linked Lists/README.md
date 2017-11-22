Link : https://leetcode.com/problems/intersection-of-two-linked-lists/description/

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:      a1 → a2 → c1 → c2 → c3

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

#### 2.如果要產生交集的話，那就代表B當中有某個節點會出現在A中。因此，這邊使用了HashMap先將A每個節點記錄下來，那這樣在檢查B的節點時候，就非常方便的知道B節點是否有出現在A當中。
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
## Better Solution
#### 1.以題目來看，會發生交集的部分，一定是某一點到最後一個點;因此如果有其中一個List比較長的話，前面幾個節點都忽略掉，要在個數相同的時候，才進行比較。

#### 2.為了要知道哪個List比較長，因此要先知道兩個List的個數。
    while(headA != null) {
        l1++;
        headA = headA.next;
    }
    while(headB!=null) {
        l2++;
        headB = headB.next;
    }

#### 3.長的那一方，必須要忽略掉多出來的那幾個節點。
    int d = l2 > l1? l2-l1 : l1-l2;
    for (int i = 0; i < d; i++) d1 = d1.next;

#### 4.之後就開始針對兩個List進行比較，一直比到有相等的節點出現。
    while (d1 != d2) {
        d1 = d1.next;
        d2 = d2.next;
    }
    





