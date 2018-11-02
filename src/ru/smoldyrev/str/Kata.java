package ru.smoldyrev.str;

import java.util.Arrays;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class Kata {
    public static int findShort(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(String::length)
                .min().orElse(0);
    }
}
