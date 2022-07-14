package Graph;

public class Test {
    public static void main(String[] args) {
        Graph3 graph3 = new Graph3(6);
        graph3.addEdge(0,1);
        graph3.addEdge(4,5);
        graph3.addEdge(3,5);
        graph3.addEdge(1,2);
        graph3.addEdge(2,5);
        graph3.addEdge(2,4);
        graph3.addEdge(1,3);
        SearchForGraph3 searchForGraph3 = new SearchForGraph3(graph3,2);
        BFSForGraph3 bfsForGraph3 =new BFSForGraph3(graph3,0);
        CCForGraph3 cc = new CCForGraph3(graph3);
        boolean connected = cc.isConnected(0, 3);
        System.out.println(connected);
        CycleForGraph3 cycle = new CycleForGraph3(graph3);
        System.out.println(cycle.HasCycle());
        TwoColorForGraph3 twoColorForGraph3 = new TwoColorForGraph3(graph3);
        System.out.println(twoColorForGraph3.isTwoColor());
       /* for (int i:bfsForGraph3.pathTo(5)){
            System.out.print(i+" ");
        }
        System.out.println();
        DFSForGraph3 dfsForGraph3 =new DFSForGraph3(graph3,0);
        for(int i:dfsForGraph3.pathTo( 5)){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println(searchForGraph3.count());
        System.out.println(searchForGraph3.marked(1));
        System.out.println(Graph3.toString(graph3));*/
    }
}
