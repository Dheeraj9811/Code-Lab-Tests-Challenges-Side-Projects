import java.util.*;  /*for reader class*/
import java.io.*;

public class Adj_list {
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

    void dfs( int src , int dest , int size ){
        boolean[] visited = new boolean[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);

        while (!stack.isEmpty()) {
            int check = stack.pop();
            if(!visited[check]) {
                visited[check] = true;
                System.out.println(check+ " ");

                for(int nbr : adj.get(check)){  // nbr means neighbours 
                    if(!visited[nbr]){
                        stack.push(nbr);
                        if(nbr == dest){
                            System.out.println("found there ");  // here checking if path is found or not we can also break loop here if found 
                        }
                    }
                }
            }
        }
        
    }

    public void bfs(int src , int dest , int size ) {
		boolean[] visited = new boolean[size];

		Queue<Integer> q = new LinkedList<>();
		visited[src] = true;
		q.offer(src);

		while(!q.isEmpty()) {
			int check = q.poll();
			System.out.print(check + " ");

			for(int nbr : adj.get(check)) {
				if(!visited[nbr]) {
					visited[nbr] = true;
					q.offer(nbr);
                    if(nbr == dest){
                        System.out.println("found there ");
				    }
			    }
		    }
	    }
    }

    
    public static void main(String[] args) throws IOException  {
        Reader.init(System.in);
        int size = Reader.nextInt();

        Adj_list q = new Adj_list(size);
        q.addEdge(q.adj, 0, 1);
        q.addEdge(q.adj,1,2);
        q.addEdge(q.adj,2,3);
        q.addEdge(q.adj,3,0);
        // q.addEdge(q.adj,4,2);
        // q.addEdge(q.adj,1,4);
        // q.addEdge(q.adj,2,4);
        //q.dfs(1, 4, size);
        // q.bfs(1, 4, size);
        q.print();
        

        

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


