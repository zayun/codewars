package ru.smoldyrev.growth;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
class Arge {

    public static int nbYear(int p0, double percent, int aug, int p) {
        // your code
        int qty = 0;
        while (p0 < p) {
            p0 += (int) (p0 * percent / 100) + aug;
            qty++;
        }
        return qty;
    }
}
