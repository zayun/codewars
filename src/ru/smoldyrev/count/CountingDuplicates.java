package ru.smoldyrev.count;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        java.util.Map<Character, Integer> qtyMap = new java.util.HashMap<>();

        text.toLowerCase().chars().mapToObj(c -> (char) c).forEach(c -> {
            qtyMap.put(c, (int) text.toLowerCase().chars().mapToObj(ch -> (char) ch).filter(c::equals).count());
        });

        return (int) qtyMap.values().stream().filter(s -> s > 1).count();
    }
}
