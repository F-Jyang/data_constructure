package Graph.Practice;

public class Edge implements Comparable<Edge> {
    private int to;
    private int from;
    private int weight;
    private String arriveTime;//到达该城市的时间
    private String leaveTime;//离开该城市的时间

    public Edge(int from, int to, int weight, String arriveTime, String leaveTime) {
        this.to = to;
        this.from = from;
        this.weight = weight;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
    }

    public int from() {
        return this.from;
    }

    public int to() {
        return this.to;
    }

    public int weight() {
        return this.weight;
    }

    public String arriveTime() {
        return this.arriveTime;
    }

    public String leaveTime() {
        return this.leaveTime;
    }

    public void change(int from, int to, int weight, String arriveTime, String leaveTime) {
        this.to = to;
        this.from = from;
        this.weight = weight;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }

    @Override
    public String toString() {
        return this.from + "->" + this.to + "," + "arriveTime:" + arriveTime + " leaveTime:" + leaveTime + " price:" + this.weight;
    }
}
