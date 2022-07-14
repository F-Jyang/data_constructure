package Tree;

import java.util.PriorityQueue;

public class Huffman {
    public static void main(String[] args) {
        Huffman huffman = new Huffman();
        huffman.compress("aaabcsffffffffsfs");
        huffman.expand("01f01s001b1c1a131111111111100110110000010010");
    }

    private static int R = 256;

    // read and write function
    private static boolean readBoolean() {
        return false;
    }

    private boolean readBoolean(char[] codes) {
        char flag = codes[0];
        reSize(codes);
        return flag == '1';
    }


    private static char readChar() {
        return '0';
    }

    private static int readInt() {
        return 1;
    }

    private int readInt(char[] codes) {
        String length=""+codes[0]+codes[1];
        reSize(codes);
        reSize(codes);
        return Integer.parseInt(length);
    }

    private static void writeInt(int i) {
        System.out.println();
        System.out.println("input.length" + ":" + i);//test
    }

    private static void writeChar(char ch) {
        System.out.print(ch);
    }

    private static void writeBit(int i) {
        System.out.print(i);
    }

    /**
     * read a file and transform it to the String
     *
     * @return
     */
    public String readFile() {
        return "";
    }

    /*
     * expand the file
     * */

    /**
     * read the words tree
     *
     * @return
     */
    public Node readTrie() {
        boolean isLeaf = readBoolean();
        if (isLeaf) {
            return new Node(null, null, -1, readChar());
        } else {
            return new Node(readTrie(), readTrie(), -1, '\0');
        }
    }

    private Node readTrie(char[] codes) {
        int idx = 0;
        boolean isLeaf = codes[idx] == '1';
        reSize(codes);
        if (isLeaf) {
            char ch = codes[0];
            reSize(codes);
            return new Node(null, null, -1, ch);
        } else {
            return new Node(readTrie(codes), readTrie(codes), -1, '\0');
        }
    }

    //resize codes size, transform codes from 0-codes.lengt to start-codes.length
    private void reSize(char[] codes) {
        for (int i = 0; i < codes.length - 1; i++)
            codes[i] = codes[i + 1];
    }

    /**
     * the expand function
     */
    public void expand() {
        Node root = readTrie();
        int N = readInt();
        for (int i = 0; i < N; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                if (readBoolean()) x = x.right;
                else x = x.left;
            }
            writeChar(x.ch);
        }
    }

    public void expand(String st) {
        System.out.println('\n'+"expand:");
        System.out.println(st);
        char[] codes = st.toCharArray();
        System.out.println(String.valueOf(codes));
        Node root = readTrie(codes);
        int N = readInt(codes);
        System.out.println("N:" + N);
        for (int i = 0; i < N; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                if (readBoolean(codes)) x = x.right;
                else x = x.left;
            }
            writeChar(x.ch);
        }
    }

    /*
     * compress the file
     * */
    public void compress() {
        //read the input
        String s = readFile();
        char[] input = s.toCharArray();

        //build trie
        int[] freqs = new int[R];
        for (char c : input) {
            freqs[c]++;
        }
        Node root = buildTrie(freqs);

        //build code which a char has one
        String[] codes = buildCode(root);
        //test
        for (char i = 0; i < codes.length; i++) {
            if (codes[i] != null)
                System.out.print(i + ":" + codes[i] + " ");
        }

        //write the trie
        writeTrie(root);

        //write the length of the input
        writeInt(input.length);

        //compress the input and write them to the write
        for (char c : input) {
            String code = codes[c];
            System.out.print(code + " ");//test
            for (int j = 0; j < code.length(); j++) {
                writeBit(code.charAt(j));
            }
        }
    }
    public void compress(String st) {
        System.out.println("compress:");
        //read the input
//        String s = readFile();
        StringBuilder stringBuilder= new StringBuilder();
        System.out.println(st);
        String s = st;
        char[] input = s.toCharArray();

        //build trie
        int[] freqs = new int[R];
        for (char c : input) {
            freqs[c]++;
        }
        Node root = buildTrie(freqs);

        //build code which a char has one
        String[] codes = buildCode(root);
        //test
        for (char i = 0; i < codes.length; i++) {
            if (codes[i] != null)
                System.out.print(i + ":" + codes[i] + " ");
        }

        //write the trie
        writeTrie(root);

        //write the length of the input
        writeInt(input.length);

        //compress the input and write them to the write
        for (char c : input) {
            String code = codes[c];
            System.out.print(code + " ");//test
//            for (int j = 0; j < code.length(); j++) {
//                writeBit(code.charAt(j));
//            }
        }
    }

    /**
     * build words trie
     *
     * @param freqs
     * @return
     */
    private static Node buildTrie(int[] freqs) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (char c = 0; c < freqs.length; c++) {
            if (freqs[c] > 0) {
                queue.add(new Node(null, null, freqs[c], c));
            }
        }
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node(left, right, left.freq + right.freq, '\0');
            queue.add(parent);
        }
        return queue.poll();
    }

    /**
     * buiid the code table
     *
     * @param root
     * @return
     */
    public static String[] buildCode(Node root) {
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }

    public static void buildCode(String[] st, Node root, String code) {
        if (root.isLeaf()) {
            st[root.ch] = code;
        } else {
            buildCode(st, root.left, code + '0');
            buildCode(st, root.right, code + '1');
        }
    }

    public void writeTrie(Node root) {
        if (root.isLeaf()) {
            writeBit(1);
            writeChar(root.ch);
            return;
        }
        writeBit(0);
        writeTrie(root.left);
        writeTrie(root.right);
    }

    public static class Node implements Comparable<Node> {
        private Node left, right;
        private int freq;
        private char ch;

        public Node(Node left, Node right, int freq, char ch) {
            this.left = left;
            this.right = right;
            this.freq = freq;
            this.ch = ch;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        @Override
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }
}
