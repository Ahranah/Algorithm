import java.util.*;
import java.io.*;

public class Main {
    static HashMap<String, Integer> friends ;
    static HashMap<String, String> kruskal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++) {
            int M = Integer.parseInt(br.readLine());
            friends = new HashMap<>();
            kruskal = new HashMap<>();

            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();


                // 본인과 연결된 친구 개수 초기화
                if (!friends.containsKey(a)) {
                    friends.put(a, 1);
                }

                if (!friends.containsKey(b)) {
                    friends.put(b, 1);
                }

                // UnionFind 초기화
                kruskal.putIfAbsent(a, a);
                kruskal.putIfAbsent(b, b);

                int connected = union(a, b);
                sb.append(connected).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static String find(String i){
        String nxt = kruskal.get(i);
        if(nxt.equals(i)) return i;
        return find(kruskal.get(nxt));
    }

    public static int union(String a, String b){
        String aP = find(a);
        String bP = find(b);

        // 부모가 다르면 union
        // 왼쪽이 부모가 되게끔
        if (!aP.equals(bP)) {
            kruskal.replace(bP, aP);
        }
        else {
            // 부모가 같으면 바로 반환
            return friends.get(aP);
        }

        int connected = friends.get(aP) + friends.get(bP);
        // Set 크기도 업데이트, union되었다면 두 네트워크의 크기를 합쳐줌
        friends.put(aP, connected);
        return connected;
    }

}