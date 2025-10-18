import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] key = br.readLine().split("\\*");

        String prefix = key[0];
        String suffix = key[1];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            
            if (s.length() < prefix.length() + suffix.length()) {
                // 전체 길이가 prefix + suffix보다 짧으면 무조건 안 맞음
                System.out.println("NE");
                continue;
            }

            if (s.startsWith(prefix) && s.endsWith(suffix)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}