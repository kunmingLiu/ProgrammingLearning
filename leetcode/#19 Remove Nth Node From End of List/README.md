Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Given n will always be valid.
Try to do this in one pass.

-----------------------------------------------------------------
Note : 
1.因為single無法知道自己的前一個是誰，因此要做刪除的時候，一定得要從頭開始一個一個慢慢找，必且要額外多用一個變數來記錄自己的前一個，
這樣刪除的時候，才能將前面的next接到要刪除元素的next。
2.但是這題要思考的是沒有辦法在最開始就知道是要刪除哪一個，因為ListNode本身的個數跟n都會影響到倒底是要刪除哪一個;雖然可以先透過一個迴圈來算出ListNode的個數，
之後有了個數後，就可以知道要刪除第幾個元素，之後再透過另一個迴圈座刪除。
3.但是題目特別要求說希望是one pass，因此我的作法是在第一次算個數的時候，順便將每個ListNode跟index都存進一個HashMap中，這樣之後確定要刪除第幾個元素後，
再把index當作key去hashMap取得該元素的前一個跟下一個，這樣就可以完成刪除的動作。
4.但是如果是刪除最後一個或是刪除第一個，或是ListNode只有一個元素都要特別處理。
