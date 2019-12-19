package com.services.data.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.services.data.model.BWifiInfo;
import com.services.data.model.WifiInfo;

import java.util.List;

/**
 * <p>
 * WIFI信息 服务类
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
public interface BWifiInfoService extends IService<BWifiInfo> {
    void clear();
    List<BWifiInfo> selectBWifiInfoByCreateTime();
}
