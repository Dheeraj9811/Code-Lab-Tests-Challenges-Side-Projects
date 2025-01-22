import java.util.*;  /*for reader class*/
import java.io.*;

// psf = path so far travelled 
// wt = weight
public class My_adj_list {
    int Edge;
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
        //adj[v].add(new Edge(v , u, weight));
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

     class pair{
         int V;
         String psf;

         pair(int V , String psf){
             this.V = V;
             this.psf = psf;
         }
     }


     int isCyclic(ArrayList<Edge>[]  adj , int source, boolean[] visited ) {
        ArrayDeque<pair> Q = new ArrayDeque<>();
        Q.add(new pair(source, source + " "));

        while(Q.size() > 0 ){
            pair temp = Q.removeFirst();

            if(visited[temp.V]){  // checking if already vistied then its a cycle dude so return true == 1  now 
               return 1; 
            }   // else part now first its nbr 
            else{
                visited[temp.V] = true;
                for( Edge point: adj[temp.V]){
                    if(!visited[point.nbr]){
                        Q.add(new pair(point.nbr , temp.psf + point.nbr));
                    }
                }
            }   

        }
        return -1;
     }

     public static void main(String[] args)throws IOException {
        int V , E ;
        Reader.init(System.in);
        V = Reader.nextInt();
        E = Reader.nextInt();

        My_adj_list q = new My_adj_list(V);
        for(int i = 0 ; i < E ; i++){
            q.addEdge(Reader.nextInt()-1, Reader.nextInt()-1, 1);
        }
        

        boolean[] visited = new boolean[V];
        
        // is cyclic question using bsf  ---Note we can remove pair fn its just for deubgging and visualation
            /*logic used here rm* wa* ----> remove markstar work addstar 
                    remove from quee if already visted continuee boiii  else mark vist 
                     do work we want to do  and add unvisted nbr  */

        
        for(int i = 0; i < V; i++){  // vertices = edge + 1 , runing for every vertices 
            if(!visited[i]){
                int check = q.isCyclic(q.adj, i, visited);
                if(check == 1){
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
        
     }
}
// class Reader {
//     static BufferedReader reader;
//     static StringTokenizer tokenizer;

//     /** call this method to initialize reader for InputStream */
//     static void init(InputStream input) {
//         reader = new BufferedReader(
//                      new InputStreamReader(input) );
//         tokenizer = new StringTokenizer("");
//     }

//     /** get next word */
//     static String next() throws IOException {
//         while ( ! tokenizer.hasMoreTokens() ) {
//             //TODO add check for eof if necessary
//             tokenizer = new StringTokenizer(
//                    reader.readLine() );
//         }
//         return tokenizer.nextToken();
//     }
//     static String nextLine() throws IOException {
//     return reader.readLine();
//     }

//     static int nextInt() throws IOException {
//         return Integer.parseInt( next() );
//     }
	
//     static double nextDouble() throws IOException {
//         return Double.parseDouble( next() );
//     }
// }
