/**
 * Created by ASUS on 22.11.2016.
 */
public class Edge {
    public double distance;
    public double time;
    public double cost;
    public long sum;

    public Edge(double distance,double time,double cost)
    {
        this.distance = distance;
        this.time = time;
        this.cost = cost;
        sum = Math.round(50*distance/time);
    }

}
