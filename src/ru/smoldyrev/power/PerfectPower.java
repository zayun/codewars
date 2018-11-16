package ru.smoldyrev.power;

/**
 * Created by SBT-Smoldyrev-EI on 15.11.2018.
 */
public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        for (int i = 2; i < Integer.MAX_VALUE && pow(i, 2) <= n; i++) {
            for (int j = 2; j < Integer.MAX_VALUE; j++) {
                int power = pow(i, j);
                if (power > n || power == 0) {
                    break;
                }
                if (power == n) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int pow(int dig, int power) {
        if (power == 0) {
            return 1;
        }
        if (power % 2 == 1) {
            return pow(dig, power - 1) * dig;
        } else {
            int b = pow(dig, power / 2);
            return b * b;
        }
    }
}