import java.util.*;  /*for reader class*/
import java.io.*;

public class My_adj_list {

    static int Edge;  // note : vertices = edge +1
    ArrayList<Edge>[]  adj;

    My_adj_list(int size){
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
    
     void print(){
        for (int i = 0; i < Edge; i++){
            System.out.println("\nAdjacency list of vertex" + i);
            

            for(Edge j : adj[i]){
                System.out.println(j.src + " " + j.nbr + " "+ j.wt);
            }
            System.out.println();
        }

     }

     static Integer smallestPathwt = Integer.MAX_VALUE;  // also min spammming tree 
     static String smallestPath;
     static Integer largestPathwt = Integer.MIN_VALUE;
     static String largestPath;
     static Integer justLarger = Integer.MIN_VALUE;
     static String justLargerpath;
     static String justsmallerpath;
     static Integer justsmaller = Integer.MAX_VALUE;


// psf = path so var travelled tilled default VALUE = " " , WEIGHT SO FAR DEFAULT VALUE = 0
    static void multsolv(ArrayList<Edge> [] adj , int src , int dest, boolean[] visited , String psf, int wsf ){

        if(src == dest){
            if(wsf < smallestPathwt){
                smallestPathwt = wsf;  // saveing smallest path wt
                smallestPath = psf;    // saving that path in string 
            }

            if(wsf > largestPathwt){
                largestPathwt = wsf;    // saveing largest path wt
                largestPath = psf;    // saveing that largestPath value in string
            }
            return;
        }
        visited[src] = true;
        for(Edge e : adj[src]) {
            if(visited[e.nbr] == false) {
                multsolv(adj, e.nbr, dest, visited, psf + e.nbr + " ",(wsf+e.wt));
        }
    }
    visited[src] = false;

    }
     

    static ArrayList<ArrayList<Integer>> comps = new ArrayList<>(); // here we are saveing all path till end of graph , if in bw found branch not connect ot othere we have it in new index 
    static void FindComponments(ArrayList<Edge> [] adj , int src , ArrayList<Integer> componment, boolean[] visited ){
        visited[src] = true;
        componment.add(src);
        for(Edge e : adj[src]){
            if(visited[e.nbr] == false){
                FindComponments(adj, e.nbr, componment, visited);
                
            }
        }
        
    }

    public static void main(String[] args) {
        
        My_adj_list q = new My_adj_list(5);
        q.addEdge(0,1,1);
        q.addEdge(1,2,1);
        q.addEdge(2,3,1);
        q.addEdge(3,4,1);
        q.addEdge(4,1,1);
        // q.addEdge(1,4,1);
        // q.addEdge(2,4,1);
        boolean [] visited = new boolean [5];
        multsolv(q.adj, 0, 4, visited, " ", 0);
        System.out.println(smallestPath + " " + smallestPathwt);
        System.out.println(largestPath + " " + largestPathwt);
        // find coponment code below 
        // for(int v = 0 ; v < Edge; v++) {
        //     if(visited[v] == false){
        //         ArrayList<Integer> componment = new ArrayList<>();
        //         FindComponments(q.adj, v, componment, visited);
        //         comps.add(componment);
        //     }
        // }
            
        // System.out.println(comps); // Q) if comps.size == 1 then isconnected true 
        // // another method using stack time complexity = O(V+E)
    }
}

