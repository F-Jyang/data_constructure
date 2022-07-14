package HashTable;
/*
分离链接法
所有散列到同一个值的元素保留到一同个表中
    equals()用来对比节点的内容，即键值对是否已经存在
    hash用来确定数组的索引

虽然与线性探测法不一样，但是整体的思路是相同的：
    通过哈希函数（hash()）得到索引，接着遍历该索引开始用equals()方法比较key（注意两种遍历的方式不同！！！）
    直到得到一个key==null或者索引对应数组的key=key
 */

public class SeparateChainingHashTable<Key, Value> {

    private int M;//键值对总数
    private int N;//散列表大小
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashTable() {
        this(97);
    }

    public SeparateChainingHashTable(int M) {//创建M条链表
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void remove(Key key){
        st[hash(key)].remove(key);
        N--;
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
        N++;
    }

    public int hash(Key key) {
        return (key.hashCode()&0x7fffffff) % M;
    }




  /*  public static void main( String [ ] args )
    {
        long cumulative = 0;

        final int NUMS = 2000000;
        final int GAP  =   37;
        final int ATTEMPTS = 10;

        System.out.println( "Checking... (no more output means success)" );

        for( int att  = 0; att < ATTEMPTS; att++ )
        {
            System.out.println( "ATTEMPT: " + att );

            SeparateChainingHashTable<String> H = new SeparateChainingHashTable( new SeparateChainingHashTable<>( 3 ) );
            //QuadraticProbingHashTable<String> H = new QuadraticProbingHashTable<>( );

            long startTime = System.currentTimeMillis( );

            for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
                H.insert( ""+i );
            for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
                if( H.insert( ""+i ) )
                    System.out.println( "OOPS!!! " + i );
            for( int i = 1; i < NUMS; i+= 2 )
                H.remove( ""+i );

            for( int i = 2; i < NUMS; i+=2 )
                if( !H.contains( ""+i ) )
                    System.out.println( "Find fails " + i );

            for( int i = 1; i < NUMS; i+=2 )
            {
                if( H.contains( ""+i ) )
                    System.out.println( "OOPS!!! " +  i  );
            }


            long endTime = System.currentTimeMillis( );

            cumulative += endTime - startTime;

            if( H.capacity( ) > NUMS * 4 )
                System.out.println( "LARGE CAPACITY " + H.capacity( ) );
        }

        System.out.println( "Total elapsed time is: " + cumulative );
    }*/
}
