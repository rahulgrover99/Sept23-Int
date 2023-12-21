package prototype;

public class Client {

    public static void main(String[] args) {

        Registry<Student> studentRegistry = new Registry<>();
        fillRegistry(studentRegistry);

        Student sid = studentRegistry.get("april23batchStudent").clone();
        sid.setName("Sid");


        Student professionalStudent = studentRegistry.get("pro").clone();
        ((ProfessionalStudent) professionalStudent).setCompanyName("Google");


        Student collegeStudent = studentRegistry.get("college").clone();


        System.out.println("DEBUG");


    }


    public static void fillRegistry(Registry<Student> registry) {
        Student aprBatchStudent = new Student();
        aprBatchStudent.setBatchName("Academy April 23");
        aprBatchStudent.setAvgBatchPsp(89.0);

        registry.register("april23batchStudent", aprBatchStudent);

        CollegeStudent collegeStudent = new CollegeStudent();
        collegeStudent.setGradYr(2021);
        collegeStudent.setUniverity("SST");
        collegeStudent.setBatchName("Edge");
        collegeStudent.setAvgBatchPsp(79.0);

        registry.register("college", collegeStudent);

        ProfessionalStudent professionalStudent = new ProfessionalStudent();
        professionalStudent.setSalary(190000);
        professionalStudent.setCompanyName("Scaler");

        professionalStudent.setBatchName("Advanced");
        professionalStudent.setAvgBatchPsp(90.0);

        registry.register("pro", professionalStudent);





    }

}
