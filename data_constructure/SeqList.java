public class SeqList<T extends Comparable<T>> {
    public static void main(String[] args) {
        SeqList<Integer> seqList = new SeqList<>();
        seqList.add(10);
        seqList.add(19);
        seqList.add(13);
        seqList.add(12);
        seqList.add(101);
        seqList.add(13);
        seqList.add(11);
        seqList.replaceFirst(13, 20);
        seqList.removeAll(13);
        seqList.searchLast(101);
    }

    private T[] arr;
    private static final int DEFAULT_SIZE = 5;
    private int len;
    private int count;

    public SeqList() {
        arr = (T[]) new Comparable[DEFAULT_SIZE];
        len = DEFAULT_SIZE;
        count = 0;
    }

    public void add(T val) {
        if (count >= len) {
            autoAdd();
        }
        arr[count++] = val;
    }

    /**
     * 删除所有为key的元素
     *
     * @param key
     */
    public void removeAll(T key) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == key) {
                if (len - 1 - i >= 0) {
                    System.arraycopy(arr, i + 1, arr, i, len - 1 - i);
                    count--;
                }
            }
        }
    }

    /**
     * 将第一个出现的key替换为x
     *
     * @param key
     * @param x
     */
    public void replaceFirst(T key, T x) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == key) {
                arr[i] = x;
                return;
            }
        }
    }

    /**
     * 查询最后一个为key的元素的索引
     *
     * @param key
     */
    public int searchLast(T key) {
        int idx = -1;
        for (int i = 0; i < len; i++) {
            if (arr[i].compareTo(key) == 0) {
                idx = i;
            }
        }
        return idx;
    }

    /**
     * 当数组的长度不足时自动增长数组
     */
    private void autoAdd() {
        this.len = arr.length * 2 + 1;
        T[] newArr = (T[]) new Comparable[len];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }
}
