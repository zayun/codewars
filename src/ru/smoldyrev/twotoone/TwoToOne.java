package ru.smoldyrev.twotoone;

/**
 * Created by SBT-Smoldyrev-EI on 14.11.2018.
 */
public class TwoToOne {
    public static String longest(String s1, String s2) {
        return s1.concat(s2).chars().distinct().mapToObj(c -> String.valueOf((char) c)).sorted().collect(java.util.stream.Collectors.joining());
    }
}
