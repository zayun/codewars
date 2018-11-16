package ru.smoldyrev.jp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SBT-Smoldyrev-EI on 15.11.2018.
 */
public class Josephus {

    public static <T> int rec(final List<T> items, final int k, int index, final List<T> killedItems) {
        for (; index < items.size(); index += k) {
            killedItems.add(items.get(index));
            items.set(index, null);
        }
        return index > items.size() - 1 ? index - items.size() : index;
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        int startIndex = k - 1;
        List<T> killedItems = new ArrayList<>(items.size());
        while (!items.isEmpty()) {
            startIndex = rec(items, k, startIndex, killedItems);
            items.removeIf(java.util.Objects::isNull);
        }
        return killedItems;
    }
}