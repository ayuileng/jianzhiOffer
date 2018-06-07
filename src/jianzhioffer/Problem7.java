package jianzhioffer;

import jianzhioffer.node.TreeNode;

import java.util.Arrays;

public class Problem7 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) return null;
        if (pre.length == 0 || in.length == 0 || pre.length != in.length) return null;
        TreeNode root = new TreeNode(pre[0]);
        int index = getIndex(in, pre[0]);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + index), Arrays.copyOfRange(in, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + index, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return root;
    }

    private static int getIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) return i;
        }
        return -1;
    }





}
