package com.jd.validator.bean;

//import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-01 19:55
 */
//@Data
public class People {

    @Min(value = 1)
    @Max(value = 200)
    private int age;

    @NotBlank
    @Size(min = 1, max = 50)
    private String firstName;

    public People() {
    }

    public People(@Min(value = 1) @Max(value = 200) int age, @NotBlank @Size(min = 1, max = 50) String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
