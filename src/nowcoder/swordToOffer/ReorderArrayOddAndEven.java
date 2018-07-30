package nowcoder.swordToOffer;

public class ReorderArrayOddAndEven {

    public static void reOrderArray(int[] nums) {
        // quick sort : not stable
        int L = -1, R = nums.length - 1, index = 0;
        while (index < R) {
            if (nums[index] % 2 == 0)
                swap(nums, index, R--);
            else
                swap(nums, index++, ++L);
        }
    }

    public static void reOrderArray2(int[] nums) {
        // sort : stable
        int[] copy = nums.clone();
        int oddIndex = 0;
        for (int num : nums) {
            if (num % 2 == 1)
                oddIndex++;
        }
        int i = 0, j = oddIndex;
        for (int num : copy) {
            if (num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 6, 6, 9, 7, 8, 6, 8};
        reOrderArray2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
