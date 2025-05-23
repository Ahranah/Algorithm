import java.util.*;

class Solution {
    class Node {
        int x; int y; int d;
        public Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    boolean[][] v;
    Deque<Node> q;
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        v = new boolean[n+1][m+1];
        q = new ArrayDeque<>();
        
        q.add(new Node(1, 1, 1));
        v[1][1] = true;
        
        while (!q.isEmpty()){
            Node cur = q.remove();
            if (cur.x == n && cur.y == m){
                return cur.d;
            }
            
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            
            for (int i=0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx > 0 && ny > 0 && nx <= n && ny <= m) {
                    if (!v[nx][ny] && maps[nx-1][ny-1] != 0) {
                        v[nx][ny] = true;
                        q.add(new Node(nx, ny, cur.d+1));
                   }
                }
            }
        }
        return -1;
    }
}