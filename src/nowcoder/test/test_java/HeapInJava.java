package nowcoder.test.test_java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapInJava {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
