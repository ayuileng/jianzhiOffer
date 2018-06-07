package jianzhioffer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem21 {
    public void reOrderArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1 % 2 == 0 && o2 % 2 == 1) {
                return 1;
            } else if (o1 % 2 == 1 && o2 % 2 == 0) {
                return -1;
            } else {
                return 0;
            }
        });
        Object[] array1 = list.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) array1[i];
        }
    }

    public void reOrderArray2(int array[]) {
        //双指针法
        if (array == null || array.length == 0) return;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && !isCondition(array[start])) {
                start++;
            }
            while (start < end && isCondition(array[end])) {
                end--;
            }
            if (start < end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }

    }

    private boolean isCondition(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        new Problem21().reOrderArray2(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
