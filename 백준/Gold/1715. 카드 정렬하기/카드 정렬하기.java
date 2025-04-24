import java.util.*;

public class Main {
    public static void  main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();

       PriorityQueue<Integer> pq = new PriorityQueue<>(n);
       for (int i =0;i<n;i++){
           pq.add(sc.nextInt());
       }

       int result = 0;
       while (pq.size() > 1){
           int A = pq.remove();
           int B = pq.remove();
           int sum = A + B;
           pq.add(sum);
           result += sum;
       }

        System.out.println(result);
    }
}