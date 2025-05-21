import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        
        // 인덱스 1부터 주의
        for  (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine()); // st는 한 줄만 토큰화된 상태이므로 입력을 재할당
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][k+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                if ( j >= w[i])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}