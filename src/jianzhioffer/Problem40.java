package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem40 {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null||input.length == 0 ||k==0) return result;
        if(k>input.length) return result;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i : input) {
            if(queue.size()!=k){
                queue.offer(i);
            }else if(i<queue.peek()){
                queue.poll();
                queue.offer(i);
            }
        }
        result = new ArrayList<>(queue);
        return result;
    }



}
