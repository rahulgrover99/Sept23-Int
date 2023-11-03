package inheritance;

import java.util.List;

public class Instructor extends User{
    // Default constructor gets called. - takes in no parameters
    // and calls the default constructor of User class implicitly. WhY?
    // To initialise the values in the User class.

    // There is no default constructor available in 'inheritance.User'
    Instructor() {
        super("strongpassword");
        System.out.println("Instructor constructor gets called.");
    }

    List<String> batches;
    double avgRating;

    void scheduleClass() {
        System.out.println(id);
//        System.out.println(username);
        System.out.println("Instructor scheduled a class.");
    }
}
