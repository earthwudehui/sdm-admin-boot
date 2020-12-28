package com.sdm.auth.dao;

import java.util.List;
import java.util.Map;

import com.sdm.auth.model.bio.AnalysisAdStatisticsBIO;

public interface AnalysisStatisticsAdChannelDao {

    public List<AnalysisAdStatisticsBIO> queryByAdStatistics(AnalysisAdStatisticsBIO analysisAdStatisticsBIO);

    public List<AnalysisAdStatisticsBIO> queryByAd(AnalysisAdStatisticsBIO analysisAdStatisticsBIO);

    public List<Map<String, Object>> queryByAdChannelId(Long id);

    public List<AnalysisAdStatisticsBIO> queryBrandChannelJump(AnalysisAdStatisticsBIO analysisAdStatisticsBIO);

}
