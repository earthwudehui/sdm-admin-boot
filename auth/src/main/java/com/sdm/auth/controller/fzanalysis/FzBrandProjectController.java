package com.sdm.auth.controller.fzanalysis;

import java.util.ArrayList;
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
import com.sdm.auth.model.dto.FzBrandProjectDTO;
import com.sdm.auth.model.query.FzBrandProjectQuery;
import com.sdm.auth.service.FzBrandProjectService;

/**
 * 项目信息
 * 
 * @author Administrator
 * @date 2020/12/11
 */
@RequestMapping("/api/analysis/fzbrandproject")
@RestController
public class FzBrandProjectController {

    @Resource
    private FzBrandProjectService fzBrandProjectService;

    @Resource
    private ModelMapper modelMapper;

    @PostMapping("/queryList")
    public Map<String, Object> queryProjectList(HttpServletRequest request, @RequestBody Map<String, Object> data) {

        FzBrandProjectQuery fzBrandProjectQuery = modelMapper.map(data.get("params"), FzBrandProjectQuery.class);

        // 1）分页
        PageHelper.startPage(fzBrandProjectQuery.getCurrent(), fzBrandProjectQuery.getPageSize());// 1,10
                                                                                                  // 获取第1页，10条内容，默认查询总数count

        // 2）获取业务数据
        List<FzBrandProjectDTO> list = fzBrandProjectService.getFzBrandProjectListBy(fzBrandProjectQuery);

        // 3) 处理分页
        PageInfo<FzBrandProjectDTO> page = new PageInfo<FzBrandProjectDTO>(list);// PageInfo 包含分页信息

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
     * 新增用户
     * 
     * @param request
     * @param FzBrandProjectQuery
     * @return
     */
    @PostMapping("/save")
    public String saveFzBrandProject(HttpServletRequest request, @RequestBody FzBrandProjectQuery fzBrandProjectQuery) {
        fzBrandProjectService.saveFzBrandProject(fzBrandProjectQuery);
        return "ok";
    }

    /**
     * 获取用户详细信息
     * 
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/queryFzBrandProjectById")
    public FzBrandProjectQuery queryFzBrandProjectById(HttpServletRequest request, Long id) {
        return modelMapper.map(fzBrandProjectService.getFzBrandProjectById(id), FzBrandProjectQuery.class);
    }

    /**
     * 修改用户信息
     * 
     * @param request
     * @param data
     * @return
     */
    @PostMapping("/update")
    public FzBrandProjectQuery updateFzBrandProject(HttpServletRequest request, @RequestBody Map<String, Object> data) {

        return modelMapper.map(
            fzBrandProjectService.updateFzBrandProject(modelMapper.map(data, FzBrandProjectQuery.class)),
            FzBrandProjectQuery.class);
    }

    /**
     * 根据品牌ID获取项目信息
     * 
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/queryFzBrandProjectByBrandId")
    public List<Map> queryFzBrandProjectByBrandId(HttpServletRequest request, String brandId) {
        List<Map> result = new ArrayList<>();
        Map<String, String> map = null;
        List<FzBrandProjectDTO> list = fzBrandProjectService.getFzBrandProjectByBrandId(brandId);
        for (FzBrandProjectDTO fzBrandProjectDTO : list) {
            Map<String, Object> mapReact = new HashMap();
            mapReact.put("label", fzBrandProjectDTO.getProjectName());
            mapReact.put("value", fzBrandProjectDTO.getId());
            result.add(mapReact);
        }
        return result;
    }

}
