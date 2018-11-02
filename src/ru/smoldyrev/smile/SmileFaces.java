package ru.smoldyrev.smile;

import java.util.*;

public class SmileFaces {

    public static int countSmileys(List<String> arr) {
        return (int) arr.stream().filter(s->s.matches("[:;][-~]?[)D]")).count();
    }
}
