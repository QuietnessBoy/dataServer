package com.services.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.services.data.model.BWifiInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * WIFI信息备份 Mapper 接口
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Mapper
public interface BWifiInfoMapper extends BaseMapper<BWifiInfo> {
    void clear();
    List<BWifiInfo> selectBWifiInfoByCreateTime();

}
