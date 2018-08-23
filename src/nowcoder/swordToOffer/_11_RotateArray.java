package nowcoder.swordToOffer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class _11_RotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = left + (right - left) / 2;
            if (array[middle] >= array[left]) {
                left = middle;
            }
            if (array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }


    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2};
//        int[] array = {2, 3, 4, 5, 1};
//        int[] array = {2, 3, 4, 5, 1};
        int result = minNumberInRotateArray(array);
        System.out.println(result);
    }
}
