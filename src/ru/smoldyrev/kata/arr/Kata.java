package ru.smoldyrev.kata.arr;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class Kata {

    public static int findEvenIndex(int[] arr) {
        int lsum = 0;
        for (int i = 0; i < arr.length; i++) {
            lsum += arr[i];
            int rsum = 0;
            for (int j = arr.length - 1; j >= i; j--) {
                rsum+=arr[j];
            }
            if (lsum == rsum) {
                return i;
            }
        }
        return -1;
    }
}