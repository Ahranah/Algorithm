
import java.util.*;

public class Main {
    public static int[] parent;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == 1) {
                if (checkSame(b, c)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                union(b, c);
            }
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[a] = b;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}
