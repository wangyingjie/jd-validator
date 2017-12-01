package com.jd.validator;

import com.jd.validator.bean.Guy;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.hibernate.validator.internal.engine.MethodValidationConfiguration;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.hibernate.validator.internal.metadata.BeanMetaDataManager;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.*;
import javax.validation.bootstrap.GenericBootstrap;
import java.lang.reflect.Field;
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


    @Test
    public void testGenericBootstrap() {
        GenericBootstrap provider = Validation.byDefaultProvider();
        Assert.assertNotNull( provider );

        Configuration<?> config = provider.configure();
        Assert.assertNotNull( config );
        Assert.assertTrue( config instanceof HibernateValidatorConfiguration);

        HibernateValidatorConfiguration hibernateConfig = (HibernateValidatorConfiguration) config;

        // Note that the configuration from the XML is not read until the
        // buildValidatorFactory() method is called.
        ValidatorFactory factory = hibernateConfig.buildValidatorFactory();
        Validator validator = factory.getValidator();

        ValidatorImpl hibernateValidatorImpl = (ValidatorImpl) validator;
        BeanMetaDataManager bmdm = findPropertyOfType( hibernateValidatorImpl, BeanMetaDataManager.class );
        MethodValidationConfiguration methodConfig = findPropertyOfType( bmdm, MethodValidationConfiguration.class );

        Assert.assertTrue( methodConfig.isAllowParallelMethodsDefineParameterConstraints() );
    }

    @IgnoreForbiddenApisErrors(reason = "Prints the stacktrace in case an exception is raised")
    private <T extends Object> T findPropertyOfType(Object subject, Class<T> clazz) {
        Field[] fields = subject.getClass().getDeclaredFields();
        for ( Field field : fields ) {
            if ( field.getType().equals( clazz ) ) {
                boolean accessible = field.isAccessible();
                try {
                    field.setAccessible( true );
                    return (T) field.get( subject );
                }
                catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                finally {
                    field.setAccessible( accessible );
                }
            }
        }
        return null;
    }

}
