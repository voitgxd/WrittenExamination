package nowcoder.swordToOffer;

import java.util.HashMap;
import java.util.Map;

public class ReConstructBinaryTree {
    private static Map<Integer, Integer> inOrderNumsIndexs = new HashMap<>();

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < pre.length; i++) {
            inOrderNumsIndexs.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int index = inOrderNumsIndexs.get(root.val);
        // index 左边为左子树中序遍历的结果
        // index 右边为右子树中序遍历的结果
        int leftTreeSize = index - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, in, inL, inL + leftTreeSize - 1);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, in, inL + leftTreeSize + 1, inR);
        return root;
    }

    public static void preSearch(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preSearch(root.left);
            preSearch(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
//        preSearch(t1);
        TreeNode result = reConstructBinaryTree(pre, in);
        preSearch(result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
