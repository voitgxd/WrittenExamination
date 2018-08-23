package nowcoder.swordToOffer;

public class _42_FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : array
                ) {
            sum = sum < 0 ? num : sum + num;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -10, -4, -7, -2, -5};
        _42_FindGreatestSumOfSubArray obj = new _42_FindGreatestSumOfSubArray();
        System.out.println(obj.FindGreatestSumOfSubArray(nums));
    }
}
