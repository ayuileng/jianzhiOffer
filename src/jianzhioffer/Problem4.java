package jianzhioffer;

public class Problem4 {
    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int row = array.length;
        int col = array[0].length;

        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
