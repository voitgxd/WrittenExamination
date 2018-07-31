package nowcoder.leetcode;

public class _05_InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p_pre = head, p = p_pre.next, q_pre = p, q = q_pre.next, tem;
        if (p.val < p_pre.val) {
            int tem_val = p.val;
            p.val = p_pre.val;
            p_pre.val = tem_val;
        }
        while (q != null) {
            p_pre = head;
            p = p_pre.next;
            while (p != q) {
                if (q.val < head.val) {
                    tem = q;
                    q_pre.next = q.next;
                    tem.next = head;
                    head = tem;
                    break;
                } else if (q.val < p.val) {
                    tem = q;
                    q_pre.next = q.next;
                    tem.next = p;
                    p_pre.next = tem;
                    break;
                } else {
                    p_pre = p;
                    p = p_pre.next;
                }
            }
            if (p == q)
                q_pre = q;
            q = q_pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        //1.边界
        //1.1 null
        //1.2 1
        //1.3 1->2->3
        //2.排序 先断，后接
        //3.时间复杂度
        //4.空间复杂度
        //5.总结：单链表插入排序需要五个指针
        ListNode node1, node2, node3;
        ListNode node4, node5, node6;
        node1 = new ListNode(3);
        node2 = new ListNode(2);
        node3 = new ListNode(1);
        node4 = new ListNode(4);
        node5 = new ListNode(6);
        node6 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode result_node = insertionSortList(node1);
        for (ListNode p = result_node; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }
}