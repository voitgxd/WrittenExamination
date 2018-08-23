package nowcoder.swordToOffer;

import java.util.Arrays;

import nowcoder.utils.TreeNode;

public class _33_VerifySquenceOfBST {

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 9)
            return false;
        // 根据二叉树的中序和后序序列生成二叉树
        int[] inOrder = sequence.clone();
        Arrays.sort(inOrder);
        TreeNode root;
        try {
            root = generateBinaryTree(inOrder, sequence, 0, sequence.length - 1, 0, sequence.length - 1);
        } catch (Exception e) {
            root = null;
        }
        if (root == null)
            return false;
        return true;
    }

    public static TreeNode generateBinaryTree(int[] inOrder, int[] postOrder, int I_L, int I_R, int P_L, int P_R) {
        if (I_L > I_R || P_L > P_R)
            return null;
        int rootVal = postOrder[P_R];
        int rootValIndex = -1;
        for (int i = I_L; i <= I_R; i++) {
            if (inOrder[i] == rootVal) {
                rootValIndex = i;
                break;
            }
        }
        if (rootValIndex == -1)
            throw new NullPointerException("not found this root val");
        int leftTreeLen = rootValIndex - I_L;
        TreeNode root = new TreeNode(rootVal);
        root.left = generateBinaryTree(inOrder, postOrder, I_L, I_L + leftTreeLen - 1, P_L, P_L + leftTreeLen - 1);
        root.right = generateBinaryTree(inOrder, postOrder, rootValIndex + 1, I_R, P_L + leftTreeLen, P_R - 1);
        return root;
    }


    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}
