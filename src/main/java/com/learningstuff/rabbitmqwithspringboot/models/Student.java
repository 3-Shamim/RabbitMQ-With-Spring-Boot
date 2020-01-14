package com.learningstuff.rabbitmqwithspringboot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১৪/১/২০
 * Time: ১১:৫২ AM
 * Email: mdshamim723@gmail.com
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable {

    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "subject")
    private String subject;
    @JsonProperty(value = "gpa")
    private double gpa;

}
