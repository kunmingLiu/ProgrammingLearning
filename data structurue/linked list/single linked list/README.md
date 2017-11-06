![image](https://github.com/kunmingLiu/MyPicture/blob/master/single_linked_list.PNG)
圖片來源 :https://en.wikipedia.org/wiki/Linked_list

-------------------------------
1.Single Linked List每個節點中除了資料之外，還會有另一個next變數來記錄下一個節點的位置。

2.添加新節點 : 因為不知道最後一個是誰，所以必須要從頭開始找，當找到某個節點的next是null，那就代表它是最後一個元素，那直接讓這個元素的next指向新節點即可。

ex. 添加node3在最後一個

node1 -> node2(node2.next == null，因此node2是List中最後一個節點) => node1-> node2 -> node3(將node3加在node2後面)

3.刪除節點 : 要刪除某個節點的時候，必須要把那個節點的前一個的next改成指向那個節點的下一個;但是每個node並不會知道自己前一個是誰，因此必須要從頭開始掃，並且同時將每個節點的前一個節點記錄下來，那這樣刪除某個節點的時候，就可以知道前一個節點是誰，那這樣就可以將前一個節點的next指向自己原本的下一個節點，那這樣就完成了刪除的動作。

要刪除node2，因此先從頭開始一個一個掃，然後掃到node2的時候，同時會有另一個變數將node2的前一個node1記錄下來，那這樣就可以將node1.next指向node2的下一個(node3)，那這樣就完成了刪除的動作。

ex.刪除node2

node1 -> node2 -> node3 => node1 -> node3 (那node2已經不在List中了，代表已經被刪除了)

4.要找某個節點的時候，也是要從頭開始一個一個比較，當掃到最後一個元素(node.next==null)時，都沒有發現該節點的話，那就代表該節點不在List中。

5.添加節點在某個特定位置 : 透過4的步驟找出那個節點或是特定位置之後，先將新的節點的next指向特定節點位置的next，之後再將特定節點位置的next指向新節點。

ex.添加node2在node1後面

node1 -> node3 => 先透過步驟4找出node1的位置，然後將node2的next指向node1的next(node2.next = node1.next)，那此時node1跟node2的next都是指向node3;只要再將node1的next指向node2就完成了。

node1 -> node2 -> node3

Note :

當改變next的時候，順序是非常重要的，若順序有錯，可能會導致next後的節點都沒有辦法可以再指向。

ex.添加node2在node1後面

node1 -> node3 =>　原本的node3的位置是記錄在node1.next中，如果先將node1的next指向node(node1.next = node)，那就沒有人知道node3的位置了，因此node3就不見了。因此一定要先將node2.next指向node3，才可以將node1.next指向node2。


