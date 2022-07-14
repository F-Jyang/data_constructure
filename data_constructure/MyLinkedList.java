class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(3, 2);
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val, head, head.next);
        head.next.pre = newNode;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val, tail.pre, tail);
        tail.pre.next = newNode;
        tail.pre = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node newNode = new Node(val, node, node.next);
        node.next.pre = newNode;
        node.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || size < 0) return;
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }


    public void reverse() {
        int[] list=new int[size];
        Node node=head.next;
        int idx=0;
        while (node.next!=null&&node.next.next!=tail){
            list[idx++]=node.val;
            node=node.next;
        }
        node=head.next;
        idx=0;
        while(idx<size) {
            node.val = list[idx++];
            node = node.next;
        }
    }

    static class Node {
        Node pre;
        Node next;
        int val;

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node() {

        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */