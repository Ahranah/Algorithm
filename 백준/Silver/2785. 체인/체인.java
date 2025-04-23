
import java.util.*;
import java.io.*;

public class Main {
    public static void  main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int cnt = 0;
        int sum = 0;
        for (int i =0 ; i < n; i++){
            cnt = n - 1 - i;  // 남은 체인 수
            sum += arr[i];    // 지금까지 사용 가능한 고리 수 누적

            if (sum >= cnt) {
                break;        // 연결할 수 있을 만큼 고리가 모였다!
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();

//            if (each == N-2){
//             // 틈 -1 이 가능하면 그게 정답
//                System.out.println(N-2);
//            } System.out.println(N-1);
    }
}