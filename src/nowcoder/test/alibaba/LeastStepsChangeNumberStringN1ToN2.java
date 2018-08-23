package nowcoder.test.alibaba;

public class LeastStepsChangeNumberStringN1ToN2 {
    /*
    * 题目描述：
     * 给定两个长度为 n ( 0 < n <= 8 ) 的 数字串 (由1到9构成)  ，我们希望对第一个数字串做一系列如下操作：
     * 1、将数字串的某一位加1
     * 2、将数字串的某一位减1
     * 3、交换数字串中任意两个数字的位置
     * 最终使得第一个数字串变成第二个数字串， 请问最少需要多少操作。
    * */

    public static void main(String[] args) {
        int[] source = new int[]{1, 2, 3, 4};
        int[] destination = new int[]{2, 3, 4, 1};
        int[] D = new int[8];
        for (int i = 0; i < D.length; i++)
            D[i] = 0;
        LeastStepsForChange(D, source, destination, 0);
        System.out.println(D[0]);
    }


    public static int LeastStepsForChange(int[] D, int[] source, int[] destination, int index) {
        /**@Description： 将source中[index, source.length-1]的元素转化为destination中[index,source.length-1]的元素
         * @Param D int[] ： 用于存储DP结果的数组
         * @Param source int[] ： 第一个数字串
         * @Param destination int[] ：第二个数字串
         * @Param index int ：指示当前已经处理到第index个数字
         * */
        //设置两个变量分别存储两种转换方式所需要的最少转换步骤
        int steps1 = 0;
        int steps2 = Integer.MAX_VALUE;
        if (index == (source.length - 1)) {//如果当前已经处理到最后一个元素了，那么只需要计算对应位置元素之间差的绝对值
            D[index] = Math.abs(source[index] - destination[index]);
        } else {//否则就需要进行两种方式的尝试
            steps1 = Math.abs(source[index] - destination[index]) + LeastStepsForChange(D, source, destination, index + 1);
            //因为第二种方式会尝试交换index后面的任何一个元素，并且交换之后source也会变化，所以一方面要循环，
            //另一方面还要修改source数组.
            int[] src;
            for (int j = index + 1; j < source.length; j++) {
                //首先交换source[index]和source[j]
                int temp = 0;
                temp = source[j];
                source[j] = source[index];
                source[index] = temp;
                //记录变化之后的source数组
                src = source;
                if ((1 + Math.abs(source[index] - destination[index]) + LeastStepsForChange(D, src, destination, index + 1)) < steps2) {
                    steps2 = 1 + Math.abs(source[index] - destination[index]) + LeastStepsForChange(D, src, destination, index + 1);
                }
            }
            D[index] = Math.min(steps1, steps2);
        }
        return D[index];
    }
}
