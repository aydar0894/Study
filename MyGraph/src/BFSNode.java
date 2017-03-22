

/**
 * Created by ASUS on 21.11.2016.
 */
public class BFSNode<Vertex,Edge> {
    public Vertex vertex;
    public Double totalWeight;
    public TotalWeight total;
    public int color;
    public BFSNode<Vertex,Edge> parent;
    public BFSNode(Vertex vertex, Double weight)
    {
        total = new TotalWeight(0,0,0);
        parent = null;
        color = 0;
        this.vertex = vertex;
        this.totalWeight = weight;
    }

    public BFSNode(Vertex vertex, Double weight, int color)
    {
        total = new TotalWeight(0,0,0);
        parent = null;
        this.color = color;
        this.vertex = vertex;
        this.totalWeight = weight;
    }


}
