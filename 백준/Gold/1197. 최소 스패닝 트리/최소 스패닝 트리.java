import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int s; int e; int v;
        public Edge(int s, int e, int v) {
            this.s = s; this.e = e; this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            pq.add(new Edge(s, e, v));
        }

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int ans = 0;
        while ( cnt < n-1) {
            Edge cur = pq.poll();
            if (union(cur.s, cur.e)){
                ans += cur.v;
                cnt++;
            }

        }

        System.out.println(ans);

    }
    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}

