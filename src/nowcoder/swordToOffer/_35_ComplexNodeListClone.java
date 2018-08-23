package nowcoder.swordToOffer;

public class _35_ComplexNodeListClone {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        // 第一步，在每个节点的后面插入复制的节点。
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode pCopy = new RandomListNode(p.label);
            // 把 pCopy 插入到p之后
            pCopy.next = p.next;
            p.next = pCopy;
            p = pCopy.next;
        }
        // 第二步，对复制节点的 random 链接进行赋值。
        p = pHead;
        while (p != null) {
            RandomListNode pCopy = p.next;
            // 复制 pCopy 的 random 引用
            if (p.random != null)
                pCopy.random = p.random.next;
            p = pCopy.next;
        }
        // 第三步，拆分。
        p = pHead;
        RandomListNode pCopyHead = pHead.next;
        while (p.next != null) {
            RandomListNode pCopy = p.next;
            // 复制 pCopy 的 random 引用
            p.next = pCopy.next;
            p = pCopy;
        }
        return pCopyHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
