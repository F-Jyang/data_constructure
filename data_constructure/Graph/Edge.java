package Graph;

// 自定义边类
public class Edge implements Comparable<Edge> {
    private final int head;
    private final int tail;
    private final int weight;// 权重

    public Edge(int head, int tail, int weight) {
        this.head = head;
        this.tail = tail;
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return ("edge:[" + head + "," + tail + "," + weight + "]");
    }

    // 通过一个点得到下一个点
    public Integer getOtherVertex(Integer vertex) throws Exception {
        if (vertex == head) {
            return tail;
        } else if (vertex == tail) {
            return head;
        } else {
            throw new NoThisEdgeException("不存在这条边");
        }
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    @Override
    public int compareTo(Edge edge) {
        // TODO 自动生成的方法存根
        return weight-edge.weight;
    }
}
