package nowcoder.swordToOffer;

public class CircleListNode {

    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode p = pHead, q = pHead;
        do {
            p = p.next;
            q = q.next.next;
        } while (q != p);
        q = pHead;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        ListNode res = entryNodeOfLoop(n1);
        if (res != null) {
            System.out.println(res.val);
        }
    }
}
