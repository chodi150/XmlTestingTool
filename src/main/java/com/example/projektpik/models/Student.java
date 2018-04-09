package com.example.projektpik.models;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;



@XmlRootElement(name = "student")
public class Student implements Serializable
{
    @XmlElement(name = "name")
    public String name;
    @XmlElement(name = "surname")
    public String surname;


    public void setName(String name) {
        this.name = name;
    }



    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }

    @XmlElement(name = "sex")
    public String sex;

}
