package nowcoder.swordToOffer;

import java.util.Arrays;
import java.util.Scanner;

public class JumpFloorHarder {

    public static int jump1(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(jump1(n));
    }
}
