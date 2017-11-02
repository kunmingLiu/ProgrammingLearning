public class LRUCache {
    private int capacity = 0;
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    private HashMap<Integer, Node> caches  = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        caches = new HashMap<>();
        head = new Node(0,0);//多增加兩個額外的節點，這樣做的好處就是不用一直去改變head或是tail
        tail = new Node(0,0);//不管元素怎麼變，架構都會是head -> node1 -> node2 -> tail
                            //要改變第一個元素時，只要將該元素放在head.next即可 ; 若要改變最後一個，則是修改tail.prev
    }

    public void put(int key , int value){
        if(head.next == null){//代表List中，沒有任何元素
            Node node = new Node(key , value);
            //before : head -> tail , head <- tail
            head.next = node;//head -> node
            tail.prev = node;//node <- tail
            node.next = tail;//node -> tail
            node.prev = head;//head <- node
            //after  : head -> node -> tail , head <- node <- tail
            caches.put(key , node);//將元素放進cache中
            size++;
        }else{
            Node node = caches.get(key);
            if(node != null){ //這個key已經存在於cache中，直接拿出來用即可。但是必須將此元素的位置改成是最後一個
                node.val = value;//修改value
                //before : head -> node' -> node -> node! -> tail , head <- node' <- node <- node! <- tail
                //要將node放在tail的前面
                (node.prev).next = node.next; //node的前一個(node')的next指向node的下一個(node!) : node' -> node!
                (node.next).prev = node.prev;//node的下一個(node!).prev指向node的前一個(node') : node' <- node!
                //after : head -> node' -> node! -> tail , head <- node' <- node! <- tail

                (tail.prev).next = node; //尾巴的前一個(node!)的next指向node : node! -> node
                node.prev = tail.prev; //將node的prev指向尾巴前一個node(node!) : node! <- node

                tail.prev = node;//將尾巴的prev指向node : node <- tail
                node.next = tail;//node的next指向tail : node -> tail
                //after : head -> node' -> node! -> node -> tail , head <- node' <- node! <- node <- tail
            }else{
                if(size == capacity){//空間已經滿了，所以要替換掉最舊的資料(head.next)
                    node = new Node(key , value);
                    //before : head -> node' -> node! -> tail , head <- node' <- node! <- tail
                    //要添加一個新的node，並且將node'移除
                    (tail.prev).next = node;//尾巴前一個(node!)的next指向node : node! -> node
                    node.prev = tail.prev;//將node的prev指向尾巴的前一個(node!) : node! <- node
                    node.next = tail;//node的next指向tail : node -> tail
                    tail.prev = node;//將尾巴的prev指向node : node <- tail
                    //after : head -> node' -> node! -> node -> tail , head <- node' <- node! <- node <- tail
                    caches.remove(head.next.key);//從cache中移除掉最舊資料(head.next)的key
                    ((head.next).next).prev = head;//將head.next(node').next(node!)的prev指向head :  head <- node!
                    head.next = (head.next).next;//將head的next指向head.next(node').next(node!)  : head -> node!
                    //after : head -> node! -> node -> tail , head <- node! <- node <- tail
                    caches.put(key , node);//將新的node放進cache中
                }else{//空間還沒有滿，可以直接添加新的node，因為是最新的資料，因此要放在tail的前面
                    node = new Node(key , value);
                    //before : head -> node' -> node! -> tail , head <- node' <- node! <- tail
                    //要添加一個新的node
                    (tail.prev).next = node;//尾巴前一個(node!)的next指向node : node! -> node
                    node.prev = tail.prev;//將node的prev指向尾巴的前一個(node!) : node! <- node

                    tail.prev = node;//將尾巴的prev指向node : node <- tail
                    node.next = tail;//node的next指向tail : node -> tail
                    //after : head -> node' -> node! -> node -> tail , head <- node' <- node! <- node <- tail
                    caches.put(key , node);//將新的node放進cache中
                    size++;
                }
            }
        }
    }
    public void putNode(Node node){
        (node.prev).next = node.next; //node的前一個(node')的next指向node的下一個(node!) : node' -> node!
        (node.next).prev = node.prev;//node的下一個(node!).prev指向node的前一個(node') : node' <- node!
        //after : head -> node' -> node! -> tail , head <- node' <- node! <- tail

        (tail.prev).next = node; //尾巴的前一個(node!)的next指向node : node! -> node
        node.prev = tail.prev; //將node的prev指向尾巴前一個node(node!) : node! <- node

        tail.prev = node;//將尾巴的prev指向node : node <- tail
        node.next = tail;//node的next指向tail : node -> tail
    }
    public int get(int key){
        Node node = caches.get(key);
        if(node == null){//如果key不在cache中，則就return -1
            return  -1;
        }else{
            putNode(node);//有的話，就將此node的位置改放在tail前面
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
