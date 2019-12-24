package com.services.data.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName DataService
 * @Package com.services.data
 * @ClassName InterResult
 * @Description 用于匹配配置文件中对接大数据中心请求接口参数
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/12/24 0024 11:33
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */

@Component
@ConfigurationProperties(prefix = "interparm")
@Data
public class InterResult {

    private String appKey;

    private String appScret;

    private String tableListUrl;

    private String tableGetUrl;

    private String dataUrl;

    private String projectName;

    private String method;

    private String legalPersonTableId;

    private String wifiInfoTableId;

    private String pageNum;

    private String pageSize;

    private String ip;

}