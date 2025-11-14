import java.util.*;

class Solution {
    public class Edges{
        int from;
        int to;
        int wei;
        
        Edges(int f, int t, int w){
            from=f;
            to=t;
            wei=w;
        }
    }
    
    public int[] arr;
    public int solution(int n, int[][] costs) {
        arr = new int[n+1];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }
        
        List<Edges> edges = new ArrayList<>();
        
        for(int[] cost: costs){
            edges.add(new Edges(cost[0], cost[1], cost[2]));    
        }
        
        edges.sort(Comparator.comparingInt(e->e.wei));
        
        int total =0;
        int picked =0;
        
        for (Edges e: edges){
            // 다르면 연결
            if(union(e.to, e.from)){
                total += e.wei;
                picked ++;
                if(picked == n-1) return total;
            }
            
        }
        
        return total;
    }
    
    public boolean union(int a, int b){
        
        // set A mother
        int bMother = find(b);
        int aMother = find(a);
        if(aMother==bMother) return false;
        
        arr[bMother] = aMother;
        return true;
        }

    
    public int find(int a){
        if(arr[a] == a) return a;
        arr[a] = find(arr[a]);
        return arr[a];
    }
}