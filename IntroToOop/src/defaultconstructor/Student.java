package defaultconstructor;

import intro.Batch;

public class Student {
    private String name;
    private int age = 21;
    boolean isPlaced;
    Batch batch;

     Student(String name, int age, Batch batch) {
        this.name =  name;
        this.age = age;
        this.batch = batch;
        System.out.println(this);
    }

    // Copy Constructor
    Student(Student other) {
         this.name = other.name;
         this.age = other.age;
         this.isPlaced = other.isPlaced;
         this.batch = new Batch(other.batch);
    }


}
