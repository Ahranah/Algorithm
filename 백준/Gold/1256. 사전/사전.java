import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // DP 테이블 초기화
        int[][] DP = new int[202][202];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) DP[i][j] = 1;
                else {
                    DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
                    if (DP[i][j] > 1000000000) DP[i][j] = 1000000001;
                }
            }
        }

        // 주어진 K가 만들 수 있는 조합 수보다 크면 불가능
        if (DP[n + m][m] < k) {
            System.out.println("-1");
            return;
        }

        // 결과를 담을 StringBuilder
        StringBuilder sb = new StringBuilder();

        // n, m이 0이 될 때까지 반복
        while (!(n == 0 && m == 0)) {
            if (n > 0 && DP[n - 1 + m][m] >= k) {
                sb.append("a");
                n--;
            } else {
                if (n > 0) k -= DP[n - 1 + m][m];
                sb.append("z");
                m--;
            }
        }

        // 최종 결과 출력
        System.out.println(sb.toString());
    }
}