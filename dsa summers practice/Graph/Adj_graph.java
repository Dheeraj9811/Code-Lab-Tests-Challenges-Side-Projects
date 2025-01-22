import java.util.ArrayList;

public class Adj_graph{
    public static void main(String[] args) {
        Adj_graph g = new Adj_graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 10);
        g.print();
    }
    ArrayList<ArrayList<Integer>> graph;
    int V;
    Adj_graph(int v){
        this.V = v;
        graph = new ArrayList<ArrayList<Integer>>(V);
        for(int i = 0; i< V; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int u , int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    void print(){
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("adj list " + i+ "->");

            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j));
            }
            System.out.println();
        }
       
    }

}