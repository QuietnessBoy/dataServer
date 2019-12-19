package com.services.data.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName yizhuangsmartcity
 * @Package com.services.data.util
 * @ClassName GenSign
 * @Description 生成签名串
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/12/2 0002 14:48
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */
@Service
public class GenSign {
    @Value("${appScret}")
    private String appScret;

    @Value("${tableListUrl}")
    private String tableListUrl;

    @Value("${tableGetUrl}")
    private String tableGetUrl;

    @Value("${dataUrl}")
    private String dataUrl;


    @Value("${method}")
    private String method;
    @Value("${projectName}")
    private String projectName;

    private long timestamp = System.currentTimeMillis();

    /**
     * @Title 生成签名字符串
     * @Description 通过appkey/appSecret/url/method/timeStamp进行md5加密得到sign,num用于辨别需要对哪个接口地址进行签名
     * 1: 获取数据列表查询权限接口  2: 获取表数据结构接口  3：获取数据接口
     * @return  sign
     * @author wangw
     * @date  
    */
    public String genRequestSign(String num){
        String url = "";
        if(num.equals("1")){
            url = tableListUrl;
        }
        if(num.equals("2")){
            url = tableGetUrl;
        }
        if(num.equals("3")){
            url = dataUrl;
        }
        String signMsg = method+projectName+url+appScret+timestamp;
        String sign = DigestUtils.md5Hex(signMsg);
        System.out.println(sign);
        return sign;
    }

    public static void main(String[] args) {

    }
}