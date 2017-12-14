package com.jd.validator.bean;

import javax.validation.constraints.*;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-01 19:06
 */
//@Data
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

    private Guy guy;

    public Guy() {
    }

    public Guy(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
}
