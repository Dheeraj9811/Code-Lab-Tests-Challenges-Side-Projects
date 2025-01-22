import java.util.*;  /*for reader class*/
import java.io.*;

public class isCyclic {
    static int Edge;  // note : vertices = edge +1
    static ArrayList<Edge>[]  adj;
    static int remove1 , remove2;
    isCyclic(int size){
        adj = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            adj[i] = new ArrayList<>();
         }
    }

    void addEdge(int u, int v, int weight)
    {
        adj[u].add(new Edge(u , v, weight));
        adj[v].add(new Edge(v , u, weight));
        Edge++;
    }

    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt) {
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
    }

    static void cuclic(ArrayList<Edge> [] adj ,int src , int dest , boolean[] visited){
        if(src ==  dest) {
            
            return;
        }
        visited[src] = true;
        for(Edge e : adj[src]) {
            if(visited[e.nbr] == false) {
                printAllPath(adj, e.nbr, dest, visited, );
            }
        }
        visited[src] = false; // remove this to find source to des is possible or not if bollen[des == true then possible ]
                                // simply run dsf to check this 
        }
    }
}
