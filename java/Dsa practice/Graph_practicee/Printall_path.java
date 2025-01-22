import java.util.*;  /*for reader class*/
import java.io.*;

public class Printall_path {
    static void printAllPath(ArrayList<ArrayList<Integer> > adj ,int src , int dest , boolean[] visited , String psf){
    
    if(src ==  dest) {
        System.out.println(psf);
        return;
    }
    visited[src] = true;
    for(int nbr : adj.get(src)) {
        if(visited[nbr] == false) {
            printAllPath(adj, nbr, dest, visited, psf + nbr + " ");
        }
    }
    visited[src] = false; // remove this to find source to des is possible or not if bollen[des == true then possible ]
                            // simply run dsf to check this 
    }
    public static void main(String[] args)throws IOException  {
        Reader.init(System.in);
        int size = Reader.nextInt();

        Adj_list q = new Adj_list(size);
        q.addEdge(q.adj, 0, 1);
        q.addEdge(q.adj,1,2);
        q.addEdge(q.adj,2,3);
        q.addEdge(q.adj,3,0);
        q.addEdge(q.adj,4,2);
        q.addEdge(q.adj,1,4);
        q.addEdge(q.adj,2,4);
        boolean [] visited = new boolean [size];
        printAllPath(q.adj, 0, 4, visited, 0+" " );   // note : enter string like = src +" "
    }
}

class Adj_list {
    ArrayList<ArrayList<Integer> > adj;

    Adj_list(int size) {

        adj = new ArrayList<ArrayList<Integer>>(size);
        for (int i = 0; i < size; i++)
            adj.add(new ArrayList<Integer>());
    }


    
    
    void addEdge(ArrayList<ArrayList<Integer> > adj,int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
  
    // A utility function to print the adjacency list
    // representation of graph
    void print(){
        printGraph(adj);
    }
    void printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}    

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static String nextLine() throws IOException {
    return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}