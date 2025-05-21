import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    static int N;
    static int[][] W;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        DP = new int[N][1 << N];

        for (int[] row : DP) Arrays.fill(row, -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));  // 시작: 도시 0, 방문 상태: 000...0001
    }

    static int tsp(int cur, int visited) {
        if (visited == (1 << N) - 1) {
            return W[cur][0] == 0 ? INF : W[cur][0];  // 모든 도시 방문 후 출발 도시로 복귀
        }

        if (DP[cur][visited] != -1) return DP[cur][visited];

        int min = INF;

        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && W[cur][next] != 0) {
                int cost = tsp(next, visited | (1 << next)) + W[cur][next];
                min = Math.min(min, cost);
            }
        }

        return DP[cur][visited] = min;
    }
}