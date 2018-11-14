package ru.smoldyrev.sudoku;

import java.util.Arrays;

public class SudokuValidator {

    public static boolean check(int[][] sudoku) {
        //line check
        for (int i = 0; i < sudoku.length; i++) {
            int[] vert = new int[sudoku.length];
            for (int j = 0; j < sudoku[i].length; j++) {
                vert[j] = sudoku[j][i];
            }
            if (!isValidArr(vert)) {
                return false;
            }
        }

        //square check
        for (int i = 0; i < sudoku.length; i+=3) {
            for (int j = 0; j <= 6; j+=3) {
                if (!isValidArr(getSquare(sudoku, i, 0))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidArr(int[] arr) {
        return java.util.Arrays.stream(arr).filter(a -> a == 0).count() == 0 && java.util.Arrays.stream(arr).distinct().count() == arr.length;
    }

    public static int[] getSquare(int[][] sudoku, int x, int y) {
        int[] res = new int[9];
        int qty = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                res[qty++] = sudoku[i][j];
            }
        }
        return res;
    }
}