package nowcoder.test.wangyi;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] line_1 = line1.split(" ");
        int n = Integer.parseInt(line_1[0]);
        if (n < 1) {
            System.out.println(0);
            return;
        }
        int k = Integer.parseInt(line_1[1]);
        String line2 = sc.nextLine();
        String[] line_2 = line2.split(" ");
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(line_2[i]);
        }
        String line3 = sc.nextLine();
        String[] line_3 = line3.split(" ");
        int[] isAwake = new int[n];
        for (int i = 0; i < n; i++) {
            isAwake[i] = Integer.parseInt(line_3[i]);
        }
        int maxScoreSum = 0;
        for (int i = 0; i < n; i++) {
            int[] tem = isAwake.clone();
            for (int j = 0, index = i; j < k && index < tem.length; j++, index++) {
                tem[index] = 1;
            }
            int sumTem = count(score, tem);
            if (sumTem > maxScoreSum)
                maxScoreSum = sumTem;
        }
        System.out.println(maxScoreSum);
    }

    public static int count(int[] score, int[] isAwake) {
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            if (isAwake[i] == 1)
                sum += score[i];
        }
        return sum;
    }

}