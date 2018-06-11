package jianzhioffer;

import jianzhioffer.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class Problem37 {
    //使用先序遍历来序列化和反序列化
    public String Serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        process(root, sb);
        return sb.toString();
    }

    private void process(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#_");
            return;
        }
        sb.append(root.val + "_");
        process(root.left, sb);
        process(root.right, sb);
    }

    public TreeNode Deserialize(String str) {
        if ("".equals(str) || str.isEmpty()) return null;

        String[] nodes = str.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String node : nodes) {
            queue.offer(node);
        }
        TreeNode root = recovery(queue);
        return root;

    }

    private TreeNode recovery(Queue<String> queue) {
        String val = queue.poll();
        if("#".equals(val)){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = recovery(queue);
        head.right = recovery(queue);
        return head;
    }



    public static void printBSTInOrder(TreeNode head) {
        System.out.print("in-order: ");
        if (head != null) {
            inOrderPrint(head);
        }
        System.out.println();
    }

    public static void inOrderPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.val + " ");
        inOrderPrint(head.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(2);
        head.right = new TreeNode(9);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.left.right.right = new TreeNode(4);
        head.right.left = new TreeNode(7);
        head.right.right = new TreeNode(10);
        head.right.left.left = new TreeNode(6);
        head.right.left.right = new TreeNode(8);

        printBSTInOrder(head);
        String serialize = new Problem37().Serialize(head);
        System.out.println(serialize);
        TreeNode tree = new Problem37().Deserialize(serialize);
        printBSTInOrder(tree);
    }


}
