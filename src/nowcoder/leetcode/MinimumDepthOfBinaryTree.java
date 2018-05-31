package nowcoder.leetcode;


public class MinimumDepthOfBinaryTree {
    public static int run(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return depth(root);
    }

    public static int depth(TreeNode root) {
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return depth(root.right) + 1;
        if(root.right == null)
            return depth(root.left) + 1;
        return Math.min(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        System.out.println(run(node1));

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

