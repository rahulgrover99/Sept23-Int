package prototype;

public class ProfessionalStudent extends Student {
    private String companyName;
    private int salary;

    ProfessionalStudent() {}

    ProfessionalStudent(ProfessionalStudent other) {
        super(other);
        this.salary = other.salary;
        this.companyName = other.companyName;
    }

    public ProfessionalStudent clone() {
        return new ProfessionalStudent(this);
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
