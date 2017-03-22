import java.util.ArrayList;

/**
 * Created by InvarianT on 12.07.2016.
 */
public class Node<T extends Comparable, P2 extends Comparable, P extends Comparable> implements Comparable{

    T inf;
    P2 priority2;
    P priority;
    int compare = 0;

    public Node(T inf,P2 priority2, P priority, int compare)
    {
        this.priority2 = priority2;
        this.inf = inf;
        this.priority = priority;
        this.compare = compare;
    }
    public Node(int compare)
    {
        this.compare = compare;
    }

    @Override
    public int compareTo(Object o) {
        Node n = (Node)o;
        if(compare == 0) return this.priority.compareTo(n.priority);
        else if(compare == 1) return this.priority2.compareTo(n.priority2);

        else return 0;
    }
}
