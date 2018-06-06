package nowcoder.leetcode;

public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode p = head.next, tail = new ListNode(head.val);
        int count = 1;
        while(p != null){
            ListNode q = new ListNode(p.val);
            q.next = tail;
            tail = q;
            p = p.next;
            count ++;
        }
        ListNode q = tail, p_next, q_pre = q, q_next;
        p = head;
        for(int i=0; i < count / 2; i++) {
            p_next = p.next;
            q_pre = q;
            q_next = q.next;
            p.next = q;
            q.next = p_next;
            p = p_next;
            q = q_next;
        }
        if (count % 2 != 0)
            p.next = null;
        else
            q_pre.next = null;
    }

    public static void main(String[] args) {
        //1.考虑边界
        //1.1 null
        //1.2 1
        //1.3 1->2->3
        //1.4 1->2->3->4
        //2.排序
        //3.时间复杂度：O(n log n)
        //4.空间复杂度：O(n)
        //5.总结：单链表转置
        ListNode node1, node2, node3, node4;
        node1 = new ListNode(3);
        node2 = new ListNode(2);
        node3 = new ListNode(1);
        node4 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        reorderList(node1);
        for (ListNode p = node1; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }
}
