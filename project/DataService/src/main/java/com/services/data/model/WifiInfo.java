package com.services.data.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * WIFI信息
 * </p>
 *
 * @author ww
 * @since 2019-11-21
 */
@Data
@TableName("wifi_info")
public class WifiInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.NONE)
    private Long id;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 资源id(导过来的)
     */
    private String resId;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * mac地址
     */
    private String mac;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 在线终端数
     */
    private String onlineSta;

    /**
     * 在线用户数(通过认证人数)
     */
    private String onlineUser;

    /**
     * 离线用户数
     */
    private String offlineUser;

    /**
     * 日均在线用户数
     */
    private String onlineUserAvg;

    /**
     * 上行速率
     */
    private String downLinkRate;

    /**
     * 下行速率
     */
    private String upLinkRate;

    /**
     * 当天上网总时长
     */
    private String sessiontime;

    /**
     * 0：离线，1：在线 -1：未使用
     */
    private String status;

    /**
     * 所属项目id(t_project_group)
     */
    private String projectId;

    /**
     * 所属组id(t_project_group)
     */
    private String groupId;

    /**
     * 所属的区(t_project_group)
     */
    private String areaId;

    /**
     * 厂家id(t_device_manu)
     */
    private String manuId;

    /**
     * 厂家名称(导过来的)
     */
    private String manu;

    /**
     * 型号id(t_device_model)
     */
    private String modelId;

    /**
     * 型号(导过来的)
     */
    private String model;

    /**
     * 数据来源平台
     */
    private String resPlatform;

    /**
     * 设备安装地址
     */
    private String address;

    /**
     * 安装时间
     */
    private String installTime;

    /**
     * 所属区域
     */
    private String partArea;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lon;

    /**
     * 1-室内,0-室外
     */
    private String isinside;

    /**
     * ac资源id
     */
    private String acResId;

    /**
     * 序列号
     */
    private String serialNumber;

    /**
     * 设备版本
     */
    private String deviceVersion;

    /**
     * 上级id: 0 无上级
     */
    private String parentId;

    /**
     * 备注
     */
    private String remake;

    /**
     * 拓扑结构表id
     */
    private String topologyId;

    /**
     * 认证类型
     */
    private String authtype;

    /**
     * 认证策略ID
     */
    private String authPolicyId;

    /**
     * 内存利用率
     */
    @TableField("MEMRate")
    private String MEMRate;

    /**
     * cpu利用率
     */
    @TableField("CPURate")
    private String CPURate;

    /**
     * 用户连接数阈值
     */
    private String linkThreshold;

    /**
     * AP设备名称
     */
    private String imgName;

    /**
     * 最大用户高峰阈值
     */
    private String maxOnline;

    /**
     * 当日用户记录
     */
    private String userNumDay;

    /**
     * 上行流量
     */
    private String upstreamTraffic;

    /**
     * 下行流量
     */
    private String downstreamTraffic;

    /**
     * 信号强度
     */
    private String signalStrength;

    /**
     * 发送数据包数
     */
    private String sendPktsNum;

    /**
     * 接收数据包数
     */
    private String receivePktsNum;

    /**
     * 丢包数
     */
    private String dropPktsNum;

    /**
     * 关联总次数
     */
    private String linkTotalNum;

    /**
     * 异常断开次数
     */
    private String abortiveDisconnectNum;

    /**
     * 关联失败数
     */
    private String associationFailNum;

    /**
     * 分组标识
     */
    private String groupNum;

    /**
     * 所属ac
     */
    private String belongAc;

    /**
     * ap不在线时长 存储秒 弃用
     */
    private String notonlinetime;

    /**
     * 1代表市统筹 2代表城区自建
     */
    private String buildunit;

    /**
     * 用于故障时间统计,请勿操作或者删除
     */
    private String breakUpdatetime;

    /**
     * 更新时间
     */
    private String updateTime;
}
