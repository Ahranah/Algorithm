// BufferedReader + StringTokenizer 조합 - BOJ에서만 사용
import java.io.*;
import java.util.*;
    
public class Main{
    public static void main(String[] args) throws IOException{
        // 한줄씩 새로 입력받을 때 buf.readLine()은 io 내부 처리 없음..에러 처리 필요
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner보다 빠르지만, 타입 변환은 직접 해야 함.
        StringTokenizer token = new StringTokenizer(buf.readLine());
        // 입력에서 "한 줄"을 읽고, 커서는 그 다음 줄로 이동
        
        // Token은 nextToken()만 존재 - Queue (인덱스는 없음)
        int suNo = Integer.parseInt(token.nextToken());
        int quizNo = Integer.parseInt(token.nextToken());
        
        long[] S = new long[suNo+1];
        token = new StringTokenizer(buf.readLine());
        // 새로운 한 줄씩 읽어서 토큰 분해하려고 재할당 : 새로운 줄을 파싱할 때마다 새로 만들어야 함
        
        for (int i = 1; i <=suNo ; i++){
            S[i] = S[i-1] + Integer.parseInt(token.nextToken());
        }
        
        for (int q = 0; q <quizNo; q++) {
            token = new StringTokenizer(buf.readLine());
            int i = Integer.parseInt(token.nextToken());
            int j = Integer.parseInt(token.nextToken());
            System.out.println(S[j] - S[i-1]);
            // i를 빼면 안되고 이전 값 i-1 빼는 것 주의
        }
    }
}