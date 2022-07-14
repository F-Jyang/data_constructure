package Tree.practice;

public class HFMNode<T> implements Comparable<HFMNode<T>>{
    private T data;
    private int weight;
    private HFMNode<T> left;
    private HFMNode<T> right;
    public HFMNode(T data, int weight)
    {
        this.data=data;
        this.weight=weight;
    }
    /**
     * 获取节点数据
     */
    public String toString()
    {
        return "data:"+data+"   "+"weight:"+weight;
    }
    /**
     * 节点权值比较方法
     * @param o
     * @return
     */
    public int compareTo(HFMNode<T> o) {
        if(this.weight>o.weight)
            return 1;
        else if(this.weight<o.weight)
            return -1;
        return 0;
    }
    public void setData(T data)
    {
        this.data=data;
    }
    public void setWeight(int weight)
    {
        this.weight=weight;
    }
    public T getData()
    {
        return data;
    }
    public int getWeight()
    {
        return weight;
    }
    public void setLeft(HFMNode<T> node)
    {
        this.left=node;
    }
    public void setRight(HFMNode<T> node)
    {
        this.right=node;
    }
    public HFMNode<T> getLeft()
    {
        return this.left;
    }
    public HFMNode<T> getRight()
    {
        return this.right;
    }
}
