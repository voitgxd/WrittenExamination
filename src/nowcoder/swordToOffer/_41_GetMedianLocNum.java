package nowcoder.swordToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _41_GetMedianLocNum {
    private PriorityQueue<Integer> heapSmall = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    private PriorityQueue<Integer> heapBig = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        if (!heapBig.isEmpty() && heapBig.peek() > num) {
            heapBig.offer(num);
        } else {
            heapSmall.offer(num);
        }
        // 堆调整
        if (heapBig.size() - heapSmall.size() >= 2) {
            heapSmall.offer(heapBig.poll());
        } else if (heapSmall.size() - heapBig.size() >= 2) {
            heapBig.offer(heapSmall.poll());
        }
    }

    public Double GetMedian() {
        double result;
        if (heapBig.size() != heapSmall.size()) {
            result = heapBig.size() > heapSmall.size() ? heapBig.peek() : heapSmall.peek();
        } else {
            result = (heapSmall.peek() + heapBig.peek()) * 1.0 / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        _41_GetMedianLocNum obj = new _41_GetMedianLocNum();
        for (int num : test
                ) {
            obj.Insert(num);
            System.out.println(obj.GetMedian());
        }
    }
}
