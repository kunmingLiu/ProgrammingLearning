public class LRUCache {
    private int capacity = 0;
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public void put(int key, int value){
        if(head == null){
            head = new Node(key, value);
            tail = head;
            size ++ ;
        }else{
            Node result = getNode(key);
            if(size < capacity){
                if(result == null){
                    Node lastNode = new Node(key, value);
                    tail.next = lastNode;
                    lastNode.prev = tail;
                    tail = tail.next;
                    size ++ ;
                }else{
                    result.val = value;
                }
            }else{
                if(result == null){
                    result = new Node(key, value);
                }
                //Node lastNode = new Node(key, value);
                if(head.next == null){
                    head = result;
                    tail = head;

                }else{
                    head = head.next;
                    head.prev = null;
                    tail.next = result;
                    result.prev = tail;
                    tail = tail.next;
                }

            }

        }
    }
    public Node getNode(int key){
        if(head == null){
            return  null;
        }else{
            Node temp = head;
            while (temp.next != null && temp.key != key){
                temp = temp.next;
            }
            if(temp.key != key){
                return  null;
            }else{
                if(temp.prev == null){
                    if(temp.next != null){
                        head = temp.next;
                        temp.next.prev = null;
                        tail.next = temp;
                        temp.prev = tail;
                        temp.next = null;
                        tail = tail.next;


                    }
                }else if(temp.next == null){
                    //nothing
                }else{
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    tail.next = temp;
                    temp.next = null;
                    tail = tail.next;
                }
                return temp;
            }
        }
    }
    public int get(int key){
        Node node = getNode(key);
        if(node == null){
            return -1;
        }else{
            return node.val;
        }
    }
    class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;

        Node(int key , int val) {
            this.val = val;
            this.key = key;
            prev = null;
            next = null;
        }
    }
}
