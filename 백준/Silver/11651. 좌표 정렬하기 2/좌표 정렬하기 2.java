// 좌표정렬
import java.util.*;


// 100,000,000 = 1s
// 100,000 -> O(nlogn)

public class Main {
    public static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pair[] pairs = new Pair[N];

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            int y  = sc.nextInt();
            pairs[i] = new Pair(x, y); // 생성자 초기화 필수
        }

        Arrays.sort(pairs, Comparator.comparingInt((Pair p)->p.y).thenComparingInt(p->p.x));


        for (Pair p : pairs){
            System.out.println(p.x +" "+p.y);
        }
    }
}