package HashTable;

public class MyHashMap {
    private int M;//链表数组长度
    private static final int DEFAULT_SIZE = 107;
    LinkedList[] lists;

    public MyHashMap() {//初始化哈希表
        this(DEFAULT_SIZE);
    }

    private MyHashMap(int size) {
        this.M = size;
        lists = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            lists[i] = new LinkedList();
        }
    }

    public void put(int key, int value) {
        //可以直接使用Integer.valueOf(key).hashCode()方法得到内置的哈希码
        //不过这里使用了自己写的哈希函数
        Node node = lists[hash(key)].head.next;
        while (node != null) {
            if (key == node.key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node next = lists[hash(key)].head.next;
        lists[hash(key)].head.next = new Node(key, value, next);
    }

    public int get(int key) {
        Node node = lists[hash(key)].head.next;
        while (node != null) {
            if (node.key == key) {//命中
                return node.value;
            }
            node = node.next;
        }
        return -1;//未命中
    }

    public void remove(int key) {
        Node first = lists[hash(key)].head.next;
        Node pre = lists[hash(key)].head;
        while (first != null) {
            if (first.key == key) {
                pre.next = first.next;
            }
            pre = first;
            first = first.next;
        }
    }
    private int hash(int key) {//获得哈希值，一般是使用key自己的hashCode()，不过这里用了自己写的
        return key % M;
    }

    private class LinkedList {//链表
        Node head;

        public LinkedList() {
            head = new Node();
        }
    }

    private class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {//用来存储映射关系的节点
            this.key = key;
            this.next = next;
            this.value = value;
        }

        public Node() {//用来当链表的头节点
        }
    }
}
