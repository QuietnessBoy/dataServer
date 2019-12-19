package com.services.data.dto;

import lombok.Data;

/**
 * @ProjectName 通用请求响应类
 * @Package com.services.data.dto
 * @ClassName JsonResult
 * @Description
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/12/18 0018 9:28
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */
@Data
public class JsonResult<T> {

    /**
     * @Title 是否成功
     * @Description

     * @return
     * @author wangw
     * @date
    */
    private boolean success;

    /**
     * @Title 结果说明
     * @Description

     * @return
     * @author wangw
     * @date
    */
    private String msg;

    /**
     * @Title 结果状态码
     * @Description
        成功：200
     *  失败：500
     * @return
     * @author wangw
     * @date
    */
    private String status;

    /**
     * @Title
     * @Description
    返回的结果对象
     * @return
     * @author wangw
     * @date
    */
    private T obj;
}
