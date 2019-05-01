public class Main {
    public static void main(String[] args) {
        //int numCities = 6;
        //int[][] roadsAvailable = {{1, 4}, {4, 5}, {2, 3}};
        //int[][] newRoads = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        int numCities = 5;
        int[][] roadsAvailable = {{2, 3}, {4, 5}};
        int[][] newRoads = {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
        System.out.println(getMinCostToConstruct(numCities, roadsAvailable, newRoads));
    }
    
    public static int getMinCostToConstruct(int numCities, int[][] roadsAvailable, int[][] newRoads) {
        Set<Edge> edges = buildEdges(roadsAvailable, newRoads);
        return kruskalMST(numCities, edges);
    }

    private static Set<Edge> buildEdges(int[][] roadsAvailable, int[][] costNewRoads) {
        Set<Edge> edges = new HashSet<>();
        for (int[] road : roadsAvailable) {
            edges.add(new Edge(road[0], road[1], 0));
        }
        for (int[] road : costNewRoads) {
            edges.add(new Edge(road[0], road[1], road[2]));
        }
        return edges;
    }

    private static int kruskalMST(int numCities, Set<Edge> edges) {
        Queue<Edge> pq = new PriorityQueue<>(edges);
        UF uf = new UF(numCities + 1);
        int mstSize = 0;
        int totalCost = 0;
        while (!pq.isEmpty() && mstSize < numCities - 1) {
            Edge edge = pq.poll();
            if (!uf.connected(edge.u, edge.v)) {
                uf.union(edge.u, edge.v);
                totalCost += edge.cost;
                mstSize++;
            }

        }
        return totalCost;
    }
}

class Edge implements Comparable<Edge> {
    int v;
    int u;
    int cost;

    public Edge(int v, int u, int cost) {
        this.v = v;
        this.u = u;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge that) {
        return Integer.compare(this.cost, that.cost);
    }
}

class UF {
    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)

    public UF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pr = find(p);
        int qr = find(q);
        if (pr == qr) return;
        if (rank[pr] < rank[qr]) {
            parent[pr] = qr;
        } else {
            parent[qr] = pr;
            if (rank[pr] == rank[qr]) rank[pr]++;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
