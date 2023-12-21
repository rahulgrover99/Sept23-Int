package prototype;

public class CollegeStudent extends Student{

    private String univerity;
    private int gradYr;

    CollegeStudent() {}

    public CollegeStudent(CollegeStudent other) {
        super(other);
        this.univerity = other.univerity;
        this.gradYr = other.gradYr;
    }

    public CollegeStudent clone() {
        return new CollegeStudent(this);
    }

    public String getUniverity() {
        return univerity;
    }

    public void setUniverity(String univerity) {
        this.univerity = univerity;
    }

    public int getGradYr() {
        return gradYr;
    }

    public void setGradYr(int gradYr) {
        this.gradYr = gradYr;
    }
}
