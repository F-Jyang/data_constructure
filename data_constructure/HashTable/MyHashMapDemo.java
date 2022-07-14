package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * #Description 哈希表练习，可以删除多次练习
 *
 * @param
 * @author Jyang.
 * #Date 2022/5/31
 * @return
 */
public class MyHashMapDemo<K extends Comparable<K>, V extends Comparable<V>> {
    public static void main(String[] args) {
        MyHashMapDemo<String, Integer> map = new MyHashMapDemo<>();
        map.put("hello", 1);
        map.put("world", 2);
        map.put("java", 3);
        for (String key : map.keySet) {
            System.out.print(key + ":" + map.get(key) + " ");
        }
        System.out.print('\n');
        map.reSize(30);
        for (String key : map.keySet) {
            System.out.print(key + ":" + map.get(key) + " ");
        }
    }

    private int size;
    private MyList<K, V>[] hashMap;
    private List<K> keySet;

    public MyHashMapDemo() {
        this.size = 101;
        this.keySet = new ArrayList<>();
        this.hashMap = (MyList<K, V>[]) new MyList[101];
        for (int i = 0; i < size; i++) {
            hashMap[i] = new MyList<>();
        }
    }

    /**
     * 添加键值对
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = hash(key.hashCode());
        MyList<K, V> list = hashMap[index];
        list.put(key, value);
        if (!keySet.contains(key)) keySet.add(key);
    }

    /**
     * 删除键值对
     *
     * @param key
     */
    public void remove(K key) {
        hashMap[hash(key.hashCode())].remove(key);
        keySet.remove(key);
    }

    /**
     * 判断是否包含键值对
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return hashMap[hash(key.hashCode())].contains(key);
    }

    public V get(K key) {
        int idx = hash(key.hashCode());
        MyList<K, V> list = hashMap[idx];
        return list.get(key);
    }

    /**
     * 得到键的集合
     *
     * @return
     */
    public Iterable<K> keySet() {
        return keySet;
    }

    /**
     * 哈希函数
     *
     * @param hashCode
     * @return
     */
    private int hash(int hashCode) {
        return hashCode % size;
    }

    /**
     * 重哈希,当表中的键值对过多时，扩建哈希表
     *
     * @param size
     */
    private void reSize(int size) {
        MyList<K, V>[] newList = (MyList<K, V>[]) new MyList[size];
        for (int i = 0; i < size; i++) {
            newList[i] = new MyList<>();
        }
        for (K key : keySet) {
            int idx = key.hashCode() % size;
            newList[idx].put(key, get(key));
        }
        hashMap = newList;
        this.size = size;
    }
}

class MyList<K extends Comparable<K>, V extends Comparable<V>> {
    Node<K, V> head = new Node<>();

    public void put(K key, V value) {
        Node<K, V> pre = head;
        Node<K, V> last = head.next;
        while (last != null) {
            if (last.key == key) {
                last.value = value;
                return;
            }
            pre = last;
            last = last.next;
        }
        pre.next = new Node<>(key, value);
    }

    public void remove(K key) {
        Node<K, V> node = head.next;
        while (node != null) {
            if (node.key.compareTo(key) == 0) {
                node.value = null;
                return;
            }
            node = node.next;
        }
    }

    public boolean contains(K key) {
        Node<K, V> node = head.next;
        while (node != null) {
            if (key.compareTo(node.key) == 0) {
                return node.value == null;
            }
            node = node.next;
        }
        return false;
    }

    public V get(K key) {
        Node<K, V> node = head.next;
        while (node != null) {
            if (node.key.compareTo(key) == 0) {
                return node.value;
            }
            node = node.next;
        }
        throw new NullPointerException();
    }

    static class Node<K extends Comparable<K>, V extends Comparable<V>> {
        K key;
        V value;
        Node<K, V> next;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
