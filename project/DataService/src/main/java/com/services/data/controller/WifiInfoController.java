package com.services.data.controller;


import com.services.data.biz.WifiInfoBiz;
import com.services.data.util.JsonResultTool;
import com.services.data.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * WIFI信息 前端控制器
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@RestController
@RequestMapping("/wifiInfo")
@Slf4j
public class WifiInfoController {

    @Autowired
    private WifiInfoBiz wifiInfoBiz;

    /** 
     * @Title 查询wifi信息
     * @Description
    
     * @return  
     * @author wangw
     * @date  
    */
    @RequestMapping(value = "/list")
    public JsonResult searchWifiInfo(){
        List list = wifiInfoBiz.searchWinfiInfo();
        JsonResult jsonResult = JsonResultTool.JsonResultSet(true,"200","查询成功!",list);
        return jsonResult;
    }

    /**
     * @Title 添加一条wifi信息记录
     * @Description

     * @return
     * @author wangw
     * @date
     */
    @RequestMapping(value = "/collect")
    public JsonResult collectWifiInfo(){
        log.info("【准备获取Wifi数据】");
        JsonResult jsonResult = wifiInfoBiz.collectWifiInfo();
        log.info("【获取Wifi数据完毕】");
        return jsonResult;
    }
}

