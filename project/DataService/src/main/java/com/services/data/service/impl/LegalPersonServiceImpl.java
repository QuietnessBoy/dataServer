package com.services.data.service.impl;

import com.services.data.model.LegalPerson;
import com.services.data.mapper.LegalPersonMapper;
import com.services.data.service.LegalPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 市法人服务库 服务实现类
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Service
public class LegalPersonServiceImpl extends ServiceImpl<LegalPersonMapper, LegalPerson> implements LegalPersonService {

    @Autowired
    private LegalPersonMapper legalPersonMapper;

    @Override
    public void clear() {
        legalPersonMapper.clear();
    }

    @Override
    public List<LegalPerson> selectLegalPerson() {
        return legalPersonMapper.selectLegalPerson();
    }
}
