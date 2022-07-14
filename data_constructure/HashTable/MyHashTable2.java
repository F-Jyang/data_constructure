package HashTable;

public class MyHashTable2<Key, Value> {
    private Key[] keys;//键
    private Value[] values;//值
    private int size;//键值对数量
    private static final int DEFAULT_SIZE = 13;//默认长度

    //构造方法
    public MyHashTable2() {//这里不把默认长度设为static无法添加，因为加载顺序的问题，在类被创造出来前，非static还没被创造出来
        this(DEFAULT_SIZE);
    }

    public MyHashTable2(int size) {
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];
        size = 0;
    }

    //添加键值对
    public void put(Key key, Value value) {
        if (size  == keys.length) reSize(2 * size + 1);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i].equals(key)) {
                values[i] = value;
                break;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
           /* //如果hash(key)到当前数组的最后一个索引都包含了值，即使hash(key)前面还有空间
            //我们也需要重新增长数组的长度，否则无法将新的值添加进数组
            if(i+1== keys.length){
                reSize(2*i+1);
            }*/
    }


    //通过键得到值
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    //是否包含键值对
    public boolean contains(Key key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                return values[i] != null;
            }
        }
        return false;
    }

    //删除键值对（只删除值，但是保留键。这个叫懒惰删除？？？）
    public void remove(Key key) {
        if (size == 0 || !contains(key)) {
            return;
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % keys.length) {
            if (keys[i] == key) {
                values[i] = null;
                size--;
                return;
            }
        }
    }

    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //调整map长度
    private void reSize(int newSize) {
        Key[] oldKey = keys;
        keys = (Key[]) new Object[newSize];
        Value[] oldValue = values;
        values = (Value[]) new Object[newSize];
        size=0;
        for (int i = 0; i < oldKey.length; i++) {
            put(oldKey[i],oldValue[i]);
        }
    }

    //哈希函数
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % keys.length;
    }

    //Test Program
    public static void main(String[] args) {
        MyHashTable2<String, Integer> maps = new MyHashTable2<>();
        maps.put("Jyang", 20);
        maps.put("Syan", 21);
        maps.put("Ghua", 40);
        maps.put("yang", 20);
        maps.put("yan", 21);
        maps.put("hua", 40);
        maps.put("ang", 20);
        maps.put("an", 21);
        maps.put("ua", 40);
        maps.put("J2yang", 20);
        maps.put("S2yan", 21);
        maps.put("G2hua", 40);
        maps.put("J1yang", 20);
        maps.put("S3yan", 21);
        maps.put("G3hua", 40);
        //当实例超过了整个哈希表长度的1/2，则增长表长度，此时hash函数得到的值会改变
        //相当于get一个元素的时候索引与put该元素时不一样了，怎么办？？？
        System.out.println(maps.get("Jyang"));
        System.out.println(maps.get("Syan"));
        System.out.println(maps.get("Ghua"));
        System.out.println(maps.get("hello"));
        System.out.println(maps.isEmpty());
        System.out.println(maps.contains("Jyang"));
        maps.remove("Jyang");
        System.out.println(maps.contains("Jyang"));
        System.out.println(maps.get("G3hua"));
    }
}