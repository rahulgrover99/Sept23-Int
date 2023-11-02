package defaultconstructor;

import intro.Batch;

public class Main {
    public static void main(String[] args) {

        Batch batch = new Batch();
        batch.name = "Advanced batch";

        Student student = new Student("Rahul", 12, batch);
        System.out.println("DEBUG");
        System.out.println(student);

        Student other = new Student(student);
        System.out.println(other);

        student.batch.name = "Intermediate batch";

        System.out.println("DEBUG");
    }
}
