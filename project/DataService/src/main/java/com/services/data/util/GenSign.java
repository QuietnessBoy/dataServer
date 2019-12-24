package com.services.data.util;

import com.services.data.dto.InterResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private InterResult interResult;

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
            url = interResult.getTableListUrl();
        }
        if(num.equals("2")){
            url = interResult.getTableGetUrl();
        }
        if(num.equals("3")){
            url = interResult.getDataUrl();
        }
        String signMsg = interResult.getMethod()+interResult.getProjectName()+url+interResult.getAppScret()+timestamp;
        String sign = DigestUtils.md5Hex(signMsg);
        System.out.println(sign);
        return sign;
    }

}