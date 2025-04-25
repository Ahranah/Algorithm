
import java.util.*;

import java.util.*;

public class Main {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int t = sc.nextInt();
        Set<Integer> truth = new HashSet<>();
        for (int i = 0; i < t; i++) {
            truth.add(sc.nextInt());
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int cnt = sc.nextInt();
            List<Integer> participants = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                participants.add(sc.nextInt());
            }
            parties.add(participants);

            // 참가자끼리 union
            for (int j = 0; j < participants.size() - 1; j++) {
                union(participants.get(j), participants.get(j + 1));
            }
        }

        int ans = 0;
        for (List<Integer> party : parties) {
            boolean isTruthParty = false;
            for (int person : party) {
                for (int tPerson : truth) {
                    if (find(person) == find(tPerson)) {
                        isTruthParty = true;
                        break;
                    }
                }
                if (isTruthParty) break;
            }
            if (!isTruthParty) ans++;
        }

        System.out.println(ans);
    }
}


