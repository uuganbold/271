package edu;
//\#2 DONE
public class GraduateStudent extends Student{

    private String major;
    private String degreeName;

    public GraduateStudent(String name, int age,String major, String degreeName) {
        super(name, age);
        this.major = major;
        this.degreeName = degreeName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getMajor() {
        return major;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public boolean equals(GraduateStudent s1){
        if(name == s1.name && age == s1.age && major == s1.major && degreeName == s1.getDegreeName())
            return true;
        else
            return false;

    }

}
