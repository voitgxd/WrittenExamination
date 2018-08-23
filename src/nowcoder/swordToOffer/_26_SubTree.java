package nowcoder.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import nowcoder.utils.TreeNode;

public class _26_SubTree {

    private static ArrayList<TreeNode> desNodes = new ArrayList<>();

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        findNode(root1, root2.val);
        for (TreeNode des : desNodes) {
            boolean result = isEqual(des, root2);
            if (result)
                return true;
        }
        return false;
    }

    public static boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null || root1.val != root2.val)
            return false;
        return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
    }

    public static void findNode(TreeNode root1, int desVal) {
        if (root1 == null)
            return;
        if (root1.val == desVal)
            desNodes.add(root1);
        findNode(root1.left, desVal);
        findNode(root1.right, desVal);
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

    // right solution
    public static boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubtreeWithRoot(root1, root2) || HasSubtree2(root1.left, root2) || HasSubtree2(root1.right, root2);
    }

    private static boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }


    public static void main(String[] args) {
        String treeStr1 = "8,#,9,3,2";
        String treeStr2 = "";
        TreeNode node1 = Deserialize(treeStr1);
//        TreeNode node2 = Deserialize(treeStr2);
        System.out.println(HasSubtree(node1, null));

        String res = Serialize(node1);
        System.out.println(res);
        TreeNode resNode = deSerializeCore(res.split(","), 0);
        System.out.println(Serialize(resNode));
    }
}
