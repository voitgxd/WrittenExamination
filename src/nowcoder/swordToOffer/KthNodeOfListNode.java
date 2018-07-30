package nowcoder.swordToOffer;

public class KthNodeOfListNode {

    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode p = head, q = head;
        int count = k;
        while (q != null && count-- > 0) {
            q = q.next;
        }
        if (count > 0)
            return null;
        while (q != null) {
            q = q.next;
            p = p.next;
        }
        return p;
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
        ListNode res = findKthToTail(n1, 10);
        if (res != null) {
            System.out.println(res.val);
        }
    }
}
