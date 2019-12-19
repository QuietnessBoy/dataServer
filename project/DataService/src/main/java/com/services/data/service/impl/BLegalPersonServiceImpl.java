package com.services.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.services.data.mapper.BLegalPersonMapper;
import com.services.data.model.BLegalPerson;
import com.services.data.model.BWifiInfo;
import com.services.data.service.BLegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 市法人服务备份库
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Service
public class BLegalPersonServiceImpl extends ServiceImpl<BLegalPersonMapper, BLegalPerson> implements BLegalPersonService {

    @Autowired
    private BLegalPersonMapper bLegalPersonMapper;

    @Override
    public void clear() {
        bLegalPersonMapper.clear();
    }

    @Override
    public List<BLegalPerson> selectBLegalPersonByCreateTime() {
        return bLegalPersonMapper.selectBLegalPersonByCreateTime();
    }
}
