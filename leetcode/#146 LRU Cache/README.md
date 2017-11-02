Link : https://leetcode.com/problems/lru-cache/description/
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);

cache.put(2, 2);

cache.get(1);       // returns 1

cache.put(3, 3);    // evicts key 2

cache.get(2);       // returns -1 (not found)

cache.put(4, 4);    // evicts key 1

cache.get(1);       // returns -1 (not found)

cache.get(3);       // returns 3

cache.get(4);       // returns 4
---------------------------------------------------
Note : 

version1.(MySolution)

1.一開始想到用Single LinkedList來完成，因為這樣當有新的資料的話，就把它加在List的最後面;而當空間不夠的時候，則就先將head移除。

2.每次get的時候，若是get的key是在List中，則就將該元素改到最後一個。

problems : 

1.執行速率太慢，因為每次要put新元素的時候，都還是得要將List掃過一遍，這樣才有辦法將新元素放在最後一個。

2.get的時候，也是必須要一個一個從頭找。

---------------------------------------------------

version2.(MySolution2)

1.改成用douly Linked List來實作，並增加tail。那當要增加新元素或更動舊元素位置的時候，就可以直接加在tail的前面，不需要一個一個從頭掃。

problems : 

1.執行速率太慢，get的時候，還是是必須要一個一個從頭找。

---------------------------------------------------

version3.(MySolution3)

1.看了leetcode討論區的作法，就是多使用一個hashmap來當cache;hashmap裡面會記錄key跟node，當增加了新node，則就put進hashmap中，而當空間滿了要移除元素，
則同時將該元素從移除hashmap移除。

2.使用hashmap的好處就是當get的時候，可以直接取得那個key在List中的node，之後再依據doubly Linked List的特性，非常方便的將node加在tail前面。

3.當空間滿了時候，則將目前head的key從hashmap移除。



