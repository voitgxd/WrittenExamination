package nowcoder.swordToOffer;

public class RopeCut {

    public static int cut(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                int tem = dp[i];
                dp[i] = Math.max(j * (i - j), dp[j] * (i - j));
                dp[i] = Math.max(tem, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cut(4));
    }
}
