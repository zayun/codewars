package ru.smoldyrev.smile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmileFaces1 {


    private static final Set<String> SMILE_FACES = new HashSet<>();
    private static final Set<String> EYES = new HashSet<>(Arrays.asList(":", ";"));
    private static final Set<String> NOSES = new HashSet<>(Arrays.asList("-", "~", ""));
    private static final Set<String> LIPS = new HashSet<>(Arrays.asList(")", "D"));

    static {
        EYES.forEach(eye->NOSES.forEach(nose->LIPS.forEach(lip->SMILE_FACES.add(eye.concat(nose).concat(lip)))));
    }

    public static int countSmileys(List<String> arr) {
        return (int) arr.stream().filter(SMILE_FACES::contains).count();
    }
}
