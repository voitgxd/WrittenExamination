package nowcoder.leetcode;

public class SortList {

    public static ListNode sortList(ListNode head) {
        //1.边界
        if (head == null || head.next == null)
            return head;
        //2.排序
        ListNode p = head, min = p, q = p.next;
        while (p != null) {
            min = p;
            while (q != null) {
                if (q.val < min.val) {
                    min = q;
                }
                q = q.next;
            }
            if (min != p) {
                int val_tem = p.val;
                p.val = min.val;
                min.val = val_tem;
            }
            p = p.next;
            if (p != null)
                q = p.next;
        }
        return head;
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
        ListNode node1, node2, node3;
        node1 = new ListNode(3);
        node2 = new ListNode(2);
        node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        ListNode result_node = sortList(node1);
        for (ListNode p = result_node; p != null; p = p.next) {
            System.out.println(p.val);
        }
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
