package com.services.data.mapper;

import com.services.data.model.LegalPerson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 市法人服务库 Mapper 接口
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Mapper
public interface LegalPersonMapper extends BaseMapper<LegalPerson> {
    void clear();
    List<LegalPerson> selectLegalPerson();
}
