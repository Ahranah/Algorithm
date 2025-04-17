
import java.util.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String example = sc.next();
        // 인덱스 받을 필요 없이 split
        String[] str = example.split("-");

        for (int i = 0; i < str.length; i++) {
            // 순서 조정으로 -가 없는 경우를 따로 빼주지 않아도 됨
            int num = plusSum(str[i]);
            if (i == 0) {
                result += num;
            } else result -= num;
        }
        System.out.println(result);
    }

    static int plusSum(String line) {
        String[] lines = line.split("\\+");
        int sumResult = 0;

        if (lines.length == 1) {
            return Integer.parseInt(line);
        }

        for (String s : lines) {
            int fromLine = Integer.parseInt(s);
            sumResult += fromLine;
        }
        return sumResult;
    }
}
