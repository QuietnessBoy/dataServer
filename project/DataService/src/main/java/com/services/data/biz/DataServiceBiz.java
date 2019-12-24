//package com.services.data.biz;
//
//import com.alibaba.fastjson.JSONObject;
//import com.robert.vesta.service.intf.IdService;
//import com.services.data.dto.JsonResult;
//import com.services.data.service.BLegalPersonService;
//import com.services.data.service.BWifiInfoService;
//import com.services.data.service.LegalPersonService;
//import com.services.data.service.WifiInfoService;
//import com.services.data.util.AppendUrlParm;
//import com.services.data.util.GenSign;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @ProjectName 数据服务平台业务处理层
// * @Package com.services.data.biz
// * @ClassName DataServiceBiz
// * @Description
// * @Company HaoBo
// * @Author wangw
// * @Date 2019/11/26 0026 10:27
// * @UpdateUser
// * @UpdateDate
// * @UpdateRemark
// * @Version 1.0.0
// */
//@Component
//@Slf4j
//public class DataServiceBiz {
//
//    @Autowired
//    private GenSign genSign;
//
//    private IdService idService;
//
//    public DataServiceBiz() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext(
//                "spring/vesta-rest-main.xml");
//        idService = (IdService) ac.getBean("idService");
//    }
//
//    /**
//     * @Title 提供给服务方的数据业务处理层
//     * @Description 获取法人库&wifi信息库数据，并返回至服务方
//     * @return
//     * @author wangw
//     * @date
//    */
//    @Transactional
//    public JsonResult getData(){
//        // 查询拥有权限的数据表
//        String tableListSign = genSign.genRequestSign("1");
//        // 测试数据
//        Map testMap = testM();
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setObj(testMap);
//        // 测试数据完成
//        Map map = JSONObject.parseObject(JSONObject.toJSONString(jsonResult.getObj()), Map.class);
//        List list = (List) map.get("body");
//        for (int i = 0; i < list.size(); i++) {
//            Map<String,String> bodyMap = JSONObject.parseObject(JSONObject.toJSONString(list.get(i)), Map.class);
////            for (String in : bodyMap.keySet()) {
////                String str = bodyMap.get(in);//得到每个key多对用value的值
////                System.out.println(in + "     " + str);
////            }
//        }
//        return jsonResult;
//    }
//
//
//    public Map testM(){
//        Map testM = new HashMap();
//        testM.put("status",0);
//        testM.put("msg","");
//
//        Map t1 = new HashMap();
//        t1.put("tableId","2145a123");
//        t1.put("tableName","数据表1");
//        Map t2 = new HashMap();
//        t2.put("tableId","2145a444");
//        t2.put("tableName","数据表2");
//
//        Object [] body = new Object[2];
//        body[0] = t1;
//        body[1] = t2;
//        testM.put("body",body);
//        return testM;
//    }
//}
