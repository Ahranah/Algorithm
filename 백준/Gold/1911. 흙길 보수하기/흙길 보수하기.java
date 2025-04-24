
import java.util.*;

class Pair {
    int start, end;

    public Pair (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();

        // 입력 순서 정렬
        PriorityQueue<Pair> puddle = new PriorityQueue<>((a,b)-> (a.start - b.start));

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            puddle.add(new Pair(start, end));
        }

        int start = 0;
        int result = 0;

        while(!puddle.isEmpty()){

            Pair curr = puddle.poll();

            if (curr.end < start) {
                continue;
            }
            start = Math.max(curr.start, start);
            int length = curr.end - start;

            int count = length % l != 0 ? length/l + 1 : length/l;

            result += count;

            start += count*l;

        }

        System.out.println(result);
    }
}

