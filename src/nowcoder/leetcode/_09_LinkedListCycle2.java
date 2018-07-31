package nowcoder.leetcode;

import java.util.ArrayList;

public class _09_LinkedListCycle2 {
    public static ArrayList<ListNode> nodeList = new ArrayList<>();

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode p = head.next;
        nodeList.add(head);
        while (p != null) {
            if (nodeList.contains(p)) {
                return p;
            }
            nodeList.add(p);
            p = p.next;
        }
        return null;
    }

    public static void main(String[] args) {
        //1.边界
        //1.1 null
        //1.2 1
        //1.3 1->2
        //1.4 1->2->1
        //2.detect cycle
        ListNode node1, node2, node3, node4, resultNode;
        node1 = new ListNode(3);
        node2 = new ListNode(2);
        node3 = new ListNode(1);
        node4 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;
        resultNode = detectCycle(node1);
        if (resultNode == null)
            System.out.print("null");
        else
            System.out.print(resultNode.val);
    }
}
