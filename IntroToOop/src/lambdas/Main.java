package lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MathsOperation add = (a, b) -> a + b;

        MathsOperation multiply = (a, b) -> a * b;

        MathsOperation divide = new MathsOperation() {
            @Override
            public int operate(int a, int b) {
                return a/b;
            }
        };

        System.out.println(add.operate(5, 6));
        System.out.println(multiply. operate(5, 6));
        System.out.println(divide.operate(10, 2));


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        Consumer<Integer> integerConsumer = (a) -> System.out.println(a);


        list.forEach((a) -> System.out.println(a * 2));
//
//        list.forEach((a) -> a.getName());

//        for (int i = 0; i < 3; i++) {
//            System.out.println(list.get(i) * 2);
//        }


        Predicate<Integer> evenFilter = (a) -> a % 2 == 0;

        BiPredicate<Integer, String> biPredicate = (a, b) -> a > 0 && b.length() > 5;

        list.removeIf((a) -> a % 2 == 0);

        System.out.println(list);


        Map<String, Integer> mp = new HashMap<>();
        mp.put("Rahul", 190);
        mp.put("Sham", 200);

        Function<String, Integer> function = (a) -> a.length();

        System.out.println(mp.computeIfAbsent("Rahul", function));
        System.out.println(mp.computeIfAbsent("Sham", function));
        System.out.println(mp.computeIfAbsent("X", (a) -> a.length()));

        System.out.println(mp);

        list.stream().forEach((a) -> System.out.println(a));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 1. Printing squares
        numbers.stream().forEach(a -> System.out.print(a * a));

        System.out.println(numbers.stream().map(a -> a * a).toList());

        numbers.stream().filter(a -> a % 2 == 0).forEach(a -> System.out.println(a));


        System.out.println(numbers.stream().reduce(0, (a, b) -> a + b));


        System.out.println(numbers.stream().sorted((a, b) -> b - a).findFirst());


        List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");

        System.out.println(names.stream().map(a -> a.length()).filter(a -> a > 5).toList());
    }
}


