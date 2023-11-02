package intro;

public class Batch {

    public String name;
    String instructorName;

    public Batch(Batch b) {
        this.name = b.name;
        this.instructorName = b.instructorName;
    }

    public Batch() {

    }

    void addStudent() {
        System.out.println("adding a student to" + name);
    }

    void changeInstructor(String name) {
        instructorName = name;
    }

}
