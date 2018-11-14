package ru.smoldyrev.prime;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SBT-Smoldyrev-EI on 09.11.2018.
 */
public class PrimeDecomp2 {

    public static String factors(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) {
            int count;
            for (count = 0; lst % fac == 0; ++count) {
                lst /= fac;
            }
            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }
        return result;
    }
}
