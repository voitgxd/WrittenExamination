package nowcoder.swordToOffer;

import java.util.Arrays;

public class _45_PrintMinNumber {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String result = "";
        for (String str : nums)
            result += str;
        return result;
    }

    public static void main(String[] args) {
        _45_PrintMinNumber obj = new _45_PrintMinNumber();
        String result = obj.PrintMinNumber(new int[]{3, 32, 321});
        System.out.println(result);
    }
}
