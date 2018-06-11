package jianzhioffer;

import java.util.Stack;

public class Problem31 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null) return popA == null;
        if (pushA.length == 0) return popA.length == 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (j < popA.length) {
            if (stack.isEmpty()) {
                stack.push(pushA[i]);
                i++;
            }
            if (stack.peek() == popA[j]) {
                j++;
                stack.pop();
            } else {
                if (i == pushA.length) {
                    return false;
                }
                stack.push(pushA[i]);
                i++;
            }
        }
        return i == pushA.length && stack.isEmpty();
    }

    public static void main(String[] args) {
        int pushA[] = {1, 2, 3, 4, 5};
        int popA[] = {4, 3, 5, 1, 2};
        boolean b = new Problem31().IsPopOrder(pushA, popA);
        System.out.println(b);
    }

}
