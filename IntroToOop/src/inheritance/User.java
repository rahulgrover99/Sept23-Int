package inheritance;

public class User {
    String username;
    int id;

    private String password;

//    User() {
//        System.out.println("User constructor gets called.");
//    }

    User(String password) {
        this.password = password;
        System.out.println("Parameter User constructor;");
    }

    void login() {
        System.out.println("The user tried to login.");
    }
}
