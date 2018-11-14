package ru.smoldyrev.prime;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by SBT-Smoldyrev-EI on 09.11.2018.
 */
public class PrimeDecomp {

    public static String factors(int n) {
        List<Integer> arr = prime(n);
        return arr.stream()
                .distinct()
                .map(i -> {
                    int qty = (int) arr.stream().filter(i::equals).count();
                    return qty > 1 ? String.format("(%d**%d)", i, qty) : String.format("(%d)", i);
                })
                .collect(Collectors.joining());
    }

    public static List<Integer> prime(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; n != 1; i++) {
            if (isPrime(n)) {
                list.add(n);
                break;
            } else if (isPrime(i) && (n % i) == 0) {
                list.add(i);
                n = n / i;
                i = 1;
            }
        }
        return list;
    }


    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
