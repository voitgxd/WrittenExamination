package nowcoder.test.wangyi;

import java.util.Scanner;

public class Test2 {
    static int[] res;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pnum = Integer.parseInt(input.nextLine().trim());

        int[] points = new int[pnum];
        String[] num = input.nextLine().trim().split(" ");
        for (int i = 0; i < pnum; i++) {
            points[i] = Integer.parseInt(num[i]);
        }
        int result_num = Integer.parseInt(input.nextLine().trim());
        res = new int[result_num];

        String[] needFind = input.nextLine().trim().split(" ");
        int[] need = new int[result_num];
        for (int i = 0; i < result_num; i++) {
            need[i] = Integer.parseInt(needFind[i]);
        }

        findData(points, pnum, need);
        if (res.length > 0) {
            for (int i = 0; i < result_num; i++) {
                System.out.println(res[i]);
            }
        }

    }

    private static void findData(int[] arr, int num, int[] need) {
        int[] sumArr = new int[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sumArr[i] = sum + arr[i];
            sum += arr[i];
        }
        for (int i = 0; i < need.length; i++) {
            int index = findMin(sumArr, need[i]);
            res[i] = index + 1;
        }
    }

    private static int findMin(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
