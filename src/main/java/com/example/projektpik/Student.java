package com.example.projektpik;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Piotr on 06.04.2018.
 */
@Data
public class Student implements Serializable
{
    String name;
    String surname;
    List<String> hobbies;
    String sex;
}
