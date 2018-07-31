package nowcoder.swordToOffer;

import java.util.Scanner;

public class _10_1_JumpFloor {
    public static int jump(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        return jump(target - 1) + jump(target - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(jump(n));
    }
}
