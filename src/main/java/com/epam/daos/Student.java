package com.epam.daos;

import com.epam.annotations.Field;

import static com.epam.annotations.Operations.GET;
import static com.epam.annotations.Operations.SET;

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
    @Field(fieldName = "Code_stud", type = GET)
    public Integer getCode_stud() {
        return Code_stud;
    }
    @Field(fieldName = "Student_name", type = GET)
    public String getStudent_name() {
        return Student_name;
    }
    @Field(fieldName = "Student_middlename", type = GET)
    public String getStudent_middlename() {
        return Student_middlename;
    }
    @Field(fieldName = "Student_surname", type = GET)
    public String getStudent_surname(){
        return Student_surname;
    }
    @Field(fieldName = "Code_stud", type = SET)
    public void setCode_stud(Integer Code_stud){
        this.Code_stud=Code_stud;
    }
    @Field(fieldName = "Student_name", type = SET)
    public void setStudent_name(String Student_name){
        this.Student_name=Student_name;
    }
    @Field(fieldName = "Student_middlename", type = SET)
    public void setStudent_middlename(String Student_middlename){
        this.Student_middlename=Student_middlename;
    }
    @Field(fieldName = "Student_surname", type = SET)
    public void setStudent_surname(String Student_surname){
        this.Student_surname=Student_surname;
    }
    @Override
    public String toString() {
        return "Student [Code_stud= " + Code_stud + ", Student_name= " +Student_name+
                ", Student_middlename= " + Student_middlename + ", Student_surname= " +Student_surname+"]";
    }
}
