package productionbuilder;

public class Student {

    private String name;
    private int age;
    private boolean isStudent;
    private String university;
    private double psp;
    private int phone;
    private String email;

    private Student(Builder builder) {
        this.name = builder.getName();
        this.age = builder.age;
        this.isStudent = builder.isStudent;
        this.university = builder.getUniversity();
        this.psp = builder.getPsp();
    }


    public static Builder getBuilder() {
        return new Builder();
    }

    static class Builder {
        private String name;
        private int age;
        private boolean isStudent;
        private String university;
        private double psp;
        private int phone;
        private String email;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public boolean isStudent() {
            return isStudent;
        }

        public Builder setStudent(boolean student) {
            isStudent = student;
            return this;
        }

        public String getUniversity() {
            return university;
        }

        public Builder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public int getPhone() {
            return phone;
        }

        public Builder setPhone(int phone) {
            this.phone = phone;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }


        public Student build() {
            return new Student(this);
        }
    }



}
