
// 무방향 그래프 연결 요소의 개수
import java.util.*;

// 간선 개수 1000 ^ 2 / 2

// 배열리스트로 엣지마다 간선 구조 파악 + BFS
// 주의: 배열 1번부터

class Graph {
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private int n;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList<>();
        // ArrayList 배열 기반 리스트: 내부 값을 배열 저장 -> 인덱스 접근이 빠르다.
        // LinkedList 연결 리스트: 삽입삭제가 빠르다.
        for(int i = 0; i <= n; i++) {
            // 엣지마다 배열 생성: 연결된 구조를 알기 위해
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        // 노드가 1번부터 시작 => 정점 개수는 n+1개
    }

    // 엣지 연결 구조 생성
    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    public int countPaths() {
        int count = 0;
        // n 은 엣지 개수
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                // BFS를 돌면서 방문한 엣지들을 표시했기 때문에 새로운 연결 요소 파악 가능
                BFS(i);
                count++;
            }
        }
        return count;
    }


    private void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adjList.get(cur)) {
                // get: cur번 노드에 연결된 이웃 노드 리스트 가져오기
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int EdgeNum = sc.nextInt();
        int LineNum = sc.nextInt();

        Graph graph = new Graph(EdgeNum);
        for(int i = 0; i < LineNum; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }

        System.out.println(graph.countPaths());
    }
}