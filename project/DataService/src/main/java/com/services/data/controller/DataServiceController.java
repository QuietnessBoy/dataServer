package com.services.data.controller;

import com.services.data.biz.DataServiceBiz;
import com.services.data.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 数据服务处理控制层
 */


/**
 * @ProjectName
 * @Package com.services.data.controller
 * @ClassName DataServiceController
 * @Description 
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/11/26 0026 10:08
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */
@RequestMapping("/dataService")
@RestController
@Slf4j
public class DataServiceController {

    @Autowired
    private DataServiceBiz dataServiceBiz;


    /**
     * @Title 查询法人表&wifi信息表等全部数据
     * @Descriptio 提供服务方所需要查询的数据信息
     * @return  
     * @author wangw
     * @date  2019.11.26
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JsonResult getData(){

        log.info("【服务方调用接口，准备获取数据】");
        JsonResult jsonResult = dataServiceBiz.getData();
        log.info("【服务方获取数据完毕!】");
        return jsonResult;
    }




}

