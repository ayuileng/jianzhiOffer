package leetcode;


import jianzhioffer.node.TreeNode;

import java.util.*;

public class TreeProblems {

    /**
     * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
     * 二叉树的根是数组中的最大元素。
     * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
     * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
     * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int maxIndex = getMaxIndex(nums);
        TreeNode head = new TreeNode(nums[maxIndex]);
        head.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        head.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        return head;

    }

    private int getMaxIndex(int[] nums) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }


    //将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        head.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return head;
    }

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left + right;
    }

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                if (pre != null && root.val <= pre.val) return false;
                pre = root;
                root = root.right;
            }
        }
        return true;
    }

    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return result;
    }

    /**
     * 给定一个二叉树，返回它的 后序 遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (i == size - 1) {
                    result.add(root.val);
                }
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
        }
        return result;
    }

    /**
     * 给出一个完全二叉树，求出该树的节点个数。
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        for (TreeNode cur = root; cur != null; cur = cur.left) {
            leftHeight++;
        }
        for (TreeNode cur = root; cur != null; cur = cur.right) {
            rightHeight++;
        }
        //特殊情况可以不用递归下去，可以减少很多重复的计算
        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight) - 1);
        } else {
            return countNodes(root.left) + 1 + countNodes(root.right);
        }
    }

    /**
     * 二叉树的序列化与反序列化
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        process(root, sb);
        return sb.toString();
    }

    private void process(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("_#");
            return;
        }
        sb.append(root.val + "#");
        process(root.left, sb);
        process(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data.trim())) {
            return null;
        }
        String[] split = data.split("#");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        return recovery(queue);
    }

    private TreeNode recovery(Queue<String> queue) {
        String s = queue.poll();
        if ("_".equals(s)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = recovery(queue);
        root.right = recovery(queue);
        return root;

    }

    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int index = getIndex(inorder, rootVal);
        int[] left = Arrays.copyOfRange(inorder, 0, index);
        int[] right = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.left = buildTree(left, Arrays.copyOfRange(postorder, 0, left.length));
        root.right = buildTree(right, Arrays.copyOfRange(postorder, left.length, postorder.length - 1));
        return root;
    }

    private int getIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) return i;
        }
        return -1;
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftHeight - rightHeight) <= 1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

}