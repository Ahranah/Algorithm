import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int N, M;
    static List<List<Node>> adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

         adj = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }

        System.out.println(prim(1));

    }

    public static int prim(int start) {
        boolean[] v = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Node(start, 0));

        int totalCost = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.to;

            if (v[node]) continue;

            v[node] = true;
            totalCost += cur.weight;

            // 연결된 간선 중에 현재 가중치+다음 이동 < 기존 가중치면 업데이트
            for (Node nxt : adj.get(node)) {
                if (!v[nxt.to]){
                    pq.add(nxt);
                }
            }
        }

        return totalCost;
    }
}