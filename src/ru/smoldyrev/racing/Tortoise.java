package ru.smoldyrev.racing;

/**
 * Created by SBT-Smoldyrev-EI on 14.11.2018.
 */
public class Tortoise {
    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) {
            return null;
        }
        int sec = g * 3600 / (v2 - v1);
        return new int[] {sec / 3600, (sec % 3600) / 60, sec % 60};
    }
}