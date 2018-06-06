package jianzhioffer;

import java.util.Stack;

public class Problem9 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }




    public int JumpFloorII(int target) {
        if (target == 1 || target == 2 || target == 0) return target;
        int[] result = new int[target + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                result[i]+=result[j];
            }
        }
        return result[target];

    }

}
