package com.jd.validator.bean;

import com.jd.validator.service.ValidatorService;
import com.jd.validator.service.ValidatorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * @author: wangyingjie1
 * @version: 1.0
 * @createdate: 2017-12-05 16:45
 */
@Slf4j
public class ValidatorGuyJmeterTest extends AbstractJavaSamplerClient {

    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult sr = new SampleResult();
        sr.sampleStart();
        try {

            ValidatorService service = new ValidatorServiceImpl();

            Guy guy = getGuy();

            boolean validate = service.validate(guy);

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
        guy.setFirstName("");
        guy.setLastName("");
        guy.setIdentityCard("");
        guy.setAge(0);
        return guy;
    }

    public void teardownTest(JavaSamplerContext context) {

    }

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