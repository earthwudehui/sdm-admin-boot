package com.sdm.auth.controller.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdm.auth.model.bio.AnalysisAdStatisticsBIO;
import com.sdm.auth.service.AnalysisStatisticsAdChannelService;

/**
 * 渠道信息
 * 
 * @author Administrator
 * @date 2020/12/11
 */
@RequestMapping("/api/analysis/analysisStatisticsAdChannel")
@RestController
public class AnalysisStatisticsAdChannelController {

    @Resource
    private AnalysisStatisticsAdChannelService analysisStatisticsAdChannelService;

    @Resource
    private ModelMapper modelMapper;

    /**
     * 按投放日期统计
     * 
     * @param request
     * @param data
     * @return
     */
    @PostMapping("/queryByAdStatistics")
    public Map<String, Object> queryByAdStatistics(HttpServletRequest request, @RequestBody Map<String, Object> data) {

        AnalysisAdStatisticsBIO analysisAdStatisticsBIO =
            modelMapper.map(data.get("params"), AnalysisAdStatisticsBIO.class);

        // 1）分页
        PageHelper.startPage(analysisAdStatisticsBIO.getCurrent(), analysisAdStatisticsBIO.getPageSize());// 1,10
        // 获取第1页，10条内容，默认查询总数count

        // 2）获取业务数据
        List<AnalysisAdStatisticsBIO> list =
            analysisStatisticsAdChannelService.queryByAdStatistics(analysisAdStatisticsBIO);

        // 3) 处理分页
        PageInfo<AnalysisAdStatisticsBIO> page = new PageInfo<AnalysisAdStatisticsBIO>(list);// PageInfo 包含分页信息

        // 5）返回值
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", list);
        result.put("total", page.getTotal());
        result.put("success", true);
        result.put("pageSize", page.getPageSize());
        result.put("current", page.getSize());
        return result;
    }

    /**
     * 按投放画面统计
     * 
     * @param request
     * @param data
     * @return
     */
    @PostMapping("/queryByAd")
    public Map<String, Object> queryByAd(HttpServletRequest request, @RequestBody Map<String, Object> data) {

        AnalysisAdStatisticsBIO analysisAdStatisticsBIO =
            modelMapper.map(data.get("params"), AnalysisAdStatisticsBIO.class);

        // 1）分页
        PageHelper.startPage(analysisAdStatisticsBIO.getCurrent(), analysisAdStatisticsBIO.getPageSize());// 1,10
        // 获取第1页，10条内容，默认查询总数count

        // 2）获取业务数据
        List<AnalysisAdStatisticsBIO> list = analysisStatisticsAdChannelService.queryByAd(analysisAdStatisticsBIO);

        // 3) 处理分页
        PageInfo<AnalysisAdStatisticsBIO> page = new PageInfo<AnalysisAdStatisticsBIO>(list);// PageInfo 包含分页信息

        // 5）返回值
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", list);
        result.put("total", page.getTotal());
        result.put("success", true);
        result.put("pageSize", page.getPageSize());
        result.put("current", page.getSize());
        return result;
    }

    /**
     * 投放周期明细
     * 
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/queryByAdChannelId")
    public List<Map<String, Object>> queryByAdChannelId(HttpServletRequest request, Long id) {
        return analysisStatisticsAdChannelService.queryByAdChannelId(id);
    }

    /**
     * 品牌渠道导流统计
     * 
     * @param request
     * @param data
     * @return
     */
    @PostMapping("/queryBrandChannelJump")
    public Map<String, Object> queryBrandChannelJump(HttpServletRequest request,
        @RequestBody Map<String, Object> data) {

        AnalysisAdStatisticsBIO analysisAdStatisticsBIO =
            modelMapper.map(data.get("params"), AnalysisAdStatisticsBIO.class);

        // 1）分页
        PageHelper.startPage(analysisAdStatisticsBIO.getCurrent(), analysisAdStatisticsBIO.getPageSize());// 1,10
        // 获取第1页，10条内容，默认查询总数count

        // 2）获取业务数据
        List<AnalysisAdStatisticsBIO> list =
            analysisStatisticsAdChannelService.queryBrandChannelJump(analysisAdStatisticsBIO);

        // 3) 处理分页
        PageInfo<AnalysisAdStatisticsBIO> page = new PageInfo<AnalysisAdStatisticsBIO>(list);// PageInfo 包含分页信息

        // 5）返回值
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", list);
        result.put("total", page.getTotal());
        result.put("success", true);
        result.put("pageSize", page.getPageSize());
        result.put("current", page.getSize());
        return result;
    }
}
