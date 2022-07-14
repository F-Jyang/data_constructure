package Graph.Practice;

public class Vertex {
    private final int v;
    private final String city;

    public Vertex(int v, String city) {
        this.v = v;
        this.city = city;
    }


    public int v() {
        return this.v;
    }

    public String city() {
        return this.city;
    }
}
