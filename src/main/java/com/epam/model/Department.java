package com.epam.model;

import com.epam.annotations.Field;

import static com.epam.annotations.Operations.GET;
import static com.epam.annotations.Operations.SET;

public class Department {
    private Integer Code_spec;
    private String Speciality_name;
    public String Speciality_description;

    public Department() {
    }

    public Department(Integer Code_spec, String Speciality_name, String Speciality_description) {
        this.Code_spec = Code_spec;
        this.Speciality_name = Speciality_name;
        this.Speciality_description = Speciality_description;
    }

    @Field(fieldName = "Code_spec", type = GET)
    public Integer getCode_spec() {
        return Code_spec;
    }

    @Field(fieldName = "Speciality_description", type = GET)
    public String getSpeciality_description() {
        return Speciality_description;
    }

    @Field(fieldName = "Speciality_name", type = GET)
    public String getSpeciality_name() {
        return Speciality_name;
    }

    @Field(fieldName = "Code_spec", type = SET)
    public void setCode_spec(Integer Code_spec) {
        this.Code_spec = Code_spec;
    }

    @Field(fieldName = "Speciality_description", type = SET)
    public void setSpeciality_description(String Speciality_description) {
        this.Speciality_description = Speciality_description;
    }

    @Field(fieldName = "Speciality_name", type = SET)
    public void setSpeciality_name(String Speciality_name) {
        this.Speciality_name = Speciality_name;
    }

    @Override
    public String toString() {
        return "Deparment [Code_spec= " + Code_spec + ", Speciality_name= " + Speciality_name +
                ", Speciality_description= " + Speciality_description + "]";
    }
}