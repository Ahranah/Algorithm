import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] scores = new double[n];
        double max = 0;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
            if (scores[i] > max) {
                max = scores[i];
            }
            sum += scores[i];
        }
        
        System.out.println(sum *100 / max / n);
    }
}