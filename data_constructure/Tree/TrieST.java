package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #Description 单词查找树
 *
 * @param
 * @author jiongyang
 * #Date 2022/3/25
 * @return
 */
public class TrieST {
    public static void main(String[] args) {
        TrieST trieST = new TrieST();
        trieST.put("hello", "world");
        trieST.put("world", "hello");
        Iterable<String> q = trieST.keys();
        Iterable<String> p = trieST.keysWithPrefix("wo");
      /*  for (String s : q) {
            System.out.println(s);
        }
        for (String s : p
        ) {
            System.out.println(s);
        }*/
        String longestPrefix = trieST.longestPrefixOf("helloh");
        System.out.println(longestPrefix);
        System.out.println(trieST.get("world"));
    }

    private int size = 0;

    private Node root;
    private static final int R = 256;

    public static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isContain(String key) {
        return get(key) == null;
    }

    public Object get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Object val) {
//        System.out.println(root);
        root = put(root, key, val, 0);
//        System.out.println(root);
        size++;
    }

    /*
    注意这里的put一定要有返回一个node节点，如果不返回，我们将root传入另一个put方法中，
    在方法里面，x = new Node(); 会将 x 指向另外一块内存地址，而 root 依然指向 null
    */
    private Node put(Node x, String key, Object val, int d) {
        if (x == null) x = new Node();
//        System.out.println(x);
//        System.out.println(root);
        if (d == key.length()) {//找到结点
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    //获取树中所有的键
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    //获取以pre为前缀的集合
    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new LinkedList<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    //将以 pre 前缀的所有字符串添加进 q 中
    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.val != null) q.add(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    //通配符匹配
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> results = new LinkedList<>();
        collect(root, new StringBuilder(), pattern, results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
        if (x == null) return;
        int d = prefix.length();
        if (d == pattern.length() && x.val != null)
            results.add(prefix.toString());
        if (d == pattern.length())
            return;
        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(x.next[ch], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        } else {
            prefix.append(c);
            collect(x.next[c], prefix, pattern, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
   /* public Iterable<String> keysThaiMatch(String pat) {
        Queue<String> q = new LinkedList<>();
        collect(root, ".", pat, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) q.add(pre);
        if (d == pat.length()) return;

        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {//当 pat 中的字符为 . 时都可以匹配，为 c 的时候可以匹配next[c]
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }*/


    //输入一段字符串，获取字符串在树中的最长前缀（如 "helloe" 得到 "hello"）
    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) return length;//为null，空链接，结束
        if (x.val != null) length = d;//节点有值，更新长度
        if (d == s.length()) return length;//可以匹配到整个 s ，返回 s 的长度
        char c = s.charAt(d);//继续向下匹配
        return search(x.next[c], s, d + 1, length);
    }

    //删除操作
    public void delete(String key) {
        delete(root, key, 0);
        size--;
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;// x 的值为 null
        if (d == key.length()) {//搜索到 key 对应的节点
            x.val = null;
        } else {//未搜索到 key 的节点，继续向下搜索
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if (x.val != null) return x;//删除最后一个节点后，返回判断当前的节点是否为 null ，不为null则不删除，为 null 则执行下面的语句继续删除
        //如果 x 的所有子节点都为 null ，则删除节点 x ，否则仅将 x 的 val 设置为 null
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) return x;
        }
        return null;
    }

}
