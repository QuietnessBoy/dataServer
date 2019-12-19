//package com.services.data;
//
//import com.robert.vesta.service.intf.IdService;
//import com.services.data.model.LegalPerson;
//import com.services.data.model.WifiInfo;
//import com.services.data.service.LegalPersonService;
//import com.services.data.service.WifiInfoService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @ProjectName yizhuangsmartcity
// * @Package com.services.data
// * @ClassName GenTestData
// * @Description TODO
// * @Company HaoBo
// * @Author wangw
// * @Date 2019/12/4 0004 14:33
// * @UpdateUser
// * @UpdateDate
// * @UpdateRemark
// * @Version 1.0.0
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class GenTestData {
//
//    @Autowired
//    private LegalPersonService legalPersonService;
//
//    @Autowired
//    private WifiInfoService wifiInfoService;
//
//    private IdService idService;
//
//    public GenTestData() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext(
//                "spring/vesta-rest-main.xml");
//        idService = (IdService) ac.getBean("idService");
//    }
//
//    @Test
//    public void gen(){
//        LegalPerson legalPerson = new LegalPerson();
//
//        for (int i = 0; i < 20; i++) {
//            legalPerson.setOrgCode(idService.genId());
//            legalPerson.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
//            legalPerson.setBusinessScope("国产档案"+i);
//            legalPerson.setEcnomicCodeName("测试经济类型名称"+i);
//            legalPerson.setLegalPerson("测试人"+i);
//            legalPerson.setOrgName("测试公司名称"+i);
//            legalPerson.setOrgTypeCode(String.valueOf(i));
//            legalPerson.setOrgTypeCodeName("测试类型名称"+i);
//            legalPerson.setSwjgzzjgdmName("亦庄税务局");
//            legalPersonService.save(legalPerson);
//
//        }
//    }
//
//    @Test
//    public void genWifi(){
//        WifiInfo wifiInfo = new WifiInfo();
//        for (int i = 0; i < 20; i++) {
//            wifiInfo.setId(idService.genId());
//            wifiInfo.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
//            wifiInfo.setAddress("测试地址"+i);
//            wifiInfo.setInstallTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
//            wifiInfo.setMac("AC-AD-CD-DC-DS-SS"+i);
//            wifiInfo.setPartArea("亦庄"+i);
//            wifiInfo.setResName("测试资源"+i);
//            wifiInfo.setResPlatform("大数据平台"+i);
//            wifiInfoService.save(wifiInfo);
//
//        }
//    }
//}