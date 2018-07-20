package com.epam.daos;

public class Department {
    private Integer Code_spec;
    private String Speciality_name;
    public String Speciality_description;
    public Department(){
            }
public Department(Integer Code_spec, String Speciality_name, String Speciality_description){
        this.Code_spec=Code_spec;
        this.Speciality_name=Speciality_name;
        this.Speciality_description=Speciality_description;
}

    public Integer getCode_spec() {
        return Code_spec;
    }

    public String getSpeciality_description() {
        return Speciality_description;
    }

    public String getSpeciality_name() {
        return Speciality_name;
    }

    public void setCode_spec(Integer code_spec) {
        Code_spec = code_spec;
    }

    public void setSpeciality_description(String speciality_description) {
        Speciality_description = speciality_description;
    }

    public void setSpeciality_name(String speciality_name) {
        Speciality_name = speciality_name;
    }
}
