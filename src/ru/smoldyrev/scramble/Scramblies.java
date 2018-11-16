package ru.smoldyrev.scramble;

/**
 * Created by SBT-Smoldyrev-EI on 15.11.2018.
 */
public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        return str2.chars().distinct()
                .allMatch(s2 -> str1.chars().filter(s1 -> s1 == s2).count() >= str2.chars().filter(s1 -> s1 == s2).count());
    }
}