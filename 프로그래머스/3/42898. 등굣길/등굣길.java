import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        
        boolean[][] isPuddle = new boolean[n+1][m+1];
                
        dp[1][1] = 1;

        for(int i=0; i<puddles.length; i++){
            int col = puddles[i][0];
            int row = puddles[i][1];
            
            isPuddle[row][col] = true;
        }
        
        
        for(int i=1; i<=n; i++){ // 행
            for(int j=1; j<=m; j++){ // 열
                if (i==1 && j==1) continue;
                else if(isPuddle[i][j]) continue;
                else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
                    
                }
            }
        }
        
        return dp[n][m]%1000000007;
    }
    
}