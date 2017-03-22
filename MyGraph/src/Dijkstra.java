import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;

/**
 * Created by ASUS on 22.11.2016.
 */
public class Dijkstra<Vertex> {
              public static int [] dijkstra (Graph G, int s) {
              final double [] dist = new double [G.vertices.size()];  // shortest known distance from "s"
               final int [] pred = new int [G.vertices.size()];  // preceeding node in path
               final boolean [] visited = new boolean [G.vertices.size()]; // all false initially

               for (int i=0; i<dist.length; i++) {
                      dist[i] = Integer.MAX_VALUE;
                   }
               dist[s] = 0;

               for (int i=0; i<dist.length; i++) {
                      final int next = minVertex (dist, visited);
                      visited[next] = true;

                      // The shortest path to next is dist[next] and via pred[next].
                   int[] nb = new int[G.vertices.size()];
                   int b = 0;
                   for(int k = 0;k<G.vertices.size();k++)
                   {
                       if(((Edge)G.adjMatrix[next][k]).time != 0.0) {
                         nb[b] = k;
                           b++;
                       }
                   }

                   final int [] n = nb;

                      for (int j=0; j<n.length; j++) {
                             final int v = n[j];
                             double d = dist[next] + ((Edge)G.edgeInf(next,v)).time;
                             if (dist[v] > d) {
                                    dist[v] = d;
                                    pred[v] = next;
                                 }
                          }
                   }
               return pred;  // (ignore pred[s]==0!)
            }

             private static int minVertex (double [] dist, boolean [] v) {
               double x = Integer.MAX_VALUE;
               int y = -1;   // graph not connected, or no unvisited vertices
               for (int i=0; i<dist.length; i++) {
                      if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
                   }
               return y;
            }

    public static void printPath (Graph G, int [] pred, int s, int e) {
               final java.util.ArrayList path = new java.util.ArrayList();
               int x = e;
               while (x!=s) {
                      path.add (0, G.vertices.get(x));
                      x = pred[x];
                   }
               path.add (0, G.vertices.get(s));
              System.out.println (path);
    }

          }
