package builder;

public class NewStudent {

    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setName("Rahul");
        studentBuilder.setUniversity("IIT");


        // Validated object
        Student st = new Student(studentBuilder);

        st = studentBuilder.build();

        StudentBuilder studentBuilder2 = Student.getBuilder();


//        Student student = Student.getBuilder().
//                setName().
//                setAge().
//                setUniveristy().
//                build();

    }
}
