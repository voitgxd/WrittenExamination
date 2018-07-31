package nowcoder.swordToOffer;

import java.util.Scanner;

public class _10_0_Fibonacci {

    public static int fbcc(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fbcc(n - 1) + fbcc(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0 || n > 39) {
            return;
        }
        System.out.println(fbcc(n));
    }
}
