package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class HuadongChuangkou {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        //队列中放的是下标，可以通过下标判断是否过期
        LinkedList<Integer> queue = new LinkedList<>();
        if (num == null || num.length == 0 || size == 0) return result;
        for (int i = 0; i < num.length; i++) {
            if (queue.isEmpty()) {
                queue.offerLast(i);
            }
            if (num[queue.peekLast()] <= num[i]) {
                while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                    queue.removeLast();
                }
            }
            queue.addLast(i);
            if (i >= size - 1) {
                while (i-queue.peekFirst() > size - 1) {
                    queue.removeFirst();
                }
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;

    }
}
