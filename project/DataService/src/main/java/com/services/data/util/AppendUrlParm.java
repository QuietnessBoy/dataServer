package com.services.data.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ProjectName yizhuangsmartcity
 * @Package com.services.data.util
 * @ClassName AppentParm
 * @Description 参数拼接
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/12/6 0006 16:05
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */
@Service
public class AppendUrlParm {

    @Value("${ip}")
    public String ip;

    @Value("${method}")
    private String method;

    @Value("${tableListUrl}")
    private String tableListUrl;

    @Value("${tableGetUrl}")
    private String tableGetUrl;

    @Value("${dataUrl}")
    private String dataUrl;

    @Value("${appKey}")
    private String appKey;

    @Value("${legalPersonTableId}")
    private String legalPersonTableId;

    @Value("${wifiInfoTableId}")
    private String wifiInfoTableId;

    @Value("${pageNum}")
    private String pageNum;

    @Value("${pageSize}")
    private String pageSize;

    private long timestamp = System.currentTimeMillis();

    /** 
     * @Title 查询权限数据表接口参数拼接
     * @Description
     * @return
     * @author wangw
     * @date  
    */
    public String appendTableListUrl(String sign){
        StringBuffer sb = new StringBuffer();
        sb = sb.append(ip).
                append(tableListUrl).
                append("?appKey=").
                append(appKey).
                append("&sign=").
                append(sign).
                append("&timestamp=").
                append(timestamp);
        return sb.toString();
    }

    /**
     * @Title 请求数据表结构接口参数拼接
     * @Description
     * @return
     * @author wangw
     * @date
     */
    public String appendTableGetUrl(String sign,String num){
        StringBuffer sb = new StringBuffer();
        String tableId = "";
        if(num.equals("1")){
            tableId = legalPersonTableId;
        }
        if(num.equals("2")){
            tableId = wifiInfoTableId;
        }
        sb = sb.append(ip).
                append(tableGetUrl).
                append("?appKey=").
                append(appKey).
                append("&sign=").
                append(sign).
                append("&timestamp=").
                append(timestamp).
                append("&tableId=").
                append(tableId);
        return sb.toString();
    }

    /**
     * @Title 请求数据接口参数拼接
     * @Description
     * @return
     * @author wangw
     * @date
     */
    public String appendDataUrl(String sign,String num){
        StringBuffer sb = new StringBuffer();
        String tableId = "";
        if(num.equals("1")){
            tableId = legalPersonTableId;
        }
        if(num.equals("2")){
            tableId = wifiInfoTableId;
        }
        sb = sb.append(ip).
                append(dataUrl).
                append("?appKey=").
                append(appKey).
                append("&sign=").
                append(sign).
                append("&timestamp=").
                append(timestamp).
                append("&tableId=").
                append(tableId).
                append("&pageNum=").
                append(pageNum).
                append("&pageSize=").
                append(pageSize);
        return sb.toString();
    }

}