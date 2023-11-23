package generics;

import java.util.*;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        ObjectPair op = new ObjectPair(1, "Pair");

        System.out.println(op.id);
        System.out.println((op.name));

        String s= "Rahul";
        System.out.println(s.length());

        GenericPair<Integer ,String> gp = new GenericPair<>(1, "Pair");

        System.out.println(gp.first + 2);
        System.out.println(gp.second.length());

        printSomething(gp);
        printSomething(op);
        printSomething(1);
        printSomething("Rahul");

        List<Integer> integers = List.of(1, 2, 3, 4, 7);
        List<Double> doubles = List.of(1.2, 3.1, 4.1, 5.1);
        List<String> strings = List.of("Amit", "Ashwini", "Puja", "Animesh");

        // calculateAverage(strings) --> error
        // calculateAverage(integers) --> average as double value.


        // Required type:
        //List
        //<Integer>
        //Provided:
        //List
        //<Double>

//        List<Integer> can't be represented as List<Number>
        printSomething(calculateAverage(doubles));
        printSomething(calculateAverage(integers));
//        printSomething(calculateAverage(strings));

        List<Number> numbers = List.of(1, 2, 3);

        printSuperInteger(integers);
        printSuperInteger(numbers);
//        printSuperInteger(doubles);
//        printSuperInteger(strings);

//        System.out.println(getSomething(6));

    }

    private static <T> void printSomething(T obj) {
        System.out.println(obj);
    }


    // Write a method that works on Numeric types, and calculate average of numbers
    // passed to it.

    // ? -> Wildcard
    static Double calculateAverage(List<? extends Number> numbers) {
        Double ans = 0.0;
        for (Number i: numbers) {
            ans += i.doubleValue();
        }
        return ans/numbers.size();
    }

    static <T, T2> T2 getSomething(T t) {
        // Explicit type casting
        return (T2)t;
    }

    // super accepts any thing that is a parent of Integer
    static void printSuperInteger(List<? super Integer> x) {
        for (Object i: x) {
            System.out.println(i);
        }
    }



}
