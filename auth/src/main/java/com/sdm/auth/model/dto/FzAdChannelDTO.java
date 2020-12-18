/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-12-08 Created
 */
package com.sdm.auth.model.dto;

import java.util.Date;

import lombok.Data;

/**
 *
 * @Description: 投放广告所属渠道信息表
 * @see: 此处填写需要参考的类
 * @version 2020年12月08日 下午 15:43:20
 * @autor
 */
@Data
public class FzAdChannelDTO {
    private Long id;

    /**
     * 交易系统渠道id
     */
    private String channelId;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 广告id
     */
    private Long adId;

    /**
     * 渠道类型 首页|专栏
     */
    private String channelType;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;

    /**
     * 所属分类 0全国| 1分类
     */
    private String type;

    /**
     * 省
     */
    private String typeProvince;

    /**
     * 市
     */
    private String typeCity;

    /**
     * 区县
     */
    private String typeCounty;

    /**
     * 项目状态 0 正常 1 禁用
     */
    private String status;

    /**
     * 创建人ID
     */
    private String createBy;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 最后更新人ID
     */
    private String updateBy;

    /**
     * 最后更新时间
     */
    private Date updateDate;

    /**
     * 备注
     */
    private String remark;

}