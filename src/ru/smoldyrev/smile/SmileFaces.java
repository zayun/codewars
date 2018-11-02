package ru.smoldyrev.smile;

import java.util.*;

public class SmileFaces {


//    private static final Set<String> SMILE_FACES = new HashSet<>();
//    private static final Set<String> EYES = new HashSet<>(Arrays.asList(":", ";"));
//    private static final Set<String> NOSES = new HashSet<>(Arrays.asList("-", "~", ""));
//    private static final Set<String> LIPS = new HashSet<>(Arrays.asList(")", "D"));
//
//    static {
//        EYES.forEach(eye->NOSES.forEach(nose->LIPS.forEach(lip->SMILE_FACES.add(eye.concat(nose).concat(lip)))));
//    }

    public static int countSmileys(List<String> arr) {
//        return (int) arr.stream().filter(SMILE_FACES::contains).count();
        return (int) arr.stream().filter(s->s.matches("[:;][-~]?[)D]")).count();
    }
}
