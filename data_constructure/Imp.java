public interface Imp {
    public int size();

    public boolean isEmpty();

    public boolean isContain(String key);
    //得到字符串所映射的值
    public Object get(String word);

    //存入字符串和对应的值
    public void put(String word, Object val);

    //删除操作
    public void delete(String key);

    //获取树中所有的键
    public Iterable<String> keys();

    //获取以pre为前缀的集合
    public Iterable<String> keysWithPrefix(String pre);

    //通配符匹配
    public Iterable<String> keysThaiMatch(String pat);

    //输入一段字符串，获取字符串在树中的最长前缀（如 "helloe" 得到 "hello"）
    public String longestPrefixOf(String s);
}
