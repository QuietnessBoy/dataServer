package com.services.data.service;

import com.services.data.model.WifiInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * WIFI信息 服务类
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
public interface WifiInfoService extends IService<WifiInfo> {
    void clear();
    List<WifiInfo> selectWifiInfo();
}
