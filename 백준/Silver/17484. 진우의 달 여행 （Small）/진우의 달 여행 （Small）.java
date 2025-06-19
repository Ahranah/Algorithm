import java.util.*;

public class Main {
    public static class Node {
        int x;
        int y;
        int v;
        int dir; // -1, 0, 1 (좌하, 하, 우하)

        public Node(int x, int y, int v, int dir) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.dir = dir;
        }

    }

    public static boolean[][] v;
    public static PriorityQueue<Integer> pq;
    public static int[][] coord;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        coord = new int[n][m];

        // 행렬 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                coord[i][j] = a;
            }
        }

        // 달에 도달한 노드 저장소
        pq = new PriorityQueue<>((a, b) -> a - b);

        // 첫 번째 행 모든 열에서 출발점 생성 후 dfs
        for (int i = 0; i < m; i++) {
            int value = coord[0][i];

            v = new boolean[n][m];

            v[0][i] = true;
            dfs(new Node(i, 0,  value, 3));
        }


        System.out.println(pq.peek());
    }

    public static void dfs(Node cur) {
        // 좌, 하, 우
        int[] dx = {-1, 0, 1};
        int[] dy = {1, 1, 1};

        // 달에 닿으면 pq에 넣기
        // 아래로만 이동하기 때문에 depth가 필요없음
        if (cur.y == coord.length-1) {
            pq.add(cur.v);
            return;
        }

        for (int j = 0; j < 3; j++) {
            int x = cur.x + dx[j];
            int y = cur.y + dy[j];

            if (x >= 0 && y >= 0 && y < coord.length && x < coord[0].length) {
                if (v[y][x] || cur.dir == j) continue;

                v[y][x] = true;
                dfs(new Node(x, y, cur.v + coord[y][x], j));
                v[y][x] = false;
            }
        }
    }
}