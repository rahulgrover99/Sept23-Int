package correctdependencyinversion;

public class GcpDb implements CloudDb{


    public void connect() {
        System.out.println("Making connection to GCP");
    }

    public void query() {
        System.out.println("Running query in GCP.");
    }

}
