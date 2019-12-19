package com.services.data.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.robert.vesta.service.intf.IdService;
import com.services.data.config.HttpMethod;
import com.services.data.util.JsonResultTool;
import com.services.data.dto.JsonResult;
import com.services.data.model.BLegalPerson;
import com.services.data.model.LegalPerson;
import com.services.data.service.BLegalPersonService;
import com.services.data.service.LegalPersonService;
import com.services.data.util.AppendUrlParm;
import com.services.data.util.GenSign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName 法人表业务处理层
 * @Package com.services.data.biz
 * @ClassName LegalPersonBiz
 * @Description 
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/11/26 0026 10:12
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */
@Service
@Slf4j
public class LegalPersonBiz {

    @Autowired
    private LegalPersonService legalPersonService;

    @Autowired
    private BLegalPersonService bLegalPersonService;

    @Autowired
    private GenSign genSign;

    @Autowired
    private AppendUrlParm appendUrlParm;

    private IdService idService;

    public LegalPersonBiz() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/vesta-rest-main.xml");
        idService = (IdService) ac.getBean("idService");
    }

    /** 
     * @Title 获取法人库信息
     * @Description
    
     * @return  
     * @author wangw
     * @date  
    */
    public List getLegalPerson(){
        List list = legalPersonService.list();
        System.out.println(list);
        if(list.size()==0){
            list = bLegalPersonService.selectBLegalPersonByCreateTime();
        }
        return list;
    }

    /**
     * @Title 法人数据采集
     * @Description
    
     * @return  
     * @author wangw
     * @date  
    */
    @Transactional
    public JsonResult collectLegalPerson(){
        String legalPersonSign = genSign.genRequestSign("3");
        String url = appendUrlParm.appendDataUrl(legalPersonSign,"1");
//        String methodUrl = "http://10.117.5.223:86//etown-bigdata-datashare/api/datashare/data?appKey=c56fc3ab3bb9100fef62bf4bca330adb669b5208&sign=dfaaa8f62aea8024728ab5e1aea62dfc&timestamp=1576661562848&tableId=32033be2c26111e9b84a7cd30a5dd860&pageNum=1&pageSize=10000";
        JsonResult httpJsonResult = HttpMethod.httpGETCase(url);   // 接受http请求返回值
        JsonResult jsonResult = new JsonResult();
        if(!httpJsonResult.getStatus().equals("200")){
            log.info(httpJsonResult.getMsg());
            return httpJsonResult;
        }
        JSONObject jsonObject = JSONObject.parseObject(httpJsonResult.getObj().toString());
        Object bodyObj = jsonObject.get("body");
        Map map = JSONObject.parseObject(JSONObject.toJSONString(bodyObj), Map.class);
        List list = (List) map.get("list");
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject1 = JSON.parseObject(String.valueOf(list.get(i)));
            LegalPerson legalPerson = JSON.toJavaObject(jsonObject1,LegalPerson.class);
            legalPerson.setId(idService.genId());
            legalPerson.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            boolean b = legalPersonService.save(legalPerson);
            if(b){
                jsonResult = JsonResultTool.JsonResultSet(true,"200","法人数据采集完成.",null);
            }else {
                jsonResult = JsonResultTool.JsonResultSet(false,"500","法人数据采集失败.",null);
            }
        }
        return jsonResult;
    }
}
