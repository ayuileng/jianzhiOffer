package jianzhioffer;

public class Problem42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (sum <= 0) {
                sum = i;
            } else {
                sum += i;
            }
            max = Math.max(max, sum);
        }
        return max;

    }


}
