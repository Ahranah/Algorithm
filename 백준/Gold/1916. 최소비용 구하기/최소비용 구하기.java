import java.util.*;

class Node implements Comparable<Node> {
    int target;
    int weight;

    Node(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v = input.nextInt(); // 정점 수
        int e = input.nextInt(); // 간선 수

        List<List<Node>> graph = new ArrayList<>(v+1);
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        int[] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[v+1];

        for (int i = 0; i < e; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int cost = input.nextInt();

            graph.get(a).add(new Node(b, cost));
        }

        int start = input.nextInt();
        int end = input.nextInt();
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.target;
            if (!visited[now]){
                visited[now] = true;
                for (Node n : graph.get(now)) {
                    if (dist[n.target] > dist[now] + n.weight ) {
                        dist[n.target] = dist[now] + n.weight;
                        pq.offer(new Node(n.target, dist[n.target]));
                    }
                }
            }
        }
        System.out.println(dist[end]);
    }
}

