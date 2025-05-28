import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int rx, ry, bx, by, depth;

        public State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static int n, m;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        board = new char[n][m];
        int rx = 0, ry = 0, bx = 0, by = 0;

        // 보드와 초기 위치 세팅
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        // BFS 시작
        Deque<State> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.add(new State(rx, ry, bx, by, 0));
        visited.add(rx + "," + ry + "," + bx + "," + by);

        while (!q.isEmpty()) {
            State cur = q.poll();

            // 10번 초과는 실패
            if (cur.depth >= 10) break;

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                // 빨간 구슬 굴리기
                int[] redResult = move(cur.rx, cur.ry, dx[i], dy[i]);
                int nrx = redResult[0], nry = redResult[1], rMove = redResult[2];

                // 파란 구슬 굴리기
                int[] blueResult = move(cur.bx, cur.by, dx[i], dy[i]);
                int nbx = blueResult[0], nby = blueResult[1], bMove = blueResult[2];

                // 파란 구슬이 구멍에 빠지면 이 시도는 실패
                if (board[nbx][nby] == 'O') continue;

                // 빨간 구슬만 구멍에 빠지면 성공
                if (board[nrx][nry] == 'O') {
                    System.out.println(1);
                    return;
                }

                // 두 구슬이 같은 위치면 더 많이 움직인 쪽을 한 칸 뒤로
                if (nrx == nbx && nry == nby) {
                    if (rMove > bMove) {
                        nrx -= dx[i];
                        nry -= dy[i];
                    } else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                // 방문 여부 확인
                String key = nrx + "," + nry + "," + nbx + "," + nby;
                if (!visited.contains(key)) {
                    visited.add(key);
                    q.add(new State(nrx, nry, nbx, nby, cur.depth + 1));
                }
            }
        }

        System.out.println(0);
    }

    // 구슬을 한 방향으로 굴리는 함수 (벽이나 구멍 만날 때까지)
    static int[] move(int x, int y, int dx, int dy) {
        int cnt = 0;
        while (true) {
            if (board[x + dx][y + dy] == '#' || board[x][y] == 'O') break;
            x += dx;
            y += dy;
            cnt++;
        }
        return new int[]{x, y, cnt};
    }
}