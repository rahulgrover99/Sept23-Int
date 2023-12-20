package builder;

public class SalesClient {
    public static void main(String[] args) {

//        Student student = new Student();
//        student.age = 12;
//        student.name = "Raman";
//        student.university = "NIT Jalandhar";


        Student student = new Student("Raman", 21, "IIT");



        // Problem with above approach -> validation checks can only
        // be run after that object is created.

        // Name, University, Age, grad yr

        // Age < 0

        // Grad yr < 2023
//        grad yr > date of birth

    }
}
