package com.services.data.service.impl;

import com.services.data.model.WifiInfo;
import com.services.data.mapper.WifiInfoMapper;
import com.services.data.service.WifiInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * WIFI信息 服务实现类
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Service
public class WifiInfoServiceImpl extends ServiceImpl<WifiInfoMapper, WifiInfo> implements WifiInfoService {

    @Autowired
    private WifiInfoMapper wifiInfoMapper;

    @Override
    public void clear() {
        wifiInfoMapper.clear();
    }

    @Override
    public List<WifiInfo> selectWifiInfo() {
        return wifiInfoMapper.selectWifiInfo();
    }
}
