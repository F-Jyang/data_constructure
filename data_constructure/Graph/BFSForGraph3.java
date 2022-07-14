package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSForGraph3 {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    public BFSForGraph3(Graph3 graph3,int s){
        this.s = s;
        this.edgeTo = new int[graph3.V()];
        this.marked = new boolean[graph3.V()];
        bfs(graph3,s);
    }

    private void bfs(Graph3 graph3,int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] =true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int w:graph3.adj(v)){
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int end){
        if(!hasPathTo(end))return null;
        Stack<Integer> stack = new Stack<>();
        for(int i = end;i!=s;i=edgeTo[i]){
            stack.add(i);
        }
        stack.add(s);
        return stack;
    }
}
