package correctdependencyinversion;

public class AwsDynamo implements CloudDb {


    public void connect() {
        System.out.println("Connecting to AWS");
//        aws.makeConnection();
    }

    public void query() {
        System.out.println("Running query.");
    }

}
