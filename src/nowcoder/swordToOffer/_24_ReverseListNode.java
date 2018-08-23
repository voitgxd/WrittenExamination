package nowcoder.swordToOffer;
import nowcoder.utils.ListNode;
public class _24_ReverseListNode {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head.next, tail;
        head.next = null;
        while (p != null) {
            tail = p.next;
            p.next = head;
            head = p;
            p = tail;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = reverseList(n1);
        while (res != null) {
            System.out.println(res.val + " ");
            res = res.next;
        }
    }
}
