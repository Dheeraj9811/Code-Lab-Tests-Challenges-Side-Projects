import java.util.Stack;

public class Adjacency_matrix {
    int[][] adjMatrix;
    int V , Edge ;  // no_of ewdge in graph


    public  Adjacency_matrix(int nodes){ // contructor to  take size
        V = nodes;
        this.adjMatrix = new int[nodes][nodes];

    }
    void addEdge(int i ,int j){
        this.adjMatrix[i][j] = 1;
        this.adjMatrix[j][i] = 1;
        Edge++;

    }

    void dfs(int src , int dest ){
        boolean[] visited = new boolean[Edge];
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()) {
            int check = stack.pop();
            if(!visited[check]) {
                visited[check] = true;
                System.out.println(check+ " ");

                for(int i = 0; i <V ; i++){
                    if(adjMatrix[check][i] == 1 &&  visited[i] == false ){
                        stack.push(i);
                    }
                }
            }
        }   

    }    
    void show(){
        for(int v = 0;v<V;v++){
            System.out.print(v+": ");
            for(int j = 0 ; j<V ; j++){
                System.out.print(adjMatrix[v][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Adjacency_matrix a = new Adjacency_matrix(4);
        a.addEdge(0, 1);
        a.addEdge(1, 2);
        a.addEdge(2, 3);
        a.addEdge(3, 0);
        a.show();
        System.out.println();
        a.dfs(1, 5);
    }


}
