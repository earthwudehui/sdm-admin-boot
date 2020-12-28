package com.sdm.auth.service;

import java.util.List;
import java.util.Map;

import com.sdm.auth.model.bio.AnalysisAdStatisticsBIO;

/**
 * 分析统计--广告渠道
 * 
 * @author Administrator
 * @date 2020/12/21
 */
public interface AnalysisStatisticsAdChannelService {

    /**
     * 按投放日期统计
     */
    public List<AnalysisAdStatisticsBIO> queryByAdStatistics(AnalysisAdStatisticsBIO analysisAdStatisticsBIO);

    /**
     * 按广告统计
     */
    public List<AnalysisAdStatisticsBIO> queryByAd(AnalysisAdStatisticsBIO analysisAdStatisticsBIO);

    /**
     * 根据AdChannelId 加载Chart数据
     * 
     * @param id
     * @return
     */
    public List<Map<String, Object>> queryByAdChannelId(Long id);

    /**
     * 品牌渠道导流统计
     */
    public List<AnalysisAdStatisticsBIO> queryBrandChannelJump(AnalysisAdStatisticsBIO analysisAdStatisticsBIO);

}
