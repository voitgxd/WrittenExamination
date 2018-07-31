package nowcoder.swordToOffer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class _11_RotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = 0, h = array.length - 1;
        // 3, 4, 5, 1, 2
        // 0, 1, 2, 3, 4
        while (l < h) {
            int m = (l + h) / 2;
            if (array[l] < array[m]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return array[h];
    }

    public static void main(String[] args) {
        int[] array = {3, 3, 1, 2};
//        int[] array = {2, 3, 4, 5, 1};
//        int[] array = {2, 3, 4, 5, 1};
        int result = minNumberInRotateArray(array);
        System.out.println(result);
    }
}
