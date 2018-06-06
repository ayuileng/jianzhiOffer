package jianzhioffer;

import java.util.ArrayList;

public class Problem6 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        print(listNode, result);
        return result;

    }

    private void print(ListNode listNode, ArrayList<Integer> result) {
        if(listNode == null) return;
        print(listNode.next,result);
        result.add(listNode.val);

    }
}
