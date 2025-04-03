import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int Aim = sc.nextInt();
        
        int[] ingredients = new int[N];
        
        for (int i =0; i<N; i++){
            ingredients[i] = sc.nextInt();
        }
        
        Arrays.sort(ingredients);
        int cnt =0 ;
        int first = 0;
        int last = N-1;
        
        while (first < last) {
            if (ingredients[first] + ingredients[last] < Aim){
                first ++;
            }
            else if (ingredients[first] + ingredients[last] == Aim){
                cnt ++;
                first++;
                last--;
            } else {
                last --;
            }
        }
        System.out.print(cnt);
    }
}