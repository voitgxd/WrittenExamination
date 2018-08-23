package nowcoder.swordToOffer;

public class _43_NumberOf1Between1AndN_Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        // If last digit of a >= 2, a+8 will increase tens digit by 1,
        // same as (a/10+1) as stefan explained. If a is 3140/3141 (last digit is 0/1),
        // you only consider the case "" to "313", which is 314, same as 3148/10 or 3149/10,
        // since the remaining part is not a full coverage and add b+1 if last digit is 1.
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int left = n / m, right = n % m;
            System.out.println("考虑的所在位数=" + m + " left=" + left + " right=" + right + " 1的个数=" + ((left + 8) / 10 * m + (left % 10 == 1 ? right + 1 : 0)));
            cnt += (left + 8) / 10 * m + (left % 10 == 1 ? right + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        _43_NumberOf1Between1AndN_Solution obj = new _43_NumberOf1Between1AndN_Solution();
        System.out.println(obj.NumberOf1Between1AndN_Solution(1));
    }
}
