package correctdependencyinversion;



// DatabaseManager depending on AwsDynamo

// Databasemanager depedning on methods defined in CloudDb interface
public class DatabaseManager {

//    AwsDynamo awsDynamo = new AwsDynamo();

//    GcpDb gcpDb = new GcpDb();

    // The class responsibility is to instantiate CloudDb type object.



    // Dependency Injection:
    // 1. No need to create objects of dependency in self.
    // 2. instead let the creator or the client pass you that dependency
    CloudDb cloudDb;

    public DatabaseManager(CloudDb cloudDb) {
        this.cloudDb = cloudDb;
    }

    void addStudent() {
//        awsDynamo.query();
//        gcpDb.runQuery();
        cloudDb.query();
    }


    void removeStudent() {
//        awsDynamo.query();
//        gcpDb.runQuery();
        cloudDb.query();
    }


    void makeConnection() {
//        awsDynamo.connect();
//        gcpDb.runQuery();
        cloudDb.connect();
    }

}
