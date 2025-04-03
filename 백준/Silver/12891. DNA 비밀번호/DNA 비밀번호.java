import java.io.*;
import java.util.*;

public class Main {
    static int[] check = new int[4];    // 최소 조건
    static int[] current = new int[4];  // 현재 윈도우 내 문자 개수
    static int satisfied = 0;           // 조건 만족한 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            add(dna[i]);
        }
        if (isValid()) result++;

        // 슬라이딩 윈도우 이동
        for (int i = P; i < S; i++) {
            add(dna[i]);
            remove(dna[i - P]);
            if (isValid()) result++;
        }

        System.out.println(result);
    }

    // 문자 추가
    private static void add(char c) {
        switch (c) {
            case 'A': current[0]++; break;
            case 'C': current[1]++; break;
            case 'G': current[2]++; break;
            case 'T': current[3]++; break;
        }
    }

    // 문자 제거
    private static void remove(char c) {
        switch (c) {
            case 'A': current[0]--; break;
            case 'C': current[1]--; break;
            case 'G': current[2]--; break;
            case 'T': current[3]--; break;
        }
    }

    // 조건 검사
    private static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (current[i] < check[i]) return false;
        }
        return true;
    }
}