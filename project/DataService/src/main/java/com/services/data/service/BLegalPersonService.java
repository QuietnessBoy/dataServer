package com.services.data.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.services.data.model.BLegalPerson;
import com.services.data.model.BWifiInfo;

import java.util.List;

/**
 * <p>
 * 市法人服务库 服务类
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
public interface BLegalPersonService extends IService<BLegalPerson> {
    void clear();
    List<BLegalPerson> selectBLegalPersonByCreateTime();
}
