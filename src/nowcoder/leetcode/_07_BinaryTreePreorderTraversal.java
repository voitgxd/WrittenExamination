package nowcoder.leetcode;

import java.util.ArrayList;

public class _07_BinaryTreePreorderTraversal {
    public static ArrayList<Integer> resultList = new ArrayList<Integer>();

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return resultList;
    }

    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        resultList.add(node.val);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        //1.边界
        //1.1 null
        //1.2 1
        //1.3 1->2->3
        //2.递归遍历
        //3.时间复杂度
        //4.空间复杂度
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        ArrayList<Integer> result = preorderTraversal(node1);
        System.out.println(result.toString());
    }
}
