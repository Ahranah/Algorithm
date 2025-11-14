import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int[] answer = new int[testCase];
        for(int i=0; i< testCase; i++){
            int nodes = Integer.parseInt(br.readLine());
            int[] edges = start(nodes, br);
            String[] testCase1 = br.readLine().split(" ");
            int a = Integer.parseInt(testCase1[0]);
            int b = Integer.parseInt(testCase1[1]);
            answer[i] = find(a, b, edges);
        }
        for(int ans : answer){
            System.out.println(ans);
        }
    }

    public static int[] start(int nodeNums, BufferedReader br) throws IOException{
        int[] edges = new int[nodeNums+1];
        for(int i=0; i<nodeNums-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[b] = a;
        }

        return edges;
    }

    public static int find(int a, int b, int[] e){
        HashSet<Integer> parents = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();

        q.add(a);
        parents.add(a);
        
        while(!q.isEmpty()){
            // a에서 시작해서 부모까지 넣어야함
            int find = q.remove();
            if( e[find] == 0) break;
            int nxt = e[find];
            q.add(nxt);
            parents.add(nxt);
        }

        // 자기자신이 최고 조상인 경우
        if(e[b] == 0) return b;

        int bFind = b;
        while(!parents.contains(bFind)){
            bFind = e[bFind];
        }
        return bFind;

    }
}