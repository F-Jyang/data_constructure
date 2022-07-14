package Graph;

import java.util.Stack;

// 找出所有顶点为 s 的路径
public class DFSForGraph3 {
    private final int start; // 起点
    private boolean[] marked; // 标记起点是否已经经过（需要为bfs和df分别创建一个）
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点

    public DFSForGraph3(Graph3 graph3, int s) {
        this.edgeTo = new int[graph3.V()];
        this.marked = new boolean[graph3.V()];
        this.start = s;
        dfs(graph3, start);
    }

    // 深度优先搜索
    private void dfs(Graph3 graph3, int start) {
        marked[start] = true;
        for (int v : graph3.adj(start)) {
            if (!marked[v]) {
                edgeTo[v] = start;
                dfs(graph3, v);
            }
        }
    }
    // 广度优先搜索
    private void bfs(Graph3 graph3,int end){

    }

    // 是否存在 s 到 end 的路径
    public boolean hasPath(int end) {
        return marked[end];
    }

//    // s 到 end 的路径，不存在返回 null
//    public Iterable<Integer> dfs(Graph3 graph3, int start, int end, List<Integer> list) {
//        if (marked[start]) return null;
//        if (start == end) return list;
//        for (int v : graph3.adj(start)) {
//            if (marked[end]) break;
//            if (!marked[v]) {
//                list.add(v);
//                list = (List<Integer>) dfs(graph3, v, end, list);
//            }
//        }
//        return list;
//    }

    // 这里的解法不错
    public Iterable<Integer> pathTo(int end) {
        if (!hasPath(end)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int i = end; i != start; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(start);
        return stack;
    }
}
