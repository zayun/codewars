package ru.smoldyrev.order;

public class Order {

    public static void main(String[] args) {
        // write your code here
        String str = "is2 Thi1s T4est 3a";
        System.out.println(order(str));
    }

    public static String order(String words) {

        return String.join(" ", java.util.Arrays.stream(words.split(" "))
                .filter(s -> !s.replaceAll("[\\D]", "").isEmpty())
                .sorted((o1, o2) -> {
                    String o1str = o1.replaceAll("[\\D]", "");
                    String o2str = o2.replaceAll("[\\D]", "");
                    return Integer.valueOf(o1str).compareTo(Integer.valueOf(o2str));
                }).collect(java.util.stream.Collectors.toList()));

    }
}
