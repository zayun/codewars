package ru.smoldyrev.square;

public class SquareDigit {

    public int squareDigits(int n) {

        return Integer.parseInt(String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .map(d -> d * d)
                .mapToObj(String::valueOf)
                .collect(java.util.stream.Collectors.joining("")));

    }

}
