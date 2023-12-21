package prototype;

public class Student {

    private String name;
    private String age;
    private String batchName;
    private double psp;
    private double avgBatchPsp;
    private int phone;
    private String email;

    Student() {}

    Student(Student other) {
        this.name = other.name;
        this.age = other.age;
        this.batchName = other.batchName;
        this.psp = other.psp;
        this.avgBatchPsp = other.avgBatchPsp;
        this.phone = other.phone;
        this.email = other.email;
    }

    public Student clone() {
        return new Student(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public double getAvgBatchPsp() {
        return avgBatchPsp;
    }

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
