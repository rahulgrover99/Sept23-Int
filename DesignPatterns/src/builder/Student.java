package builder;

import java.util.Map;

public class Student {


    // Student class can point to it's builder.
    public static StudentBuilder getBuilder() {
        return new StudentBuilder();
    }

    String name;
    int age;
    boolean isStudent;
    String university;
    double psp;
    int phone;
    String email;
    String batchName;


    // Step 1: Take all the parameters from the client. Example: In some JSON format.
    // Step 2: Call the constructor with the parameters passed.
    // -- Validation checks at one place.
    // -- Extensible

    // Cons:
    // 1. No type checks.


    Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.getName();
        this.age = studentBuilder.getAge();


        // Before initialising student object -> all validations here.
        if (age < 0) throw new RuntimeException();
        if (psp < 0 || psp > 100) throw new RuntimeException();

//        dwdhiushniucsixcisncnins
    }

    Student(Map<String, Object> params) {
        if (params.containsKey("Name")) {

            // Explicit type conversion.
            // No compile type safety.
            // Possibility of params mistyped
            // nmae
            this.name = (String) params.get("Name");
        }
        if (age < 0) throw new RuntimeException();
        if (psp < 0 || psp > 100) throw new RuntimeException();

//        if (age > psp) throw
    }

    Student(String name, int age, String university) {
        if (age < 0) throw new RuntimeException();
        // all other validation checks.
        this.name = name;
        this.age = age;
        this.university = university;
    }

    Student(String name, double psp, String batchName) {
        if (psp < 0 || psp > 100) throw new RuntimeException();
        // all other validation checks.
        this.name = name;
        this.psp = psp;
        this.batchName = batchName;
    }

}
