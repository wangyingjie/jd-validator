package com.jd.validator.service;

import com.jd.validator.bean.People;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-05 16:38
 */
public class ValidatorServiceImpl implements ValidatorService {

    private Validator validator;

    @Override
    public boolean validate(People people) {

        validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .buildValidatorFactory()
                .getValidator();

        Set<ConstraintViolation<People>> constraintViolationSet = validator.validate(people);

        constraintViolationSet.stream().forEach(System.out::println);

        return constraintViolationSet != null || constraintViolationSet.size() != 1;
    }
}
