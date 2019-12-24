package com.services.data.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName DataService
 * @Package com.services.data
 * @ClassName InterResult
 * @Description 用于匹配日志文件相关参数
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/12/24 0024 11:33
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */

@Component
@ConfigurationProperties(prefix = "logparm")
@Data
public class LogResult {

    // 日志文件地址
    private String logDir;

    // 日志文件前缀名
    private String contextName;
}