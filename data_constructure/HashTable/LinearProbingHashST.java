package HashTable;

/*
线性探测法：使用两个数组分别存储key和value值，即有序的字符表

虽然与分离链路法不一样，但是整体的思路是相同的：
    通过哈希函数（hash()）得到索引，接着遍历该索引开始用equals()方法比较key（注意两种遍历的方式不同！！！）
    直到得到一个key==null或者索引对应数组的key=key
 */
public class LinearProbingHashST<Key, Value> {
    private int M = 16;//线性探测表大小
    private int N;//键值对数
    private Key[] keys;//键
    private Value[] values;//值

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int size) {
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];
        M = size;
    }

    private int hash(Key key) {
        return (key.hashCode()&0x7fffffff) % M;
    }

    private void resize(int size) {//将M加倍
        LinearProbingHashST<Key, Value> map;
        map = new LinearProbingHashST<>(2 * M);
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                map.keys[i] = keys[i];
                map.values[i] = values[i];
            }
        }
        M = map.M;
        this.keys = map.keys;
        this.values = map.values;
    }

    /*
    当得到一个key的索引，但是该索引已经被占用时，索引+1，直到遇到一个空的索引
    将该keys数组该索引对应的值存为key，values数组索引对应的值存为value
     */
    public void put(Key key, Value value) {
        if (N > M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {//这里的i如果加一后不%M可能会索引越界
            if (keys[i].equals( key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    /*
    根据上面put()方法：我们可以知道当key的哈希码重复时，新的key对应的索引会+1，直到得到相同的key或者索引对应的key为空
    所以get()方法可以根据上面存入键值对的原理，当key的哈希码对应索引已经被占用时，令索引+1，用equals()方法对比该索引对应的key
    直到得到的key与传入的key相同或者索引对应的值为null（表示哈希表没有存入该key和value）
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {//hash()方法得到数组索引
            if (key.equals(keys[i])) {//equals()方法判断是否有相同的key
                return values[i];
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void remove(Key key) {//这里的删除依然是将key对应的值赋值为null
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i] == key) {
                values[i] = null;
                N--;
            }
        }
    }

    public boolean isContains(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            //由于前面已经把这个点给删除了，但是key依然存在，所以要保证value不能等于0
            if (keys[i] == key && values[i] != null) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> maps = new LinearProbingHashST<>();
        maps.put("Jyang", 20);
        maps.put("Syan", 21);
        maps.put("Ghua", 40);
        maps.put("yang", 20);
     /*   maps.put("yan", 21);
        maps.put("hua", 40);
        maps.put("ang", 20);
        maps.put("an", 21);
        maps.put("ua", 40);
        maps.put("J2yang", 20);
        maps.put("S2yan", 21);
        maps.put("G2hua", 40);
        maps.put("J1yang", 20);
        maps.put("S3yan", 21);
        maps.put("G3hua", 40);*/
        //当实例超过了整个哈希表长度的1/2，则增长表长度，此时hash函数得到的值会改变
        //相当于get一个元素的时候索引与put该元素时不一样了，怎么办？？？
        int age=maps.get("Jyang");
        System.out.println(maps.get("Jyang"));
        System.out.println(maps.get("Syan"));
        System.out.println(maps.get("Ghua"));
        System.out.println(maps.get("hello"));
        System.out.println(maps.isEmpty());
        System.out.println(maps.isContains("Jyang"));
        maps.remove("Jyang");
        System.out.println(maps.isContains("Jyang"));
        System.out.println(maps.get("G3hua"));
    }
}
