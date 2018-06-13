package jianzhioffer;

public class Problem50 {
    //只包含因子2、3和5的数称作丑数（Ugly Number） 1是第一个丑数
    public int GetUglyNumber_Solution(int index) {
        if (index == 0 || index == 1) return index;
        int[] res = new int[index];
        res[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(Math.min(2 * res[i2], 3 * res[i3]), 5 * res[i5]);
            if (res[i] == 2 * res[i2]) {
                i2++;
            }
            if (res[i] == 3 * res[i3]) {
                i3++;
            }
            if (res[i] == 5 * res[i5]) {
                i5++;
            }

        }
        return res[index - 1];
    }

    public static int uglyNumber2(int index) {
        if (index == 0 || index == 1) return index;
        int[] help = new int[index];
        help[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int i = 1;
        while (i < index) {
            help[i] = Math.min(2 * help[i2], Math.min(3 * help[i3], 5 * help[i5]));
            if (help[i] == 2 * help[i2])
                i2++;
            if (help[i] == 3 * help[i3])
                i3++;
            if (help[i] == 5 * help[i5])
                i5++;
            i++;
        }
        return help[i - 1];
    }

    public static void main(String[] args) {
        System.out.println(uglyNumber2(8));
        System.out.println(new Problem50().GetUglyNumber_Solution(8));
    }
}
