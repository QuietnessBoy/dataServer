package com.services.data.task;

import com.alibaba.fastjson.JSON;
import com.services.data.biz.LegalPersonBiz;
import com.services.data.biz.WifiInfoBiz;
import com.services.data.dto.JsonResult;
import com.services.data.model.LegalPerson;
import com.services.data.model.WifiInfo;
import com.services.data.service.BLegalPersonService;
import com.services.data.service.BWifiInfoService;
import com.services.data.service.LegalPersonService;
import com.services.data.service.WifiInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName yizhuangsmartcity
 * @Package com.services.data.task
 * @ClassName TimingExpireData
 * @Description 定时清理过期数据
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/12/2 0002 9:14
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */
@Component
@Slf4j
public class TimingExpireData {

    @Autowired
    private LegalPersonService legalPersonService;

    @Autowired
    private BLegalPersonService bLegalPersonService;

    @Autowired
    private WifiInfoService wifiInfoService;

    @Autowired
    private BWifiInfoService bWifiInfoService;

    @Autowired
    private WifiInfoBiz wifiInfoBiz;

    @Autowired
    private LegalPersonBiz legalPersonBiz;
    /**
     * @Title     每天凌晨0点执行一次
     * @Description 每天定时清理实时表数据 每天实时采集数据
     * @return
     * @author wangw
     * @date
    */
    @Scheduled(cron = "0 0 0 * * ?")
    public void ClearRealTimeData() {
        log.info("【开始迁移法人实时表数据到备份表】");
        List<LegalPerson> legalPeopleList = legalPersonService.list();
        legalPersonService.saveBatch(legalPeopleList);
        log.info("【法人实时表数据迁移备份表完毕】");

        log.info("【开始迁移wifi实时表数据到备份表】");
        List<WifiInfo> wifiList = wifiInfoService.list();
        wifiInfoService.saveBatch(wifiList);
        log.info("【wifi实时表数据迁移备份表完毕】");

        log.info("【开始清理wifi和法人实时表数据】");
        wifiInfoService.clear();
        legalPersonService.clear();
        log.info("【清理实时表数据完毕】");

        log.info("【定时开始wifi数据采集】");
        JsonResult wifiResult = wifiInfoBiz.collectWifiInfo();
        log.info("【wifi数据采集完毕】"+wifiResult);

        log.info("【定时开始法人数据采集】");
        JsonResult legalPersonResult = legalPersonBiz.collectLegalPerson();
        log.info("【法人数据采集完毕】"+legalPersonResult);
    }

    /**
     * @Title
     * @Description 定时清理入库时间超过15天以上的备份表数据
     * @return
     * @author wangw
     * @date
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void ClearBackUpData() {
        log.info("【定时开始清理备份表数据.】");
        bLegalPersonService.clear();
        bWifiInfoService.clear();
        log.info("【清理备份表数据完毕.】");
    }
}