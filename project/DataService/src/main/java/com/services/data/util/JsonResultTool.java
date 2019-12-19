package com.services.data.util;

import com.services.data.dto.JsonResult;

/**
 * @ProjectName JsonResult 自定义封装类
 * @Package com.services.data.config
 * @ClassName JsonResultTool
 * @Description 
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/11/26 0026 10:11
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */
public class JsonResultTool {

    /** 
     * @Title JsonResult 自定义封装函数
     * @Description 用于返回JsonResult对象
     * @return
     * @author wangw
     * @date  2019.11.26
    */
    public static JsonResult JsonResultSet(boolean success, String status, String msg, Object obj){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setMsg(msg);
        jsonResult.setSuccess(success);
        jsonResult.setObj(obj);
        jsonResult.setStatus(status);
        return jsonResult;
    }
}
