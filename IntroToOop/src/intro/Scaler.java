package intro;

import java.time.Year;
import java.util.Date;

public class Scaler {
    public static void main(String[] args) {

        Batch batchObj = new Batch();
        batchObj.name = "LLD Intermediate";
        batchObj.instructorName = "Rahul";

        Student himadri = new Student();
        himadri.name = "Himadri";
        himadri.batch = batchObj;
        himadri.solveProblem();


        Student sama = new Student();
        sama.name = "Sama";
        sama.batch = batchObj;
        sama.solveProblem();




        batchObj.name = "LLD Advanced";


        System.out.println(sama);






    }
}
