package nowcoder.test.wangyi;

import java.util.Scanner;

public class Test1 {

    /*
     * 小易高数课点瞌睡
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] score = new int[n];
        int[] isAwake = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            isAwake[i] = sc.nextInt();
            result += score[i] * isAwake[i];
        }
        int maxKRangeZeroSum = 0;
        for (int i = 0; i < k; i++) {
            maxKRangeZeroSum += Math.abs(isAwake[i] - 1) * score[i];
        }
        for (int i = 3; i < n; i++) {
            int now = Math.abs(isAwake[i] - 1) * score[i];
            int needRemove = Math.abs(isAwake[i - 3] - 1) * score[i];
            if (now > needRemove)
                maxKRangeZeroSum += (now - needRemove);
        }
        System.out.println(result + maxKRangeZeroSum);
    }

}
