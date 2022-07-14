package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.put("hello", 1);
        tree.put("world", 2);
        System.out.println(tree.get("world"));
        System.out.println(tree.get("hell"));
        System.out.println(tree.get("hello"));
        System.out.println(tree.longestPrefixOf("hellowww"));

    }

    Node root;
    int size;

    public MyTree() {
        this.root = new Node();
        this.size = 0;
    }

    public void put(String word, int val) {
        if (word == null || word.length() == 0) return;
        size++;
        root = put(root, word, 0, val);
    }

    private Node put(Node x, String word, int d, int val) {
        if (x == null) x = new Node();
        if (d == word.length()) {
            x.val = val;
            return x;
        }
        x.next[word.charAt(d)] = put(x.next[word.charAt(d)], word, d + 1, val);
        return x;
    }

    public int get(String word) {
        if (word == null || word.length() == 0) return -1;
        Node temp = get(root, word, 0);
        if (temp == null) return -1;
        return temp.val;
    }

    private Node get(Node x, String word, int d) {
        if (x == null) return null;
        if (word.length() == d) return x;
        return get(x.next[word.charAt(d)], word, d + 1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isContain(String word) {
        return get(word) != -1;
    }

    public void deleteNode(String word) {
        root = deleteNode(root, word, 0);
        size--;
    }

    private Node deleteNode(Node x, String word, int d) {
        if (x == null) return null;
        if (word.length() == d && x.val == -1) return x;
        if (word.length() == d) {
            x.val = -1;
        } else {
            x.next[word.charAt(d)] = deleteNode(x.next[word.charAt(d)], word, d + 1);
        }
        if (x.val != -1) return x;
        for (int i = 0; i < 256; i++) {
            if (x.next[i] != null)
                return x;
        }
        return null;
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new LinkedList<>();
        Node node = get(root, prefix, 0);
        collect(node, "", queue);
        return queue;
    }

    private void collect(Node x, String prefix, Queue<String> queue) {
        if (x == null) return;
        if (x.val != -1) queue.add(prefix);
        for (int i = 0; i < 256; i++) {
            collect(x.next[i], prefix + String.valueOf(i), queue);
        }
    }

    public String longestPrefixOf(String prefix) {
        int len = search(root, prefix, 0, 0);
        return prefix.substring(0, len);
    }

    private int search(Node x, String prefix, int d, int max) {
        if (x == null) return max;
        if (x.val != -1) max = d;
        if (prefix.length() == d) return d;
        return search(x.next[prefix.charAt(d)], prefix, d + 1, max);
    }

    class Node {
        int val;
        Node next[];

        public Node() {
            this.next = new Node[256];
            this.val = -1;
        }

        public Node(int val) {
            this.val = val;
            this.next = new Node[256];
        }
    }
}
