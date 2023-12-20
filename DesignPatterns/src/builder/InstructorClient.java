package builder;

public class InstructorClient {

    public static void main(String[] args) {
        // Create Student object with just batch name, psp, name;

        // psp -> [0,100]
        // batch name -> should match regex

        // This is not very readable.
        // Parameter passing is error prone.

        // We might have to create a number of constructors depending on use case.

        // Also might be possible to be unable to create constructor of required type

        Student student = new Student("Raman", 90.0, "Academy Sept23 Intermediate");
    }
}
