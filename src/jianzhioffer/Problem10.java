package jianzhioffer;
public class Problem10 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int prepre = 1;
        int pre = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = prepre + pre;
            prepre = pre;
            pre = res;
        }
        return res;
    }

}
