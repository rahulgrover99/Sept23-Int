package intro;

import java.time.Year;
import java.util.Date;

public class Student {
    String name;
    int rollNo;
    Batch batch;
    Date dob;
    Year gradYear;

    void solveProblem() {
        System.out.println(name + " is solving a problem.");
    }

    String getBatchName() {
        System.out.println("Getting the batch name for student.");
        return batch.name;
    }
}
