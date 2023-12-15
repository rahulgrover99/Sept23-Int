package dependencyinversion;

public class DatabaseManager {

//    AwsDynamo awsDynamo = new AwsDynamo();

    GcpDb gcpDb = new GcpDb();

    void addStudent() {
//        awsDynamo.query();
        gcpDb.runQuery();
    }


    void removeStudent() {
//        awsDynamo.query();
        gcpDb.runQuery();
    }

    void makeConnection() {
//        awsDynamo.connect();
        gcpDb.runQuery();
    }

}
