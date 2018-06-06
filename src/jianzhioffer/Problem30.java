package jianzhioffer;

import java.util.Stack;

public class Problem30 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty() || node < minStack.peek()){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if(! dataStack.isEmpty() && ! minStack.isEmpty()){
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
