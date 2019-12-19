package com.services.data.mapper;

import com.services.data.model.WifiInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * WIFI信息 Mapper 接口
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Mapper
public interface WifiInfoMapper extends BaseMapper<WifiInfo> {
    void clear();
    List<WifiInfo> selectWifiInfo();

}
