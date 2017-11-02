![image](https://github.com/kunmingLiu/MyPicture/blob/master/single_linked_list.PNG)
圖片來源 :https://en.wikipedia.org/wiki/Linked_list

-------------------------------
1.Single Linked List每個節點中除了資料之外，還會有另一個next變數來記錄下一個節點的位置。

2.添加新節點 : 因為不知道最後一個是誰，所以必須要從頭開始找，當找到某個節點的next是null，那就代表它是最後一個元素，那直接讓這個元素的next指向新節點即可。

ex.添加node在最後一個

node` -> node!(node!.next == null，因此node!是List中最後一個節點) => node`-> node! -> node(將node加在node!後面)

3.刪除節點 : 要刪除某個節點的時候，必須要把那個節點的前一個的next改成指向那個節點的下一個;但是每個node並不會知道自己前一個是誰，因此必須要從頭開始掃，並
且同時將每個節點的前一個節點記錄下來，那這樣刪除某個節點的時候，就可以知道前一個節點是誰，那這樣就可以將前一個節點的next指向自己原本的下一個節點，那這樣
就完成了刪除的動作。

要刪除node，因此先從頭開始一個一個掃，然後掃到node的時候，同時會有另一個變數將node的前一個node`記錄下來，那這樣就可以將node`.next指向node的下一個(node!)，
那這樣就完成了刪除的動作。

ex.刪除node

node` -> node -> node! => node` -> node! (那node已經不在List中了，代表已經被刪除了)

4.要找某個節點的時候，也是要從頭開始一個一個比較，當掃到最後一個元素(node.next==null)時，都沒有發現該節點的話，那就代表該節點不在List中。

5.添加節點在某個特定位置 : 透過4的步驟找出那個節點或是特定位置之後，先將新的節點的next指向特定節點位置的next，之後再將特定節點位置的next指向新節點。

ex.添加node在node`後面

node` -> node! => 先透過步驟4找出node`的位置，然後將node的next指向node`的next(node.next = node`.next)，那此時node`跟node的next都是指向node!;
只會再將node`的next指向node就完成了。node` -> node -> node!

Note :

當改變next的時候，順序是非常重要的，若順序有錯，可能會導致next後的節點都沒有辦法可以再指向。

ex.添加node在node`後面

node` -> node! =>　原本的node!的位置是記錄在node`.next中，如果先將node`的next指向node(node`.next = node)，那就沒有人知道node!的位置了，因此node!
就不見了。因此一定要先將node.next指向node!，才可以將node`.next指向node。


