package productionbuilder;


public class Client {


    public static void main(String[] args) {

        Student student = Student.getBuilder()
                .setName("Rahul")
                .setUniversity("IIT")
                .setAge(21)
                .build();


        Student.Builder builder = Student.getBuilder().setAge(21);


        System.out.println("DEBUG");

    }

}
