package com.epam.daos;

public class Student {
    private Integer Code_stud;
    private String Student_middlename;
    private String Student_name;
    private String Student_surname;

    public Student() {
    }

    public Student(Integer Code_stud, String Student_name,
                   String Student_surname, String Student_middlename) {
        this.Code_stud = Code_stud;
        this.Student_name = Student_name;
        this.Student_surname = Student_surname;
        this.Student_middlename = Student_middlename;
    }

    public Integer getCode_stud() {
        return Code_stud;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public String getStudent_middlename() {
        return Student_middlename;
    }
    public String getStudent_surname(){
        return Student_surname;
    }
    public void setCode_stud(Integer Code_stud){
        this.Code_stud=Code_stud;
    }
    public void setStudent_name(String Student_name){
        this.Student_name=Student_name;
    }
    public void setStudent_middlename(String Student_middlename){
        this.Student_middlename=Student_middlename;
    }
    public void setStudent_surname(String Student_surname){
        this.Student_surname=Student_surname;
    }
}
