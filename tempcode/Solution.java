import java.util.*;

class Solution {
    static int[] dis;
    static ArrayList<Integer>[] map;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        dis = new int[n];
        map = new ArrayList[n];

        
        Arrays.setAll(map, i -> new ArrayList<>());

        for (int[] val : edges) {
            map[val[0]].add(val[1]);
            map[val[1]].add(val[0]);
        }

        int ans[] = new int[n];

        for(int i = 0;i<n;i++){
            ans[i] = bfs(i);
            // ans[i] = sum(dis);
        }

        return ans;
    }



    // Modified bfs to calculate distances from source to all other nodes
    int bfs(int source) {
      int lvl = 0;
      int sum = 0;
      Queue<Integer> q = new LinkedList<>();
      boolean[] visited = new boolean[dis.length];
      q.add(source);
      while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
          int node = q.poll();
          sum += lvl;
          visited[node] = true;
          for (int child : map[node]) {
            if (!visited[child]) {
              q.add(child);
            }
          }
        }
        lvl++;
      }
        return sum;
    }
  
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        // input from user where input is like [[] , [],[],[]] cosider it as string input so format and make array from user input
        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] arr = sc.nextLine().split(",");
            
            edges[i][0] = Integer.parseInt(arr[0]);
            edges[i][1] = Integer.parseInt(arr[1]);
        }
        
        
        int[] ans = s.sumOfDistancesInTree(n, edges);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
