package nowcoder.swordToOffer;

public class _46_NumDecodings {

    public int numDecodings(String s) {
        //这道题是跳台阶的变种， 第一次可以跳一步，也可以跳两步，只不过跳两步的时候需要判断一下这个两步能不能跳成功
        //能跳的话才可以累加上去
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length() + 1; i++) {
            String str1 = s.substring(i - 1, i);
            String str2 = s.substring(i - 2, i);
            int n1 = Integer.parseInt(str1);
            int n2 = Integer.parseInt(str2);
            if (n1 != 0)
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) == '0')
                continue;
            if (n2 <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
