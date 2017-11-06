class LRUCache {
    private class listNode {
        listNode prev;
        listNode next;
        int key;
        int value;
        public listNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, listNode> map = new HashMap<>();
    List<Integer> list = new LinkedList<>();
    listNode head = new listNode(-1, -1);
    listNode tail = new listNode(-1, -1);
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.tail.prev = this.head;
        this.head.next = this.tail;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        listNode currNode = map.get(key);
        currNode.next.prev = currNode.prev;
        currNode.prev.next = currNode.next;
        moveTail(currNode);
        return currNode.value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        listNode temp = new listNode(key, value);
        map.put(key, temp);
        moveTail(temp);
    }

    public void moveTail(listNode curr) {
        curr.prev = tail.prev;
        tail.prev.next = curr;
        tail.prev = curr;
        curr.next = tail;
    }
}
