package com.jd.validator.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-01 19:06
 */
public class Guy extends People {

    @Min(value = 10)
    private int id;

    @NotEmpty
    private String name;


    public Guy(@Min(value = 10) int id, @NotEmpty String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
