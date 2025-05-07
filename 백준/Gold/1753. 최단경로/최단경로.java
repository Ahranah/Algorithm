import java.util.*;

public class Main {
    static final int INF = 1000000000;

    static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight); // 오름차순
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v = input.nextInt(); // 정점 수
        int e = input.nextInt(); // 간선 수
        int start = input.nextInt(); // 시작 정점

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        int[] distance = new int[v + 1];
        boolean[] visited = new boolean[v + 1];

        Arrays.fill(distance, INF);

        for (int i = 0; i < e; i++) {
            int u = input.nextInt();
            int to = input.nextInt();
            int weight = input.nextInt();
            graph.get(u).add(new Edge(to, weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currVertex = current.vertex;

            if (visited[currVertex]) continue;
            visited[currVertex] = true;

            for (Edge next : graph.get(currVertex)) {
                if (distance[next.vertex] > distance[currVertex] + next.weight) {
                    distance[next.vertex] = distance[currVertex] + next.weight;
                    pq.add(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (distance[i] == INF) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}