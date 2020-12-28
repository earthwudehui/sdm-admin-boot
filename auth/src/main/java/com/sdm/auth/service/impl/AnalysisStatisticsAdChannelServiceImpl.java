package com.sdm.auth.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdm.auth.dao.AnalysisStatisticsAdChannelDao;
import com.sdm.auth.model.bio.AnalysisAdStatisticsBIO;
import com.sdm.auth.service.AnalysisStatisticsAdChannelService;

@Service
public class AnalysisStatisticsAdChannelServiceImpl implements AnalysisStatisticsAdChannelService {

    @Resource
    public AnalysisStatisticsAdChannelDao analysisStatisticsAdChannelDao;

    @Override
    public List<AnalysisAdStatisticsBIO> queryByAdStatistics(AnalysisAdStatisticsBIO analysisAdStatisticsBIO) {
        return analysisStatisticsAdChannelDao.queryByAdStatistics(analysisAdStatisticsBIO);
    }

    @Override
    public List<AnalysisAdStatisticsBIO> queryByAd(AnalysisAdStatisticsBIO analysisAdStatisticsBIO) {
        return analysisStatisticsAdChannelDao.queryByAd(analysisAdStatisticsBIO);
    }

    @Override
    public List<Map<String, Object>> queryByAdChannelId(Long id) {
        return analysisStatisticsAdChannelDao.queryByAdChannelId(id);

    }

    @Override
    public List<AnalysisAdStatisticsBIO> queryBrandChannelJump(AnalysisAdStatisticsBIO analysisAdStatisticsBIO) {
        return analysisStatisticsAdChannelDao.queryBrandChannelJump(analysisAdStatisticsBIO);
    }
}
