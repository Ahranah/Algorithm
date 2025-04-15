import java.util.Arrays;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();

       Integer[] int_arr = new Integer[input.length()];
       for (int i = 0; i < input.length(); i++) {
           int add = input.charAt(i) - '0';
           int_arr[i]=(add);
        }

       Arrays.sort(int_arr, (a, b)-> b-a);

       for (int i : int_arr){
           System.out.print(i);
       }
    }
}