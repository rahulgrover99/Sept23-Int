package lambdaAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{

    public static void main(String[] args) {
        ThreadRunner tr = new ThreadRunner();
        Thread t = new Thread(tr);
        t.start();

        Runnable r =new Runnable(){

            @Override
            public void run() {
                System.out.println("I am in a thread!");
            }
        };

        Thread t1 = new Thread(r);
        t1.start();

        Calculator c = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }

            @Override
            public int sub(int a, int b) {
                return a-b;
            }
        };

        c.add(2,3);
        c.sub(4,5);


        // Functional Interfaces: are those interfaces
        // which have only single abstract method

        // @FunctionalInterface annotation makes sure that there is only 1 SAM (single abstract method) in it.

        //Whenever we are using a functional interface in a annonymous manner,
        // we can use lambdas.
        // (a,b,c) -> { body of lambda}

        // In annonymous manner
        Runnable r1 =new Runnable(){

            @Override
            public void run() {
                System.out.println("I am in a thread!");
            }
        };


        // Lambda way
        Runnable r2 =() -> {
                System.out.println("I am in a thread!");
        };

        // This is more concise
        Runnable r3 = () -> System.out.println("I am in a thread! R3");
        Thread t3 = new Thread(r3);
        t3.start();

        Custom custom = (a, b) -> {
                int c1 = a*b;
                System.out.println(c1);
                return c1;
        };

        Custom custom1 = (a, b) -> a*b;
        int a = custom1.doSomething(4,5);

        Callable<String> callable = () -> "This is the thing, that I want to return";
        Callable<String> callable1 = () -> {
            System.out.println("I am in thread: " + Thread.currentThread());
            return "This is the thing, that I want to return";
        };

        // Streams: a concise and a powerful way of processing data
        // It heavily uses lambda.
        // A stream will connect to a datasource: a database, a collection or an array
        List<Integer> list = List.of(6,5,4,3,2,1);
        Stream<Integer> s1 = list.stream();

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> s2 = Arrays.stream(arr);

        Stream<Integer> s3 = Stream.of(1, 2, 4, 5, 6, 7, 8, 9, 10);

        s1 = s1.filter(x ->  x % 2 == 0);

        // There are 2 types of operations in streams:
        //1. Intermediate operations: filter
        //2. Terminal operations
        s1.forEach(y -> System.out.println("y:" + y));

        // Once a stream goes thru a terminal operation , it cannot be used again
        //s1.forEach(y -> System.out.println("y1:" +y));

        list.stream().forEach((y) -> System.out.println("y1:" +y));

        System.out.println("--------------");
        list.stream()
                .filter(x -> x%2 == 0)
                .sorted()
                .forEach(x -> System.out.println(x));
        System.out.println("---------");
        list.stream()
                .filter(x->x%2==0)
                .map(x -> x*x)
                .map(x -> "Hi "+ x)
                .forEach(x-> System.out.println(x));

        System.out.println("---------");
        list.stream()
                .filter(x->{
                    System.out.println("Filtering x:" + x);
                    return x%2==0;
                })
                .map(x -> {
                    System.out.println("Squaring x: "+x);
                    return x*x;
                })
                .map(x -> {
                    System.out.println("Convertign to string: " + x);
                   return "Hi "+ x;
                })
                .forEach(x-> System.out.println(x));

        // What we expected
        /*
        First a for will be executed which will do all the filtering
        Then a for will be executed ehich will do squarring
        Then a for will be executed which will do convertign to string
        Then a for will be executed for  printing

        What actually I can do/happens
        for(int i: list){
            if(i %2 ==0){
                int j = i*i;
                String s = "Hi" + j;
                sout(s);
            }
        }
         */
        System.out.println(list);

        List<String> l1 = list.stream()
                .filter(x->x%2==0)
                .map(x -> x*x)
                .map(x -> "Hi "+ x)
                .collect(Collectors.toList());
        System.out.println(l1);


        /*
        Find below a list of integers. Iterate over it and print the square of each number.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
         */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().forEach(x -> System.out.println(x*x));

//        Find below a list of integers. Iterate over it and print every even number.
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers1.stream().filter(x -> x %2 ==0)
                .forEach(x -> System.out.println(x));

        //For the list of integers, find all the even numbers.
        // Then, iterate over the even numbers and print each number.
        List<Integer> number2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Enter your code here

//       // For a list of integers, return a list of the squares of each number.
        List<Integer> numbers3 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers3 = numbers3.stream().map(x -> x*x)
                .collect(Collectors.toList());


        //For a list of strings, return a list of the length of each string.

        List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
        List<Integer> size = names.stream()
                .map(x -> x.length())
                .collect(Collectors.toList());
        System.out.println(size);

    }
}

interface Custom{
    public int doSomething(int a, int b);
}