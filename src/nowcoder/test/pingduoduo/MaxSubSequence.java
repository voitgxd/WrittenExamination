package nowcoder.test.pingduoduo;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSubSequence {
    public static int[][] dp;
    public static int[] arrayX;
    public static int[] arrayY;

    public static TreeSet<String> set = new TreeSet<>();

    public static int lengthOfLIS(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }


    private static void traceBack(int[][] dp, int i, int j, String lcs_str) {
        while (i > 0 && j > 0) {
            if (arrayX[i - 1] == arrayY[j - 1]) {
                lcs_str += String.valueOf(i - 1) + ",";
                --i;
                --j;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1])
                    --i;
                else if (dp[i - 1][j] < dp[i][j - 1])
                    --j;
                else {  // 相等的情况
                    traceBack(dp, i - 1, j, lcs_str);
                    traceBack(dp, i, j - 1, lcs_str);
                    return;
                }
            }
        }
        set.add(new StringBuffer(lcs_str).deleteCharAt(lcs_str.length() - 1).reverse().toString());
    }


    public static void main(String[] args) {
        int[] test = {1, 2, 5, 3, 3, 3};
        int[] test2 = test.clone();
        Arrays.sort(test2);
        arrayX = test;
        arrayY = test2;
        lengthOfLIS(arrayX, arrayY);
        traceBack(dp, arrayX.length, arrayY.length, "");
        for (String str : set)
            System.out.println(str);
    }
}
