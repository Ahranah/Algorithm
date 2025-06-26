import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String line = sc.next();

        char[] arr = line.toCharArray();
        boolean[] eaten = new boolean[N];

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                // 앞뒤로 k칸 범위 탐색
                for (int j = i - K; j <= i + K; j++) {
                    if (j < 0 || j >= N) continue;
                    if (arr[j] == 'H' && !eaten[j]) {
                        eaten[j] = true;
                        count++;
                        break; // 한 사람은 햄버거 하나만 먹음
                    }
                }
            }
        }

        System.out.println(count);
    }
}