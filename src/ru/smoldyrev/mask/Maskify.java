package ru.smoldyrev.mask;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class Maskify {

    public static String maskify(String str) {
        final int[] i = {0};
        return str.chars()
                .mapToObj(c -> Character.toString((char) c))
                .map(c -> i[0]++ < str.length() - 4 ? "#" : c)
                .collect(java.util.stream.Collectors.joining(""));
    }
}
