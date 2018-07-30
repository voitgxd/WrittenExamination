package nowcoder.swordToOffer;

import java.util.Random;
import java.util.regex.Pattern;

public class RegularExpressionMatch {

    // 动态规划问题：拆分子任务
    public static void printDp(boolean[][] dp, int row, int col) {
        System.out.println("  ");
        for (int i = 0; i < dp[0].length; i++) {
            if (col == i) {
                System.out.print("  *   ");
            } else {
                System.out.print("  " + i + "   ");
            }
        }
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            if (row == i) {
                System.out.print("* ");
            } else {
                System.out.print(i + " ");
            }
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean match(char[] str, char[] pattern) {
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
//            printDp(dp, 0, i);
        }

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty
                printDp(dp, i, j);
            }
        return dp[m][n];
    }

    public static boolean rightMatch(String str, String pattern) {
        return Pattern.matches(pattern, str);
    }

    public static void main(String[] args) {
        Random random = new Random();
//        int strLen = random.nextInt(100);
//        for (int j = 0; j < 50000; j++) {
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < strLen; i++) {
//                // ascii code : A-Z 65-90 a-z 97-122 * 42 .46
//                // random int :[32, 126)
//                int charAscii = random.nextInt(126 - 32) + 32;
//                char randomChar = (char) charAscii;
//                sb.append(randomChar);
//            }
//            String testStr = sb.toString();
//            boolean rightAnswer = rightMatch(testStr, "ab*ac*a");
//            boolean myAnswer = match(testStr.toCharArray(), "ab*ac*a".toCharArray());
//            if (rightAnswer != myAnswer) {
//                System.out.println(testStr);
//                break;
//            }
//        }
//        System.out.println(rightMatch("aaa", "ab*ac*a"));
        match("aaa".toCharArray(), "ab*ac*a".toCharArray());
//        System.out.println(match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
//        System.out.println(match("aaa".toCharArray(), "a.a".toCharArray()));
    }
}
