//package com.jd.validator;
//
//import org.apache.jmeter.config.Arguments;
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
///**
// * @author: wangyingjie1
// * @version: 1.0
// * @createdate: 2017-12-05 16:12
// */
//public class ValidatorJmeterTest extends AbstractJavaSamplerClient {
//
////    static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/spring-config-jsf.xml");
////    static JmiStockSoaService jmiStockSoaService = (JmiStockSoaService) appContext.getBean("jmiStockSoaService");
//
//    public void setupTest(JavaSamplerContext context) {
//    }
//
//    public SampleResult runTest(JavaSamplerContext arg0) {
//        SampleResult sr = new SampleResult();
//        sr.sampleStart();
//
//        String jSkuId = arg0.getParameter("jSkuId01");
//        String CalendarId = arg0.getParameter("CalendarId01");
//        String jWareId = arg0.getParameter("jWareId01");
//
//        String uuid1 = UUID.randomUUID().toString();
//        String uuid2 = UUID.randomUUID().toString();
//        JmiStockDetailParam jmiStockDetailParam = new JmiStockDetailParam();
//        jmiStockDetailParam.setjSkuId(Long.valueOf(Long.parseLong(jSkuId)));
//        jmiStockDetailParam.setQuantity(Integer.valueOf(1));
//        jmiStockDetailParam.setCalendarId(Long.valueOf(Long.parseLong(CalendarId)));
//        List jmiStockDetailParams = new ArrayList();
//        jmiStockDetailParams.add(jmiStockDetailParam);
//
//        JmiStockPreLockRequest jmiStockPreLockRequest = new JmiStockPreLockRequest();
//        jmiStockPreLockRequest.setjWareId(Long.valueOf(Long.parseLong(jWareId)));
//        jmiStockPreLockRequest.setJmiStockDetailParams(jmiStockDetailParams);
//        jmiStockPreLockRequest.setTxNum(uuid1);
//
//        jmiStockPreLockRequest.setOpIp("192.168.0.1");
//        jmiStockPreLockRequest.setOpName("dsy");
//        jmiStockPreLockRequest.setPort("3389");
//        jmiStockPreLockRequest.setSourceId(Integer.valueOf(Integer.parseInt("123456")));
//        jmiStockPreLockRequest.setUuid(uuid2);
//        try {
//            JmiClientResponse jmiClientResponse = jmiStockSoaService.preLockStock(jmiStockPreLockRequest);
//
//            if (jmiClientResponse.getCode() == 100) {
//                sr.setSuccessful(true);
//            } else {
//                sr.setSuccessful(false);
//                System.out.println(jmiClientResponse.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            sr.setSuccessful(false);
//        } finally {
//            sr.sampleEnd();
//        }
//        return sr;
//    }
//
//    public void teardownTest(JavaSamplerContext context) {
//
//    }
//
//    public Arguments getDefaultParameters() {
//        Arguments arg = new Arguments();
//        arg.addArgument("jSkuId01", "200100150106");
//        arg.addArgument("CalendarId01", "53");
//        arg.addArgument("jWareId01", "200100033803");
//        return arg;
//    }
//
//    public static void main(String[] args) {
////        JmiStockSoaService_01preLockStock jmiStockSoaService_01preLockStock = new JmiStockSoaService_01preLockStock();
////        Arguments arg = jmiStockSoaService_01preLockStock.getDefaultParameters();
////        JavaSamplerContext context = new JavaSamplerContext(arg);
////        jmiStockSoaService_01preLockStock.setupTest(context);
////        jmiStockSoaService_01preLockStock.runTest(context);
////        jmiStockSoaService_01preLockStock.teardownTest(context);
//    }
//}
