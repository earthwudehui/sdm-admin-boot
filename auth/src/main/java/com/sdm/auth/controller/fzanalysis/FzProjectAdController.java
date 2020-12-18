package com.sdm.auth.controller.fzanalysis;

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
import com.sdm.auth.model.dto.FzProjectAdDTO;
import com.sdm.auth.model.query.FzProjectAdQuery;
import com.sdm.auth.service.FzProjectAdService;

/**
 * 广告信息
 * 
 * @author Administrator
 * @date 2020/12/11
 */
@RequestMapping("/api/analysis/fzprojectad")
@RestController
public class FzProjectAdController {

    @Resource
    private FzProjectAdService fzProjectAdService;

    @Resource
    private ModelMapper modelMapper;

    /**
     * 获取列表
     * 
     * @param request
     * @param data
     * @return
     */
    @PostMapping("/queryList")
    public Map<String, Object> queryProjectList(HttpServletRequest request, @RequestBody Map<String, Object> data) {

        FzProjectAdQuery fzProjectAdQuery = modelMapper.map(data.get("params"), FzProjectAdQuery.class);

        // 1）分页
        PageHelper.startPage(fzProjectAdQuery.getCurrent(), fzProjectAdQuery.getPageSize());// 1,10
                                                                                            // 获取第1页，10条内容，默认查询总数count

        // 2）获取业务数据
        List<FzProjectAdDTO> list = fzProjectAdService.getFzProjectAdListBy(fzProjectAdQuery);

        // 3) 处理分页
        PageInfo<FzProjectAdDTO> page = new PageInfo<FzProjectAdDTO>(list);// PageInfo 包含分页信息

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
     * 新增
     * 
     * @param request
     * @param FzProjectAdQuery
     * @return
     */
    @PostMapping("/save")
    public String saveFzProjectAd(HttpServletRequest request, @RequestBody FzProjectAdQuery fzProjectAdQuery) {
        fzProjectAdService.saveFzProjectAd(fzProjectAdQuery);
        return "ok";
    }

    /**
     * 获取详细信息
     * 
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/queryFzProjectAdById")
    public FzProjectAdQuery queryFzProjectAdById(HttpServletRequest request, Long id) {
        return modelMapper.map(fzProjectAdService.getFzProjectAdById(id), FzProjectAdQuery.class);
    }

    /**
     * 修改信息
     * 
     * @param request
     * @param data
     * @return
     */
    @PostMapping("/update")
    public FzProjectAdQuery updateFzProjectAd(HttpServletRequest request,
        @RequestBody FzProjectAdQuery fzProjectAdQuery) {

        return modelMapper.map(fzProjectAdService.updateFzProjectAd(fzProjectAdQuery), FzProjectAdQuery.class);
    }

}
