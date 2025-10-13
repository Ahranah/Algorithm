import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<Integer>[] adj = new ArrayList[n+1];
        
        for(int i=0; i<=n ; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][1];
            int b = wires[i][0];
            adj[a].add(b);
            adj[b].add(a);
        }
        
        
        for (int i =0; i< wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            adj[a].remove(Integer.valueOf(b));
            adj[b].remove(Integer.valueOf(a));

            boolean[] visited = new boolean[n+1];
            int count = dfs(a, visited, adj);
            answer = Math.min(answer, Math.abs((n - count) - count));

            adj[a].add(b); // 복원
            adj[b].add(a); // 복원
        }
        return answer;
    }
    
    public int dfs(int node, boolean[] v, List<Integer>[] list){
        v[node] = true;
        // if(list[node].size()==0) return 0;
        
        int count = 1;

        for(int i: list[node]){
            if(!v[i]){
                v[i] = true;
                count += dfs(i, v, list);
            }
        }
        
        return count;
    }
}