package ru.smoldyrev.walk;

/**
 * Created by SBT-Smoldyrev-EI on 02.11.2018.
 */
public class TenMinWalk {

    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }

        int x = 0;
        int y = 0;

        for (Character ch :
                walk) {
            switch (ch) {
                case 'n': x++; break;
                case 's': x--; break;
                case 'w': y--; break;
                case 'e': y++; break;
            }
        }
        return x == 0 && y == 0;
    }
}