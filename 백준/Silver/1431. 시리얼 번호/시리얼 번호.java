import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] serials = new String[N];
        for (int i = 0; i < N; i++) {
            serials[i] = sc.next();
        }

        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 1. 길이 비교
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }

                // 2. 숫자 합 비교
                int sumA = getDigitSum(a);
                int sumB = getDigitSum(b);
                if (sumA != sumB) {
                    return sumA - sumB;
                }

                // 3. 사전순 비교
                return a.compareTo(b);
            }

            private int getDigitSum(String s) {
                int sum = 0;
                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sum += c - '0';
                    }
                }
                return sum;
            }
        });

        for (String s : serials) {
            System.out.println(s);
        }
    }
}