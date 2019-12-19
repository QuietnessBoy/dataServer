package com.services.data.controller;


import com.services.data.biz.LegalPersonBiz;
import com.services.data.util.JsonResultTool;
import com.services.data.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 市法人服务库 前端控制器
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Slf4j
@RequestMapping("/legalPerson")
@RestController
public class LegalPersonController {

    @Autowired
    private LegalPersonBiz legalPersonBiz;

    /**
     * @Title 获取法人表全部数据
     * @Description
    
     * @return  
     * @author wangw
     * @date  
    */
    @RequestMapping(value = "/list")
    public JsonResult getLegalPerson(){
        List list = legalPersonBiz.getLegalPerson();
        JsonResult jsonResult = JsonResultTool.JsonResultSet(true,"200","查询成功!",list);
        return jsonResult;
    }
    
    /** 
     * @Title 法人数据采集处理器
     * @Description
    
     * @return  
     * @author wangw
     * @date  
    */
    @RequestMapping(value = "/collect")
    public JsonResult collectLegalPerson(){
        log.info("【准备获取法人库数据】");
        JsonResult jsonResult = legalPersonBiz.collectLegalPerson();
        log.info("【获取法人库数据完毕】");
        return jsonResult;
    }

}

