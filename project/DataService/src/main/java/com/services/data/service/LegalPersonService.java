package com.services.data.service;

import com.services.data.model.LegalPerson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 市法人服务库 服务类
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
public interface LegalPersonService extends IService<LegalPerson> {
    void clear();
    List<LegalPerson> selectLegalPerson();
}
