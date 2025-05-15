import java.util.*;

public class Main {
    static long[] factorial = new long[21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cmd = sc.nextInt();

        // 1. 팩토리얼 계산
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        if (cmd == 1) {
            // 2. k번째 순열 찾기
            long k = sc.nextLong();
            findKthPermutation(n, k);
        } else {
            // 3. 몇 번째 순열인지 찾기
            int[] perm = new int[n];
            for (int i = 0; i < n; i++) {
                perm[i] = sc.nextInt();
            }
            findPermutationOrder(n, perm);
        }
    }

    // k번째 순열 찾기
    static void findKthPermutation(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        StringBuilder result = new StringBuilder();
        k--; // 0-based index로 변경

        for (int i = n; i > 0; i--) {
            long fact = factorial[i - 1];
            int index = (int)(k / fact);
            result.append(numbers.get(index)).append(" ");
            numbers.remove(index);
            k %= fact;
        }

        System.out.println(result.toString().trim());
    }

    // 주어진 순열이 몇 번째 순서인지 찾기
    static void findPermutationOrder(int n, int[] perm) {
        boolean[] visited = new boolean[n + 1];
        long order = 1;

        for (int i = 0; i < n; i++) {
            int current = perm[i];
            for (int j = 1; j < current; j++) {
                if (!visited[j]) {
                    order += factorial[n - 1 - i];
                }
            }
            visited[current] = true;
        }

        System.out.println(order);
    }
}