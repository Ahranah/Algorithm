// 버블 소트를 수행하는데, 정렬이 끝나는 시점은 몇 번째 반복(바깥 루프)이었는지
// 버블 소트에서 한 번에 최대 1칸씩 앞으로 이동하므로,
// 정렬 전 인덱스 - 정렬 후 인덱스의 차이의 최댓값이 반복 횟수
import java.util.*;
import java.io.*;
// scanner이용시 메모리초과


public class Main {
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        Pair[] arr = new Pair[N];
        
        // 맨 처음값부터 배열 전체를 한 번씩 훑고
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = new Pair(temp, i);
        }

        Arrays.sort(arr, Comparator.comparingInt(p -> p.value));

        int maxDiff = 0;
        for (int j = 0; j < N ; j++) {
            int diff = arr[j].index - j;

            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }

        bw.write((maxDiff+1) + "\n");
        bw.close();
        br.close();
        // 반복은 1부터 시작하므로 +1
    }
}



