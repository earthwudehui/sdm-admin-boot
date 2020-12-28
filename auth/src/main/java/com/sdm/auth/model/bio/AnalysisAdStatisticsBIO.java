package com.sdm.auth.model.bio;

import com.sdm.auth.model.query.PageInfoQuery;

import lombok.Data;

@Data
public class AnalysisAdStatisticsBIO extends PageInfoQuery {

    /**
     * 广告渠道ID
     */
    private Long id;

    /**
     * 品牌ID
     */
    private String brandId;

    /**
     * 品牌名称
     */
    private String xxmc;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 广告id
     */
    private Long adId;

    /**
     * 上刊广告名称
     */
    private String adName;

    /**
     * 上刊广告图图
     */
    private String pictureUrl;

    /**
     * 渠道Id
     */
    private String channelId;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道开始
     */
    private String startDate;

    /**
     * 渠道结束
     */
    private String endDate;

    /**
     * 统计数据日期
     */
    private String statisticsDate;

    /**
     * 统计日期开始
     */
    private String statisticsDateStart;

    /**
     * 统计日期结束
     */
    private String statisticsDateEnd;

    /**
     * 渠道类型 首页|专栏
     */
    private String channelType;

    /**
     * 扫码数据UV
     */
    private int scanCodeUV;

    /**
     * 导流数据UV
     */
    private int jumpUV;

}
