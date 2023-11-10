package introtothreads;

public class Car implements Comparable<Car> {

    Integer price;
    Integer speed;

    public Car(Integer price, Integer speed) {
        this.price = price;
        this.speed = speed;
    }

    @Override
    public int compareTo(Car o) {
        return this.price.compareTo(o.price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", speed=" + speed +
                '}';
    }
}
