package Graph;

public class TwoColorForGraph3 {
    private boolean[] marked;
    private int[] id;
    private boolean isTwoColor;

    public TwoColorForGraph3(Graph3 graph3) {
        isTwoColor = true;
        this.id = new int[graph3.V()];
        this.marked = new boolean[graph3.V()];
        for (int v = 0; v < graph3.V(); v++) {
            if (!marked[v])
                dfs(graph3, v, 1);
        }
    }

    private void dfs(Graph3 graph3, int v, int color) {
        marked[v] = true;
        id[v] = color;
        for (int w : graph3.adj(v)) {
            if (!marked[w]) {
                dfs(graph3, w, -color);
            } else if (id[v] == id[w]) isTwoColor = false;
        }
    }

    public boolean isTwoColor() {
        return isTwoColor;
    }
}
