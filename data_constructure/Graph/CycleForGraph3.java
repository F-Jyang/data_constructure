package Graph;

public class CycleForGraph3 {
    private boolean[] marked;
    private boolean hasCycle;

    public CycleForGraph3(Graph3 graph3) {
        hasCycle = false;
        this.marked = new boolean[graph3.V()];
        for (int v = 0; v < graph3.V(); v++) {
            if (marked[v]) continue;
            dfs(graph3, v, v);
        }
    }

    private void dfs(Graph3 graph3, int v, int s) {
        marked[v] = true;
//        for (int w : graph3.adj(v)) {
//            if (w == s) {
//                hasCycle = true;
//                return;
//            } else {
//                if (!marked[w])
//                    dfs(graph3, w, s);
//            }
//        }
        for (int w:graph3.adj(v)) {
            if (!marked[w])
                dfs(graph3,w,v);
            //被标记过，代表已经被访问过，而第二次访问时只需要判断这条边的两个端点是否相等
            //相同说明是自环，不同则说明该图成环
            else if (w!=s)hasCycle=true;
        }
    }

    public boolean HasCycle() {
        return hasCycle;
    }

}
