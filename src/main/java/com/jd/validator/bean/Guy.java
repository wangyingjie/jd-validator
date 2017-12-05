package com.jd.validator.bean;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-01 19:06
 */
@Data
public class Guy extends People {

    // 最大的整数部分长度  最大小数部分输入长度
    @Digits(integer = 10, fraction = 3)
    private int id;

    @Positive
    private long height;

    @Positive
    private long weight;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String lastName;

    @NotNull
    @Size(min = 16, max = 20)
    private String identityCard;

    public Guy() {
    }

    public Guy(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }


}
