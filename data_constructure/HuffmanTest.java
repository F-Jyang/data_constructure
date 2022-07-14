import java.util.PriorityQueue;

public class HuffmanTest {
    public static void main(String[] args) {
        char a = 25197;
        System.out.println(a);
        HuffmanTest huffman = new HuffmanTest();
        String s = huffman.compress("aasdfshsafghdfsddddfdsfs");
        huffman.expand(s);
    }

    private static int R = 256;

    // read and write function
    private boolean readBoolean(char[] codes) {
        char flag = codes[0];
        reSize(codes);
        return flag == '1';
    }

    private int readInt(char[] codes) {
        String length = "" + (int) codes[0];
        reSize(codes);
//        reSize(codes);
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

    public void expand(String st) {
        System.out.println('\n' + "expand:");
        System.out.println(st);
        char[] codes = st.toCharArray();
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
    public String compress(String st) {
        System.out.println("compress:");
        //read the input
//        String s = readFile();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(st);
        char[] input = st.toCharArray();

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
        stringBuilder.append(writeTrie(root));

        //write the length of the input
        writeInt(input.length);
        stringBuilder.append((char) input.length);


        //compress the input and write them to the write
        for (char c : input) {
            String code = codes[c];
            stringBuilder.append(code);
            System.out.print(code + " ");//test
//            for (int j = 0; j < code.length(); j++) {
//                writeBit(code.charAt(j));
//            }
        }
        return stringBuilder.toString();
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

    public String writeTrie(Node root) {
        StringBuilder stringBuffer = new StringBuilder();
        if (root.isLeaf()) {
            stringBuffer.append(1).append(root.ch);
            writeBit(1);
            writeChar(root.ch);
            return stringBuffer.toString();
        }
        stringBuffer.append(0);
        writeBit(0);
        stringBuffer.append(writeTrie(root.left));
        stringBuffer.append(writeTrie(root.right));
        return stringBuffer.toString();
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
