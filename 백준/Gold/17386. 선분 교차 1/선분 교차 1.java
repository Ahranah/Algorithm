
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        int x3 = input.nextInt();
        int y3 = input.nextInt();
        int x4 = input.nextInt();
        int y4 = input.nextInt();
        
        if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) < 0
                && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) < 0){
            System.out.println(1);
        }
        else System.out.println(0);
    }

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3) > 0 ? 1 : -1;
    }
}

