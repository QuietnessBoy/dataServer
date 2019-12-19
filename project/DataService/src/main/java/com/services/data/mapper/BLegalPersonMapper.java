package com.services.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.services.data.model.BLegalPerson;
import com.services.data.model.BWifiInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 市法人服务备份库 Mapper 接口
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Mapper
public interface BLegalPersonMapper extends BaseMapper<BLegalPerson> {
    void clear();
    List<BLegalPerson> selectBLegalPersonByCreateTime();

}
