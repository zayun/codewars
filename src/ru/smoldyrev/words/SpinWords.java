package ru.smoldyrev.words;


/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class SpinWords {

    public String spinWords(String sentence) {
        return java.util.Arrays.stream(sentence.split(" "))
                .map(str -> str.length() > 5 ? new StringBuilder(str).reverse() : str)
                .collect(java.util.stream.Collectors.joining(" "));
    }
}