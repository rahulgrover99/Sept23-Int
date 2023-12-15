package dependencyinversion;

public class GcpDb {


    public void makeConnection() {
        System.out.println("Making connection to GCP");
    }

    public void runQuery() {
        System.out.println("Running query in GCP.");
    }

}
