class Node {
    int val;
    int key;
    Node prev;
    Node next;
}
class LRUCache {
    HashMap<Integer, Node> store = new HashMap();
    int cap;
    int size = 0;
    Node tail = new Node();
    Node head = new Node();
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public void detachNode(Node m) {
        // DETACH
        Node prev = m.prev;
        Node next = m.next;
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
        m.prev = null;
        m.next = null;
    }

    public void addNode(Node m) {
        Node top = head.next;
        head.next = m;
        m.prev = head;
        m.next = top;
        top.prev = m;
    }

    public int get(int key) {

        if (!store.containsKey(key)) return -1;
        Node m = store.get(key);
        detachNode(m);
        addNode(m);
        return m.val;
        
    }
    
    public void put(int key, int value) {
        if (store.containsKey(key)) {
            store.get(key).val = value;
            this.get(key);
            return;
        }

        Node m = new Node();
        m.val = value;
        m.key = key;
        store.put(key, m);
        addNode(m);
        size++;

        if (size > cap) {
            Node x = tail.prev;
            store.remove(x.key);
            detachNode(x);
            size--;
        }
    }
}
