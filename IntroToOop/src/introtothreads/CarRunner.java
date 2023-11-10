package introtothreads;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRunner {
    public static void main(String[] args) {
        Car car1 = new Car(12, 10);
        Car car2 = new Car(14, 16);

        List<Car> list = new ArrayList<>();
        list.add(car2);
        list.add(car1);

        Collections.sort(list);

        System.out.println(list);
    }
}
