package Graph;

// 为Graph3设计的search类
public class SearchForGraph3 {
    Graph3 G;
    int s;

    // 找到和 s 连通的所有顶点
    public SearchForGraph3(Graph3 G, int s) {
        this.G = G;
        this.s = s;
    }

    // v 与 s 是否连通
    public boolean marked(int v) {
        for (int w : G.adj(v)) {
            if (w == s) return true;
        }
        return false;
    }

    // 与 s 相连的顶点总数
    public int count() {
        int count = 0;
        for (int w : G.adj(s)) count++;
        return count;
    }
}
