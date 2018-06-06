package jianzhioffer;

import java.util.Arrays;

public class Problem33 {
    //33
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        if (sequence.length <= 3) return true;
        int root = sequence[sequence.length - 1];
        int i = 0;
        while (i < sequence.length) {
            if (sequence[i] < root) {
                i++;
            } else {
                break;
            }
        }
        for (int j = i; j < sequence.length; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        int[] left = Arrays.copyOfRange(sequence, 0, i);
        int[] right = Arrays.copyOfRange(sequence, i, sequence.length - 1);

        return (left.length == 0 ? true : VerifySquenceOfBST(left)) &&
                (right.length == 0 ? true : VerifySquenceOfBST(right));

    }
}
