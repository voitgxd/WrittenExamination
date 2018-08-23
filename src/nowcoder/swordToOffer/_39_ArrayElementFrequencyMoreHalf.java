package nowcoder.swordToOffer;

public class _39_ArrayElementFrequencyMoreHalf {

    /*
     * 思想：
     * 1。如果某个元素出现的频率超过全部元素的一半，那么它的出现频率会超过其他元素出现频率的总和
     * 2。动态规划思想：子任务是当前出现频率最多元素的频率，如果变为0，说明前面所有元素中没有一个元素的出现频率超过前面元素总和
     * 3。从头开始计数，保证后面的元素中有元素的出现频率超过后面元素的一半即可
     *
     * */

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0)
            return 0;
        int maxFrequency = 1;
        int maxFrequencyElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (i != array.length - 1 && maxFrequency == 0) {
                maxFrequency = 1;
                maxFrequencyElement = array[i];
                continue;
            }
            if (array[i] != maxFrequencyElement)
                maxFrequency--;
            else maxFrequency++;
        }
        if (maxFrequency > 0)
            return maxFrequencyElement;
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
