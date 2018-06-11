package jianzhioffer;

import jianzhioffer.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class Problem36 {

    //思路1  用队列保存中序遍历的序列，所以是天生有序的，然后再根据队列建立链表，缺点是空间复杂度
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        inOrderToQueue(pRootOfTree, queue);
        if (queue.isEmpty()) return pRootOfTree;
        TreeNode head = queue.poll();
        TreeNode pre = head;
        TreeNode cur = null;
        pre.left = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    private void inOrderToQueue(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) return;

        inOrderToQueue(root.left, queue);
        queue.offer(root);
        inOrderToQueue(root.right, queue);
    }

    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode[] nodes = process(pRootOfTree);
        return nodes[0];
    }

    //递归函数，返回处理好的链表的头结点和尾结点
    private TreeNode[] process(TreeNode root) {
        if (root == null) return new TreeNode[]{null, null};
        TreeNode[] left = process(root.left);
        TreeNode[] right = process(root.right);
        root.left = null;
        root.right = null;
        if (left[1] != null) {
            left[1].right = root;
            root.left = left[1];
        }
        if (right[0] != null) {
            right[0].left = root;
            root.right = right[0];
        }
        TreeNode leftNode = left[0] != null ? left[0] : root;
        TreeNode rightNode = right[1] != null ? right[1] : root;
        return new TreeNode[]{leftNode, rightNode};

    }


}
