package jianzhioffer;

public class Problem16 {
    public double Power(double base, int exponent) {
        if (Math.abs(base - 0.0) < 1e-6) return 0;
        if (exponent == -1) return 1 / base;
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        return  Power(base, exponent / 2) *
                Power(base, exponent / 2) *
                Power(base, exponent % 2);
    }


}
