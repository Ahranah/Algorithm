import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // b[k]를 기준으로, K보다 작은 것은 k-1개가 있어야 한다. -> 값으로 이분 탐색
        long start = 1;
        long end = K;
        long ans = 0;

        while (start <= end) {
            long middle = ((start + end) / 2);
            long count = 0;
            for (int i = 1; i <= N; i++) {
                // 작은 수를 탐색하는 핵심 로직
                count += Math.min(middle / i, N);
            }

            if (count < K){
                start = middle+1;
            } else {
                // A 배열에서 x 이하의 값이 K개 이상이면, x는 B[k]의 후보가 될 수 있다.
                ans = middle;
                end = middle-1;
            }
        }
        System.out.println(ans);
    }
}