package com.services.data.util;

import com.services.data.dto.InterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private InterResult interResult;

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
        sb = sb.append(interResult.getIp()).
                append(interResult.getTableListUrl()).
                append("?appKey=").
                append(interResult.getAppKey()).
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
            tableId = interResult.getLegalPersonTableId();
        }
        if(num.equals("2")){
            tableId = interResult.getWifiInfoTableId();
        }
        sb = sb.append(interResult.getIp()).
                append(interResult.getTableGetUrl()).
                append("?appKey=").
                append(interResult.getAppKey()).
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
            tableId = interResult.getLegalPersonTableId();
        }
        if(num.equals("2")){
            tableId = interResult.getWifiInfoTableId();
        }
        sb = sb.append(interResult.getIp()).
                append(interResult.getDataUrl()).
                append("?appKey=").
                append(interResult.getAppKey()).
                append("&sign=").
                append(sign).
                append("&timestamp=").
                append(timestamp).
                append("&tableId=").
                append(tableId).
                append("&pageNum=").
                append(interResult.getPageNum()).
                append("&pageSize=").
                append(interResult.getPageSize());
        return sb.toString();
    }

}