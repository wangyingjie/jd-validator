package com.jd.validator;

import com.jd.validator.bean.Guy;
import org.hibernate.validator.HibernateValidator;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-01 19:07
 */
public class ValidatorFactoryTest {

    @Test
    public void testValidate() {
        Validator validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .buildValidatorFactory()
                .getValidator();

        Guy guy = new Guy(1, null);

        Set<ConstraintViolation<Guy>> constraintViolations = validator.validate(guy);

        assertEquals(2, constraintViolations.size());
    }


    @Test
    public void testValidateFailFast() {
        Validator validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();

        Guy guy = new Guy(1, null);

        Set<ConstraintViolation<Guy>> constraintViolations = validator.validate(guy);

        assertEquals(1, constraintViolations.size());
    }


}
