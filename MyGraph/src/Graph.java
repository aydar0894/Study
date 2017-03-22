import java.util.*;

/**
 * Created by ASUS on 21.11.2016.
 */
public class Graph<Vertex> {


    ArrayList<Vertex> vertices;
    Object[][] adjMatrix;
    HashMap<Vertex, Integer> posInMatrix;
    int vertCount;


    public Graph(Vertex[] vertices) {
        this.vertices = new ArrayList<Vertex>();
        this.vertices.addAll(Arrays.asList(vertices));
        vertCount = vertices.length;
        this.adjMatrix = new Object[vertCount][vertCount];
        posInMatrix = new HashMap<Vertex, Integer>();
        for (int i = 0; i < vertCount; i++) {
            for (int j = 0; j < vertCount; j++) {
                adjMatrix[i][j] = new Edge(0, 0, 0);
            }
            posInMatrix.put(vertices[i], i);
        }

    }


    public void addEdge(Vertex from, Vertex to, double distance, double time, double cost) {
        this.adjMatrix[posInMatrix.get(from)][posInMatrix.get(to)] = new Edge(distance, time, cost);
    }

    public void addBothEdges(Vertex from, Vertex to, double distance, double time, double cost) {
        this.adjMatrix[posInMatrix.get(from)][posInMatrix.get(to)] = new Edge(distance, time, cost);
        this.adjMatrix[posInMatrix.get(to)][posInMatrix.get(from)] = new Edge(distance, time, cost);
    }

    public Object edgeInf(Vertex from, Vertex to) {
        return adjMatrix[posInMatrix.get(from)][posInMatrix.get(to)];
    }

    public void deleteEdge(Vertex from, Vertex to) {
        adjMatrix[posInMatrix.get(from)][posInMatrix.get(to)] = new Edge(0, 0, 0);
    }


    boolean found[];
    int N, capacity[][];
    int flow[][], parent[], distance[];

    boolean findPath(int source, int dest) {
        Arrays.fill(found, false);
        Arrays.fill(distance, 0);
        distance[source] = Integer.MAX_VALUE / 2;
        while (source != N) {
            int best = N;
            found[source] = true;
            if (source == dest) break;
            for (int i = 0; i < N; i++) {
                if (found[i]) continue;
                int temp = Math.min(capacity[source][i] - flow[source][i], distance[source]);
                if (distance[i] < temp) {
                    distance[i] = temp;
                    parent[i] = source;
                }
                if (distance[i] > distance[best]) best = i;
            }
            source = best;
        }
        return found[dest];
    }


    public int maxFlow(int source, int sink, int array[][]) {

        this.capacity = array;
        N = capacity.length;
        int maxFlow = 0;
        found = new boolean[N];
        flow = new int[N][N];
        distance = new int[N + 1];
        parent = new int[N];

        while (searchShortest(source, sink)) {
            int amt = Integer.MAX_VALUE;
            for (int x = sink; x != source; x = parent[x])
                amt = Math.min(amt, capacity[parent[x]][x] - flow[parent[x]][x]);
            for (int x = sink; x != source; x = parent[x]) {
                flow[parent[x]][x] += amt;
                flow[x][parent[x]] -= amt;
            }
            maxFlow += amt;
        }

        return maxFlow;
    }

    boolean searchShortest(int source, int sink) {
        Arrays.fill(found, false);
        Arrays.fill(distance, Integer.MAX_VALUE/2);
        distance[source] = 0;
        while (source != N - 1) {
            int best = N;
            found[source] = true;
            if (source == sink) break;
            for (int k = 0; k < N; k++) {
                if (found[k]) continue;
                if (capacity[source][k] - flow[source][k] > 0) {
                    if (distance[k] > distance[source] + 1){
                        distance[k] = distance[source] + 1;
                        distance[k] = source;
                    }
                }
                if (distance[k] < distance[best]) best = k;
            }
            source = best;
        }
        return found[sink];
    }




    public ArrayList<BFSNode<Vertex, Edge>> BFS(Vertex from, Vertex to) {
        double resultValue = 0.0;
        BFSNode<Vertex, Edge>[] nodes = new BFSNode[this.vertices.size()];
        ArrayList<BFSNode<Vertex, Edge>> result = new ArrayList<>();
        int iterCount = adjMatrix.length;
        Vertex newBFSNode;
        Object temp = new Object();
        BFSNode<Vertex, Edge> current = new BFSNode(from, 0.0, 1);
        BFSNode<Vertex, Edge> source = current;
        for (int i = 0; i < nodes.length; i++) {
            newBFSNode = this.vertices.get(i);
            nodes[i] = new BFSNode(newBFSNode, 0.0);
        }

        nodes[posInMatrix.get(from)].color = 1;
        ArrayDeque<BFSNode<Vertex, Edge>> queue = new ArrayDeque();
        BFSNode<Vertex, Edge> optimum = new BFSNode<Vertex, Edge>(current.vertex,0.0);
        queue.addFirst(current);
        for (int k = 0;k<vertices.size();k++) {
            while (!queue.isEmpty() && !current.vertex.equals(to)) {
                current = queue.getFirst();
                result.add(current);
                queue.removeFirst();

                for (int i = 0; i < vertices.size(); i++) {
                    if (((Edge) (temp = (adjMatrix[posInMatrix.get(current.vertex)][i]))).time != 0) {
                        if (nodes[i].color == 0) {
                            nodes[i].color = 1;
                            nodes[i].parent = current;
                            nodes[i].total = new TotalWeight(((Edge) temp).time + nodes[i].parent.total.time, ((Edge) temp).distance + nodes[i].parent.total.dist, ((Edge) temp).cost + nodes[i].parent.total.price);

                            queue.addFirst(nodes[i]);
                        }
                    }
                }
                current.color = 2;
            }
            if(result.size()!=0 && optimum.total.time<result.get(result.size() - 1).total.time) optimum = result.get(result.size() - 1);
            for(int b = 0;b<result.size()-3;b++) result.get(b).color = 0;
            result.clear();
        }
        return result;
    }
}