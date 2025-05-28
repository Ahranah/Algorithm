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
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 개행 처리

        board = new char[n][m];
        State start = null;

        // 입력 받으면서 R, B 위치 찾기
        for (int i = 0; i < n; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'R') {
                    board[i][j] = '.';
                    if (start == null) start = new State(i, j, 0, 0, 0);
                    else start.rx = i; start.ry = j;
                } else if (board[i][j] == 'B') {
                    board[i][j] = '.';
                    if (start == null) start = new State(0, 0, i, j, 0);
                    else start.bx = i; start.by = j;
                }
            }
        }

        visited = new boolean[n][m][n][m];
        System.out.println(bfs(start));
    }

    // 구슬 굴리는 함수: 벽(#) 또는 구멍(O)까지 굴림
    static int[] roll(int x, int y, int dir) {
        int dist = 0;
        while (board[x + dx[dir]][y + dy[dir]] != '#' && board[x][y] != 'O') {
            x += dx[dir];
            y += dy[dir];
            dist++;
            if (board[x][y] == 'O') break;
        }
        return new int[]{x, y, dist};
    }

    static int bfs(State start) {
        Deque<State> q = new ArrayDeque<>();
        q.add(start);
        visited[start.rx][start.ry][start.bx][start.by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.depth >= 10) return 0;

            for (int d = 0; d < 4; d++) {
                // 빨간 구슬 이동
                int[] r = roll(cur.rx, cur.ry, d);
                // 파란 구슬 이동
                int[] b = roll(cur.bx, cur.by, d);

                // 파란 구슬이 구멍에 빠지면 실패
                if (board[b[0]][b[1]] == 'O') continue;

                // 빨간 구슬만 구멍에 빠졌으면 성공
                if (board[r[0]][r[1]] == 'O') return 1;

                // 두 구슬이 겹치면, 더 많이 이동한 구슬을 한 칸 뒤로
                if (r[0] == b[0] && r[1] == b[1]) {
                    if (r[2] > b[2]) {
                        r[0] -= dx[d];
                        r[1] -= dy[d];
                    } else {
                        b[0] -= dx[d];
                        b[1] -= dy[d];
                    }
                }

                if (!visited[r[0]][r[1]][b[0]][b[1]]) {
                    visited[r[0]][r[1]][b[0]][b[1]] = true;
                    q.add(new State(r[0], r[1], b[0], b[1], cur.depth + 1));
                }
            }
        }

        return 0; // 10번 안에 성공 못 하면 실패
    }
}