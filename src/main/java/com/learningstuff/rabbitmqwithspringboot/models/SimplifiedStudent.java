package com.learningstuff.rabbitmqwithspringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimplifiedStudent {

    private String name;
    private String subject;
//    private double gpa;

}
