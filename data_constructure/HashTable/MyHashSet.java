package HashTable;


public class MyHashSet {
    private LinkedList[] lists;//哈希表
    private static final int DEFAULT_SIZE = 107;//哈希表长度

    public MyHashSet() {//初始化哈希表
        this(DEFAULT_SIZE);
    }

    private MyHashSet(int size) {
        lists = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            lists[i] = new LinkedList();
        }
    }

    public void add(int key) {//添加方法
        Node first = lists[hash(key)].head.next;
        while (first != null) {
            if (first.key == key) {
                return;
            }
            first = first.next;
        }
        //每遇到一个新节点添加进链表的头部
        lists[hash(key)].head.next = new Node(key, lists[hash(key)].head.next);
    }

    public void remove(int key) {//删除key方法
        Node pre = lists[hash(key)].head;
        Node first = lists[hash(key)].head.next;
        while (first != null) {
            if (first.key == key) {
                pre.next = first.next;
                return;
            }
            pre = first;
            first = first.next;
        }
    }

    public boolean contains(int key) {//判断是否包含方法
        Node first = lists[hash(key)].head.next;
        while (first != null) {
            if (first.key == key) {
                return true;
            }
            first = first.next;
        }
        return false;
    }

    private int hash(int key) {//哈希函数
        return key % DEFAULT_SIZE;
    }

    private class LinkedList {//自定义一个链表
        Node head;

        public LinkedList() {
            head = new Node(0, null);
        }
    }

    private class Node {//链表的节点
        int key;
        Node next;

        public Node(int key, Node next) {
            this.next = next;
            this.key = key;
        }
    }
}
