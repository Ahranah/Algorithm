import java.util.*;

class Solution {
    public class Node{
        int to;
        int value;
        Node(int t, int v){
            to = t;
            value = v;
        }
    }
    
    public int solution(int N, int[][] road, int K) {

        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.value - b.value);
        List<Node>[] adj = new List[N+1];
        int[] answer = new int[N+1];
        // boolean[] vi = new boolean[N+1];
        
        for(int i=0; i<N+1; i++){
            adj[i] = new ArrayList<Node>();
        }
        
        Arrays.fill(answer, 500001);
        answer[1] = 0;
        answer[0] = 0;
        
        // adj list
        for(int i =0; i< road.length; i++){
            int f = road[i][0];
            int t = road[i][1];
            int v = road[i][2];
            
            adj[f].add(new Node(t, v));
            adj[t].add(new Node(f, v));
        }
    
        pq.add(new Node(1, 0));
            
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int n = cur.to;
            int nv = cur.value;
            
            // just skip it. This is the correct "visited" check.
            if (nv > answer[n]) {
                continue; 
            }
            
            // connects to cur node
            for(Node nds: adj[n]){
                int nxt = nds.to;
                int weight = nds.value;
                int newDist = nv + weight; 
                // The new path distance to the neighbor
                
                // This is the "relaxation" step
                // If we found a shorter path to 'nxt'
                if (newDist < answer[nxt]) {
                    answer[nxt] = newDist; // Update the shortest distance
                    pq.add(new Node(nxt, newDist)); // Add this new, better path to the queue
            }
        }
        }
        
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(answer[i] <= K) cnt++;
        }
       return cnt;
    }
}