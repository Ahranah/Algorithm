import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> adj = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        int ans = 0;

        int N = Integer.parseInt(br.readLine());

        boolean[] v = new boolean[N+1];
        for(int i=0; i< N+1; i++){
            adj.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        q.add(1);
        v[1] = true;

        while(!q.isEmpty()){
            int cur = q.remove();
            List<Integer> connected = adj.get(cur);

            for(int i : connected){
                if(v[i]) continue;
                q.add(i);
                v[i] = true;
                ans ++;
            }
        }

        System.out.println(ans);

    }
}