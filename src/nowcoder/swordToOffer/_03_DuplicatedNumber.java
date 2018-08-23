package nowcoder.swordToOffer;

import java.util.ArrayList;

public class _03_DuplicatedNumber {

    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while(i != numbers[i]) {
                if(numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    System.out.print(duplication[0]);
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        // 1.边界
        // 1.1 null
        // 1.2 {}
        // 1.3 {2,2,2,2}
        // 2.时间复杂度
        // 3.空间复杂度
        int[] a = {2, 3, 1, 0, 2, 5};
        int[] duplication = new int[a.length];
        duplicate(a, a.length, duplication);
    }
}
