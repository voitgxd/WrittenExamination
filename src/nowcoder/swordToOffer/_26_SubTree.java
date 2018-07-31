package nowcoder.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _26_SubTree {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        TreeNode des = findNode(root1, root2.val);
        if (des == null) {
            return false;
        }
        return isEqual(des, root2);
    }

    public static boolean isEqual(TreeNode root1, TreeNode root2) {
        if ((root1 != null && root2 != null && root1.val != root2.val)) {
            return false;
        } else if (root1 != null && root2 != null && root1.val == root2.val) {
            return true && isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
        }
        return false;
    }

    public static TreeNode findNode(TreeNode root1, int desVal) {
        if (root1 == null || root1.val == desVal) {
            return root1;
        }
        TreeNode leftResult = findNode(root1.left, desVal);
        TreeNode rightResult = findNode(root1.right, desVal);
        if (leftResult != null) {
            return leftResult;
        } else {
            return rightResult;
        }
    }

    public static String Serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer res = new StringBuffer();
        res.append(String.valueOf(root.val));
        res.append(",");
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.left != null) {
                queue.add(p.left);
                res.append(String.valueOf(p.left.val));
            } else {
                res.append("#");
            }
            res.append(",");
            if (p.right != null) {
                queue.add(p.right);
                res.append(String.valueOf(p.right.val));
            } else {
                res.append("#");
            }
            res.append(",");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public static TreeNode Deserialize(String str) {
        if (str == null || str.length() <= 0) return null;
        String[] strs = str.split(",");
        TreeNode root = deSerializeCore(strs, 0);
        return root;
    }

    public static TreeNode deSerializeCore(String[] strs, int index) {
        if (index > strs.length - 1 || "#".equals(strs[index])) {
            return null;
        } else {
            TreeNode newNode = new TreeNode(0);
            newNode.val = Integer.parseInt(strs[index]);
            newNode.left = deSerializeCore(strs, 2 * index + 1);
            newNode.right = deSerializeCore(strs, 2 * index + 2);
            return newNode;
        }
    }


    public static void main(String[] args) {
        String treeStr1 = "8,8,7,9,2,#,#,#,#,4,7";
        String treeStr2 = "8,9,2";
        TreeNode node1 = Deserialize(treeStr1);
        TreeNode node2 = Deserialize(treeStr2);
        System.out.println(HasSubtree(node1, node2));

        String res = Serialize(node1);
        System.out.println(res);
        TreeNode resNode = deSerializeCore(res.split(","), 0);
        System.out.println(Serialize(resNode));
    }
}
