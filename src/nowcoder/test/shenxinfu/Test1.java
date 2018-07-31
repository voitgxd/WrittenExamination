package nowcoder.test.shenxinfu;

public class Test1 {

    public static ListNode test(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        //1.考虑边界
        //1.1 null
        //1.2 1
        //1.3 1->2->3
        //2.排序
        //3.时间复杂度：O(n log n)
        //4.空间复杂度：O(n)
        //5.总结：单链表冒泡排序需要3个指针

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
