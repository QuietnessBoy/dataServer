package com.services.data.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 备份市法人表
 * </p>
 *
 * @author ww
 * @since 2019-12-02
 */
@Data
@TableName("b_legal_person")
public class BLegalPerson implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 组织机构代码
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 组织机构代码
     */
    private String orgCode;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构地址
     */
    private String orgAddress;

    /**
     * 机构类型
     */
    private String orgTypeCode;

    /**
     * 机构类型名称
     */
    private String orgTypeCodeName;

    /**
     * 法定代表人姓名
     */
    private String legalPerson;

    /**
     * 注册号
     */
    private String regNo;

    /**
     * 成立日期
     */
    private String regDate;

    /**
     * 联系电话
     */
    private String telNo;

    /**
     * 状态
     */
    private String status;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 经济类型
     */
    private String ecnomicCode;

    /**
     * 经济类型名称
     */
    private String ecnomicCodeName;

    /**
     * 行业类别
     */
    private String industryCode;

    /**
     * 行业类别名称
     */
    private String industryCodeName;

    /**
     * 行政区划
     */
    private String areaCode;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 数据来源名称
     */
    private String dataSourceName;

    /**
     * 注册资金
     */
    private String regCapital;

    /**
     * 币种
     */
    private String currencyType;

    /**
     * 邮政编码
     */
    private String postcode;

    /**
     * 变更日期
     */
    private String updateDate;

    /**
     * 注吊销日期
     */
    private String revokeDate;

    /**
     * 计算机代码
     */
    private String jsjdm;

    /**
     * 税务登记证号
     */
    private String swdjzh;

    /**
     * 开业登记日期
     */
    private String kydjrq;

    /**
     * 主管税务机关名称
     */
    private String swjgzzjgdmName;

    /**
     * 纳税人状态
     */
    private String nsrzt;

    /**
     * 纳税人状态名称
     */
    private String nsrztName;

    /**
     * 发证日期
     */
    private String fzrq;

    /**
     * 有效日期
     */
    private String zfrq;

    /**
     * 地税注销日期
     */
    private String dszxrq;

    /**
     * 发证机构
     */
    private String fzjg;

    /**
     * 发证机构名称
     */
    private String fzjgName;

    /**
     * 有效期至
     */
    private String jyqxz;

    /**
     * 统一信用代码
     */
    private String uniScid;

    /**
     * 更新时间
     */
    private String updateTime;
}
