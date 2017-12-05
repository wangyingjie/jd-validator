package com.jd.validator.service;

import com.jd.validator.bean.People;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-05 16:50
 */
public interface ValidatorService {

    /**
     * 验证对象属性
     *
     * @param people
     * @return
     */
    boolean validate(People people);

}
