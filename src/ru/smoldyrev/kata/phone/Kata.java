package ru.smoldyrev.kata.phone;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class Kata {

    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }
}