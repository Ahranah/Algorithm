import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int cnt = 1; // 숫자 하나인 경우
        int first = 1; int last = 1; 
        int sum = 1; 
        
        while ( last != N ) {
            if(sum == N) {
                cnt ++ ;
                last ++;
                sum += last;
            } else if (sum > N){
                sum -= first;
                first ++;
            } else {
                last ++ ; sum += last;    
            }
        }
        System.out.print(cnt);
    }
}