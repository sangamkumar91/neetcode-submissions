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
    Node tail;
    Node head;
    public LRUCache(int capacity) {
        cap = capacity;
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

        // RESET HEAD and TAIL
        if (m == tail) {
            tail = prev;
        }
        if (m == head) {
            head = next;
        }
    }

    public void addNode(Node m) {
        // Add to head
        m.next = head;
        if (head != null)
            head.prev = m;
        head = m;

        // Set tail if first element;
        if (tail == null) {
            tail = m;
        }
    }

    public int get(int key) {
        System.out.println("get");

        if (!store.containsKey(key)) return -1;
        Node m = store.get(key);
        System.out.println(store.toString());
        detachNode(m);
        addNode(m);
        System.out.println("get");
        return m.val;
        
    }
    
    public void put(int key, int value) {
        System.out.println("put");
        System.out.println(store.toString());

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
            Node x = tail;
            store.remove(x.key);
            detachNode(x);
            size--;
        }
    }
}
