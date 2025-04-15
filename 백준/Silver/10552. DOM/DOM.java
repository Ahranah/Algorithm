import java.util.*;

public class Main {
    static class Pair {
        int fav, hate ;

        public Pair(int a, int b) {
            this.fav = a;
            this.hate = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int programmes = sc.nextInt();
        int cur_ch = sc.nextInt();

        Pair[] pensioners = new Pair[n+1];
        List<Queue<Integer>> hateMap = new ArrayList<>(programmes+1);
        for (int i = 0; i <= programmes; i++) { //0부터???인이유가 뭐지
            hateMap.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            int fav = sc.nextInt();
            int hate = sc.nextInt();
            pensioners[i+1] = new Pair(fav, hate);
            hateMap.get(hate).add(i+1);
        }

        int result = 0;
        boolean[] visited = new boolean[programmes+1];

        while(true) {

            if (visited[cur_ch]) {
                System.out.println(-1); // 무한 루프 방지
                return;
            }

            visited[cur_ch] = true;

            Integer person = hateMap.get(cur_ch).poll();
            if (person!= null){
                cur_ch = pensioners[person].fav;
                result ++;                
            } else {
                System.out.println(result);
                return;
            }
        }
    }
}