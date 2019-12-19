package com.services.data.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.robert.vesta.service.intf.IdService;
import com.services.data.config.HttpMethod;
import com.services.data.util.JsonResultTool;
import com.services.data.dto.JsonResult;
import com.services.data.model.BWifiInfo;
import com.services.data.model.WifiInfo;
import com.services.data.service.BWifiInfoService;
import com.services.data.service.WifiInfoService;
import com.services.data.util.AppendUrlParm;
import com.services.data.util.GenSign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Component
@Slf4j
public class WifiInfoBiz {

    @Autowired
    private WifiInfoService wifiInfoService;

    @Autowired
    private BWifiInfoService bWifiInfoService;

    @Autowired
    private GenSign genSign;

    @Autowired
    private AppendUrlParm appendUrlParm;

    private IdService idService;

    public WifiInfoBiz() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/vesta-rest-main.xml");
        idService = (IdService) ac.getBean("idService");
    }

    /** 
     * @Title 获取wifi信息表数据
     * @Description
    
     * @return  
     * @author wangw
     * @date  
    */
    public List getWifiInfo(){
        List list = wifiInfoService.list();
        return list;
    }

    /** 
     * @Title 查询wifi信息
     * @Description
        若实时表暂无数据，查询备份表数据
     * @return  
     * @author wangw
     * @date  
    */
    public List searchWinfiInfo(){
        List list = wifiInfoService.selectWifiInfo();
        if(list.size()==0){
            list = bWifiInfoService.selectBWifiInfoByCreateTime();
        }
        return list;
    }

    /** 
     * @Title wifi数据采集
     * @Description
    
     * @return  
     * @author wangw
     * @date  
    */
    public JsonResult collectWifiInfo(){
        String legalPersonSign = genSign.genRequestSign("3");
        String url = appendUrlParm.appendDataUrl(legalPersonSign,"2");
        String methodUrl = "http://10.117.5.223:86//etown-bigdata-datashare/api/datashare/data?appKey=c56fc3ab3bb9100fef62bf4bca330adb669b5208&sign=1cbd6b95e79e07cc2bf86c9eae61b7c3&timestamp=1576719669881&tableId=1fc22963e10511e9b84a7cd30a5dd860&pageNum=1&pageSize=10000";
        System.out.println(methodUrl);
        System.out.println(url);
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
            WifiInfo wifiInfo = JSON.toJavaObject(jsonObject1,WifiInfo.class);
            wifiInfo.setId(idService.genId());
            wifiInfo.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
            boolean b = wifiInfoService.save(wifiInfo);
            if(b){
                jsonResult = JsonResultTool.JsonResultSet(true,"200","数据解析入库完成.",null);
            }else {
                jsonResult = JsonResultTool.JsonResultSet(false,"500","数据解析入库错误.",null);
            }
        }

        jsonResult = JsonResultTool.JsonResultSet(true,"200","获取数据完成.",map);
        return jsonResult;
    }
}
