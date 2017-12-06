package com.jd.validator.test;

import com.jd.validator.bean.Guy;
import com.jd.validator.service.ValidatorService;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-05 16:45
 */
public class ValidatorGuyJmeterTest extends AbstractJavaSamplerClient {

    private static final Logger log = LoggerFactory.getLogger(ValidatorGuyJmeterTest.class);

    private static ClassPathXmlApplicationContext appContext =
            new ClassPathXmlApplicationContext("classpath:/spring-config.xml");

    private static ValidatorService validatorService =
            appContext.getBean("validatorService", ValidatorService.class);

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult sr = new SampleResult();
        sr.sampleStart();
        try {

            Guy guy = getGuy();

            boolean validate = validatorService.validate(guy);

            if (validate) {
                sr.setSuccessful(true);
            } else {
                sr.setSuccessful(false);
                log.info("validate is error! guy={}", guy);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("validate run test is exception!", e);
            sr.setSuccessful(false);
        } finally {
            sr.sampleEnd();
        }
        return sr;
    }

    private Guy getGuy() {
        Guy guy = new Guy();
        guy.setId(0);
        guy.setHeight(0L);
        guy.setWeight(0L);
        guy.setLastName("");
        guy.setIdentityCard("");
        guy.setAge(0);
        guy.setFirstName("");

       return guy;
    }

    @Override
    public void teardownTest(JavaSamplerContext context) {

    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments arg = new Arguments();
        //arg.setThreadContext();
        return arg;
    }

    public static void main(String[] args) {
        ValidatorGuyJmeterTest validateGuy = new ValidatorGuyJmeterTest();
        Arguments arg = validateGuy.getDefaultParameters();
        JavaSamplerContext context = new JavaSamplerContext(arg);
        validateGuy.setupTest(context);
        validateGuy.runTest(context);
        validateGuy.teardownTest(context);
    }

}