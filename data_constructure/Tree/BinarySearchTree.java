package Tree;

/*
二叉搜索树（不是平衡树）
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    Node root;

    private class Node {
        private Key key;
        private Value value;
        private int N;
        private Node left, right;

        public Node() {
        }

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

        /*/**
         * #Description 得到树的结点数量
         * @param []
         * @return
         * @author jiongyang
         * #Date 2022/4/28
         */
        public int size() {
            return size(root);
        }

        private int size(Node node) {
            if (node == null) return 0;
            return node.N;
        }

        /*/**
         * #Description 得到结点对应的值
         * @param [key]
         * @return
         * @author jiongyang
         * #Date 2022/4/28
         */
        public Value get(Key key) {
            Node node = get(root, key);
            if (node == null) return null;
            else return node.value;
        }

        private Node get(Node node, Key key) {
            if (node == null) return null;
            int cmp = node.key.compareTo(key);
            if (cmp < 0) return get(node.left, key);
            else if (cmp > 0) return get(node.right, key);
            else return node;
        }

        /*/**
         * #Description 添加结点
         * @param [key, value]
         * @return
         * @author jiongyang
         * #Date 2022/4/28
         */
        public void put(Key key, Value value) {
            root = put(root, key, value);
        }

        private Node put(Node node, Key key, Value value) {
            if (node == null) return new Node(key, value, 0);
            int cmp = node.key.compareTo(key);
            if (cmp < 0) node.left = put(node.left, key, value);
            else if (cmp > 0) node.right = put(node.right, key, value);
            else {
                node.value = value;
            }
            node.N = size(node.left) + size(node.right) + 1;
            return node;
        }

        /*/**
         * #Description 得到最小键
         * @param []
         * @return
         * @author jiongyang
         * #Date 2022/4/28
         */
        public Key min() {
            return min(root);
        }

        private Key min(Node node) {
            if (node.left != null) return min(node.left);
            else return node.key;
        }

        /*/**
         * #Description floor
         * @param [key]
         * @return 小于等于 key 的最大键
         * @author jiongyang
         * #Date 2022/4/28
         */
        public Key floor(Key key) {
            Node node = floor(root, key);
            if (node == null) return null;
            return node.key;
        }

        private Node floor(Node node, Key key) {
            if (node == null) return null;
            int cmp = node.key.compareTo(key);
            if (cmp == 0) return node;
            else if (cmp < 0) return floor(node.left, key);
            Node right = floor(node.right, key);
            if (right == null) return node;
            else return right;
        }
    }
}
