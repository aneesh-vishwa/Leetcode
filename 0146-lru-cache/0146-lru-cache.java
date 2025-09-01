class Node {
    int key;
    int data;
    Node next = null;
    Node prev = null;

    Node(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);//dummy node
    Node tail = new Node(0, 0);//dummy node
    private int capacity;


    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    private void remove(Node node){
        map.remove(node.key);//removes that element from the map
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert_after_head(Node node){
        if(!map.containsKey(node.key)){
            map.put(node.key,node);
        }
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert_after_head(node);
            return node.data;

        }
        else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert_after_head(new Node(key, value));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */