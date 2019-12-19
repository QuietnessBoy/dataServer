package com.services.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.services.data.mapper.BWifiInfoMapper;
import com.services.data.model.BWifiInfo;
import com.services.data.service.BWifiInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * WIFI信息备份 服务实现类
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Service
public class BWifiInfoServiceImpl extends ServiceImpl<BWifiInfoMapper, BWifiInfo> implements BWifiInfoService {

    @Autowired
    private BWifiInfoMapper  bWifiInfoMapper;

    @Override
    public void clear() {
        bWifiInfoMapper.clear();
    }

    @Override
    public List<BWifiInfo> selectBWifiInfoByCreateTime() {
        return bWifiInfoMapper.selectBWifiInfoByCreateTime();
    }
}
