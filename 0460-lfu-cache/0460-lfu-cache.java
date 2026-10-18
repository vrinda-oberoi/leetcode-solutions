class LFUCache {
    class Node{
        int key,value,freq;
        Node prev;
        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class NodeList{
        int listSize;
        Node head;
        Node tail;

        public NodeList(){
            this.listSize = 0;
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node node){
            Node nextnode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextnode;
            nextnode.prev = node;
            listSize++;
        }

        public void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

        public Node removeLRU() {
            if (listSize > 0) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                return lruNode;
            }
            return null;
        }
    }

    private int capacity;
    private int minFreq;
    private int currentSize;
    private HashMap<Integer,Node> keyToNode;
    private HashMap<Integer,NodeList> freqToLinkedList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.currentSize = 0;
        this.keyToNode = new HashMap<>();
        this.freqToLinkedList = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;

        // If key already exists, update its value and frequency
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        // If capacity is reached, evict the LFU & LRU node
        if (currentSize >= capacity) {
            NodeList minFreqList = freqToLinkedList.get(minFreq);
            Node evictedNode = minFreqList.removeLRU();
            keyToNode.remove(evictedNode.key);
            currentSize--;
        }

        // Reset minFreq to 1 for the new incoming node
        minFreq = 1;
        Node newNode = new Node(key, value);

        // Get or create the frequency list for freq = 1
        NodeList list = freqToLinkedList.computeIfAbsent(1, k -> new NodeList());
        list.addNode(newNode);
        
        keyToNode.put(key, newNode);
        currentSize++;
    }
    private void updateFreq(Node node) {
        int freq = node.freq;
        NodeList oldList = freqToLinkedList.get(freq);
        oldList.removeNode(node);

        // If the old list becomes empty and it was our minimum frequency, increment minFreq
        if (freq == minFreq && oldList.listSize == 0) {
            minFreq++;
        }

        node.freq++;
        NodeList newList = freqToLinkedList.computeIfAbsent(node.freq, k -> new NodeList());
        newList.addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */