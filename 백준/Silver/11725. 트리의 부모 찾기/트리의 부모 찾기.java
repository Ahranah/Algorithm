import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드 개수
        graph = new ArrayList<>();
        parent = new int[n + 1]; // 부모 정보 저장
        visited = new boolean[n + 1]; // 방문 체크

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 입력
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // DFS 탐색 시작 (루트는 1)
        dfs(1);

        // 결과 출력 (2번 노드부터 n번 노드까지 부모 출력)
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    // DFS 탐색
    public static void dfs(int node) {
        visited[node] = true;

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                parent[nextNode] = node; // 부모 노드 설정
                dfs(nextNode); // 재귀 호출
            }
        }
    }
}