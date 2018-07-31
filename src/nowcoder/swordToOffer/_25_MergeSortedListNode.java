package nowcoder.swordToOffer;

public class _25_MergeSortedListNode {

    public static ListNode Merge2(ListNode list1, ListNode list2) {
        // 这种情况引入一个头节点考虑的情况会少很多，以后单链表的题还是需要设置一个临时的头节点
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null)
            cur.next = list1;
        if (list2 != null)
            cur.next = list2;
        return head.next;
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 != null && list2 == null) {
            return list1;

        } else if (list1 == null && list2 != null) {
            return list2;
        }
        ListNode l1 = list1, l2 = list2, head = l1.val > l2.val ? l2 : l1, tailM, tail;
        if (head == l1)
            l1 = l1.next;
        else
            l2 = l2.next;
        tailM = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail = l1.next;
                tailM.next = l1;
                tailM = l1;
                l1 = tail;
            } else {
                tail = l2.next;
                tailM.next = l2;
                tailM = l2;
                l2 = tail;
            }
        }
        if (l1 != null) {
            tailM.next = l1;
        }
        if (l2 != null) {
            tailM.next = l2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        n1.next = n3;
        n3.next = n5;

        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n6 = new ListNode(6);
        n2.next = n4;
        n4.next = n6;

        ListNode res = Merge(n1, n2);
        while (res != null) {
            System.out.println(res.val + " ");
            res = res.next;
        }
    }
}
