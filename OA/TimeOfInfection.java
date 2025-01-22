import java.util.*;

class UnionFind {
    private int[] parent;
    private int[] rank;
    private HashMap<Integer, Boolean> groupInfected;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        groupInfected = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            groupInfected.put(i, false);
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                groupInfected.put(rootX, groupInfected.get(rootX) || groupInfected.get(rootY));
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                groupInfected.put(rootY, groupInfected.get(rootX) || groupInfected.get(rootY));
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
                groupInfected.put(rootX, groupInfected.get(rootX) || groupInfected.get(rootY));
            }
        }
    }

    public boolean isGroupInfected(int x) {
        return groupInfected.get(find(x));
    }

    public void setGroupInfected(int x) {
        groupInfected.put(find(x), true);
    }
}

public class TimeOfInfection {

    public static int[] timeOfInfection(int n, int[] initiallyInfected, int[][] updates) {
        UnionFind uf = new UnionFind(n);
        int[] infectedTime = new int[n];
        HashMap<Integer, Boolean> vaccinated = new HashMap<>();

        Arrays.fill(infectedTime, -1);

        // Mark initially infected people
        for (int person : initiallyInfected) {
            infectedTime[person] = 0;
            uf.setGroupInfected(person);
        }

        for (int i = 0; i < updates.length; i++) {
            int type = updates[i][0];
            int a = updates[i][1];
            int b = updates[i][2];

            if (type == 0) {  // Contact update
                int rootA = uf.find(a);
                int rootB = uf.find(b);

                if (rootA != rootB) {
                    boolean groupAInfected = uf.isGroupInfected(a);
                    boolean groupBInfected = uf.isGroupInfected(b);

                    uf.union(a, b);
                    int newRoot = uf.find(a);

                    if (groupAInfected || groupBInfected) {
                        if (!groupAInfected) uf.setGroupInfected(a);
                        if (!groupBInfected) uf.setGroupInfected(b);
                        for (int x = 0; x < n; x++) {
                            if (uf.find(x) == newRoot && infectedTime[x] == -1 && !vaccinated.getOrDefault(x, false)) {
                                infectedTime[x] = i + 1;
                            }
                        }
                    }
                }

            } else if (type == 1) {  // Vaccination update
                vaccinated.put(a, true);
            }
        }

        return infectedTime;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] initially_infected = {0,3};
        int[][] updates = {
            {0,0,3}, // At t = 1, person 0 and 1 come in contact
            {0,0, 4},    // At t = 2, person 2 gets vaccinated
            {0, 5,2}, // At t = 3, person 1 and 2 come in contact
            {1,3,-1},
            {1,2,-1},
            {0,2,4}
        };

        int[] result = timeOfInfection(n,  initially_infected, updates);
        System.out.println(Arrays.toString(result));  // Output: [0, -1, -1, 0, 2, 6]
    }
}