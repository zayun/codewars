package ru.smoldyrev.racing;

/**
 * Created by SBT-Smoldyrev-EI on 14.11.2018.
 */
public class Tortoise {
    public static int[] race(int v1, int v2, int g) {

        int totalSec = 0;

        double v1d = (double) v1/3600;
        double v2d = (double) v2/3600;
        double gg = g;
        while (gg > 0) {
            totalSec++;
            gg = gg + v1d - v2d;
        }

        System.out.println(totalSec);
        return new int[0];
    }
}