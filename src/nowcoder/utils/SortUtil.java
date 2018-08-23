package nowcoder.utils;

import java.util.Arrays;
import java.util.Random;

public class SortUtil {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /* 一、交换类排序
     * 1。冒泡排序
     * 2。快速排序
     * 3。随机快速排序
     * */
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tem = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tem;
                }
            }
        }
        printArray(arr);
    }

    public static void quickSort(int[] arr) {
        /*
         * 1。partition
         * 2。exchange
         * */
        quickSortCore(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public static void quickSortCore(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int flagValue = arr[l];
        int left = l, right = r;
        while (l < r) {
            while (l <= r && arr[r] > flagValue) --r;
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l <= r && arr[l] < flagValue) ++l;
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[r] = flagValue;
        quickSortCore(arr, left, r - 1);
        quickSortCore(arr, r + 1, right);
    }

    public static void randomQuickSort(int[] arr) {
        randomQuickSortCore(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public static void randomQuickSortCore(int[] arr, int l, int r) {
        if (l >= r)
            return;
        Random random = new Random();
        int left = l, right = r;
        int flagValueIndex = random.nextInt(r - l) + l;
        int flagValue = arr[flagValueIndex];
        arr[flagValueIndex] = arr[l];
        arr[l] = flagValue;
        while (l < r) {
            while (l <= r && arr[r] > flagValue) --r;
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l <= r && arr[l] < flagValue) ++l;
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[r] = flagValue;
        randomQuickSortCore(arr, left, r - 1);
        randomQuickSortCore(arr, r + 1, right);
    }

    /*
     * 二、插入类排序：
     * 1。直接插入排序
     * 2。希尔排序
     * */

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tem = arr[i];
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > tem)
                    arr[j] = arr[j - 1];
                else {
                    arr[j] = tem;
                    break;
                }
            }
        }
        printArray(arr);
    }

    public static void shellSort(int[] arr) {
        // 增量加选择排序
        int initD = arr.length / 2;
        for (int d = initD; d > 0; d /= 2) {
            for (int i = d; i < arr.length; i += d) {
                int tem = arr[i];
                for (int j = i; j > 0; j -= d) {
                    if (arr[j - d] > tem)
                        arr[j] = arr[j - d];
                    else {
                        arr[j] = tem;
                        break;
                    }
                }
            }
        }
        printArray(arr);
    }

    /*
     * 三、选择类排序：
     * 1。简单选择
     * 2。堆排序
     * */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                int tem = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tem;
            }
        }
        printArray(arr);
    }

    public static void heapSort(int[] arr) {
        //堆是一颗完全二叉树
        //n个节点的完全二叉树叶子节点个数为（n+1）/2，最后一个非叶子节点是 （n/2）-1
        //1。建立小根堆的时候从第一个非叶子节点开始向上调整
        //2。向下调整
        createMinHeap(arr);
        printArray(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            int tem = arr[i];
            arr[i] = arr[0];
            arr[0] = tem;
            heapDownAdjust(arr, 0, i);
            printArray(arr);
        }
        printArray(arr);
    }

    public static void createMinHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapDownAdjust(arr, i, arr.length);
        }
    }

    public static void heapDownAdjust(int[] arr, int index, int heapSize) {
        // 将一个完全二叉树调整为一个大根堆
        int tem = arr[index];
        int lastIndex = index;
        while (index <= heapSize / 2 - 1) {
            if (arr[2 * index + 1] > tem)
                lastIndex = 2 * index + 1;
            if (2 * index + 2 < heapSize && arr[2 * index + 2] > tem && arr[2 * index + 2] > arr[2 * index + 1])
                lastIndex = 2 * index + 2;
            if (lastIndex != index) {
                arr[index] = arr[lastIndex];
                index = lastIndex;
            } else break;
        }
        arr[lastIndex] = tem;
    }

    /*
     * 四、归并排序
     * 1。二路归并排序
     *
     * */
    public static void mergeSort(int[] arr, int l, int r, int result[]) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m, result);
        mergeSort(arr, m + 1, r, result);
        mergeSortMerge(arr, result, l, m, r);
    }

    public static void mergeSortMerge(int[] arr, int[] result, int l, int m, int r) {
        int resL = 0;
        int i = l, j = m + 1;
        Arrays.fill(result, 0);
        while (i <= m && j <= r) {
            if (arr[i] < arr[j])
                result[resL++] = arr[i++];
            else
                result[resL++] = arr[j++];
        }
        while (i <= m)
            result[resL++] = arr[i++];
        while (j <= r)
            result[resL++] = arr[j++];
        for (int index = 0; index < resL; index++) {
            arr[l + index] = result[index];
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 29, 32, 32, 3, 5, 2, 98, 123, 76};
        // bubbleSort
//        bubbleSort(arr);
        // quickSort
//        quickSort(arr);
        //randomQuickSort
//        randomQuickSort(arr);
        //insertSort
//        insertSort(arr);
        //shellSort
//        shellSort(arr);
        //selectSort
//        selectSort(arr);
        //heapSort
        heapSort(arr);
        //mergeSort
//        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
//        printArray(arr);
    }
}
