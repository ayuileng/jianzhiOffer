package jianzhioffer;

public class Problem39 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        int result = array[0];
        int count = 1;
        for (int i : array) {
            if (count == 0) {
                result = i;
                count++;
            } else if (i == result) {
                count++;
            } else {
                count--;
            }
        }
        int times = 0;
        for (int i : array) {
            if (i == result) {
                times++;
            }
        }
        return times > array.length / 2 ? result : 0;

    }

}
