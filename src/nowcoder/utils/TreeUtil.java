package nowcoder.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtil {

    public static void preOrderRecur(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public static void inOrderRecur(TreeNode root) {
        if (root == null)
            return;
        inOrderRecur(root.left);
        System.out.println(root.val);
        inOrderRecur(root.right);
    }

    public static void postOrderRecur(TreeNode root) {
        if (root == null)
            return;
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.println(root.val);
    }

    public static void preOrderUnRecur(TreeNode root) {
        // order: mid left right
        // stack in: mid right left
        // stack out: print after stack pop
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null)
                stack.add(node.left);
        }

    }

    public static void inOrderUnRecur(TreeNode root) {
        // order: left mid right
        // stack in: mid left
        // stack in: print when all mid and left into stack
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                // root is not null, push into stack and move to left
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    public static void postOrderUnRecur(TreeNode root) {
        // order: left right mid
        // stack in: mid right left
        // stack out: print when all elements into stack
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            help.add(node);
            if (node.left != null)
                stack.add(node.left);
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        while (!help.isEmpty()) {
            System.out.println(help.pop().val);
        }

    }

    public static String layerSerialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        queue.add(root);
        sb.append(root.val).append(",");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                sb.append(node.left.val).append(",");
            } else {
                sb.append("#").append(",");
            }

            if (node.right != null) {
                queue.add(node.right);
                sb.append(node.right.val).append(",");
            } else {
                sb.append("#").append(",");
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static TreeNode layerDeserialize(String str) {
        if (str == null || str.equals(""))
            return null;
        String[] vals = str.split(",");
        return layerDeserializeCore(vals, 0);
    }

    private static TreeNode layerDeserializeCore(String[] vals, int index) {
        if (index > vals.length - 1 || "#".equals(vals[index]))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(vals[index]));
        node.left = layerDeserializeCore(vals, 2 * index + 1);
        node.right = layerDeserializeCore(vals, 2 * index + 2);
        return node;
    }

    public static String preOrderSerialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + preOrderSerialize(root.left) + " " + preOrderSerialize(root.right);
    }

    public static TreeNode preOrderDeserialize(String str) {
        deserializeStr = str;
        return preOrderDeserialize();
    }

    private static String deserializeStr;

    private static TreeNode preOrderDeserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = preOrderDeserialize();
        t.right = preOrderDeserialize();
        return t;
    }

    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        TreeNode root = TreeUtil.layerDeserialize(str);
        TreeUtil.postOrderRecur(root);
    }
}
