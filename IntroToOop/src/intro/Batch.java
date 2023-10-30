package intro;

public class Batch {

    String name;
    String instructorName;


    void addStudent() {
        System.out.println("adding a student to" + name);
    }

    void changeInstructor(String name) {
        instructorName = name;
    }
}
