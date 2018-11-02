package ru.smoldyrev.digitalroot;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class DRoot {
    public static int digital_root(int n) {
        int res = String.valueOf(n).chars().map(Character::getNumericValue).sum();
        return res < 10 ? res : digital_root(res);
    }
}
