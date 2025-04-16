import java.util.*;
import java.io.*;

class Pair {
    int x, y, depth;

    // Constructor
    Pair(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int depth = 0;

        int[][] maze = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 1; j <= col; j++) {
                maze[i][j] = line.charAt(j - 1) - '0';
            }
        }

        boolean[][] visited = new boolean[row + 1][col + 1];
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(1, 1, 1));

        while (!que.isEmpty()) {
            Pair current = que.poll();
            if (current.x == row && current.y == col) {
                System.out.println(current.depth);
                return;
            }

            visited[current.x][current.y] = true; // 이렇게 해도 상하좌우 확인하기 전에 방문처리하는 건 동일하지 않나??

            // 4 directions array
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];

                // x, y 가 상하좌우 이동할 수 있는지 확인
                if (x >= 1 && y >= 1 && x <= row && y <= col) {
                    if (!visited[x][y] && maze[x][y] == 1) {
                        // Mark as visited as soon as the cell is entered to avoid duplicates
                        visited[x][y] = true;
                        que.add(new Pair(x, y, current.depth + 1));
                    }
                }
            }
        }
    }
}