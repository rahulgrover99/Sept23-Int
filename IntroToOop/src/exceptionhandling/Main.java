package exceptionhandling;

import interfaces.P;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

class A {
    int x = 0;
    int xA = 1;
    static void fun() {
        System.out.println('A');
    }
}

class B  extends A {

    int x = 2;

    static void fun() {
        System.out.println('B');
    }
}



public class Main {
    public static void main(String[] args) {



        A a = new B();
        System.out.println(a.x);
        System.out.println(a.xA);

        // No check enforced by compiler.
        // Because Runtime exceptions are not checked.
        try {
            System.out.println(5/1);
        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
            System.out.println("Learn division!!!");
        }


        try {
            System.out.println(demoFunction(0));
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            System.out.println("haha");
        }


    }


    static int demoFunction(int a) throws DemoExceptions {
        if (a == 0) {
            throw new DemoExceptions();
        } else {
            return a + 1;
        }

//        sjdioedfoiucn
//                cudsnicnsd
    }
}
