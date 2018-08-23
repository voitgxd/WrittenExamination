package nowcoder.swordToOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _40_GetKLeaskNumbers {
    /*
     * 1。建立大小为k的小根堆，不改变堆的大小，不断进行插入和调整
     * */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0)
            return result;
        int heapSize = k <= input.length ? k : input.length;
        int[] heap = new int[heapSize];
        for (int i = 0; i < heapSize; i++) {
            heap[i] = input[i];
        }
        // 创建大根堆
        createMaxHeap(heap);
        for (int i = heapSize; i < input.length; i++) {
            // 如果数组中剩余元素大于小于堆顶元素则将其替换掉，并执行一次向下调整
            if (heap[0] > input[i]) {
                heap[0] = input[i];
                heapSortDownAdjust(heap, 0, heapSize);
            }
        }
        // 将筛选过的大根堆进行堆排序
        // 堆排序每次将堆顶元素与当前的叶子节点元素替换掉，向下调整
        for (int i = 0; i < heapSize; i++) {
            int tem = heap[0];
            heap[0] = heap[heapSize - i - 1];
            heap[heapSize - i - 1] = tem;
            heapSortDownAdjust(heap, 0, heapSize - i - 1);
        }
        for (int num : heap) {
            result.add(num);
        }
        return result;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution_2(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0)
            return result;
        int heapSize = k <= input.length ? k : input.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //大根堆
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (i < heapSize)
                heap.add(input[i]);
            else if (heap.peek() > input[i]) {
                heap.poll();
                heap.add(input[i]);
            }
        }
        // 将筛选过的大根堆进行堆排序
        // 堆排序每次将堆顶元素与当前的叶子节点元素替换掉，向下调整
        while (!heap.isEmpty())
            result.add(heap.poll());
        return result;
    }

    public void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public void createMaxHeap(int[] heap) {
        //n个节点的完全二叉树，共有叶子节点个数为 (n+1)/2 个
        //那么非叶子节点个数为 n-(n+1)/2 = n/2 - 1/2
        //那么第一个非叶子节点的下标为n/2-1
        for (int i = heap.length / 2 - 1; i >= 0; i--) {
            heapSortDownAdjust(heap, i, heap.length);
        }
    }

    public void heapSortDownAdjust(int[] heap, int index, int heapSize) {
        // 到达叶子节点就停止调整
        int tem = heap[index];
        int lastIndex = index;
        while (index <= heapSize / 2 - 1) {
            //左孩子是一定存在的
            if (heap[2 * index + 1] > tem)
                lastIndex = 2 * index + 1;
            //右孩子不一定存在
            if (2 * index + 2 < heapSize && heap[2 * index + 2] > tem && heap[2 * index + 2] > heap[2 * index + 1])
                lastIndex = 2 * index + 2;
            if (lastIndex != index) {
                heap[index] = heap[lastIndex];
                index = lastIndex;
            } else break;
        }
        heap[lastIndex] = tem;
    }

    public static void main(String[] args) {
        _40_GetKLeaskNumbers obj = new _40_GetKLeaskNumbers();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = obj.GetLeastNumbers_Solution_2(input, 4);
        for (int num : result)
            System.out.println(num);
    }
}
