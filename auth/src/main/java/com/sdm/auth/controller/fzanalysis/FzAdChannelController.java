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

import com.github.pagehelper.PageInfo;
import com.sdm.auth.model.dto.FzAdChannelDTO;
import com.sdm.auth.model.query.FzAdChannelQuery;
import com.sdm.auth.service.FzAdChannelService;

/**
 * 渠道信息
 * 
 * @author Administrator
 * @date 2020/12/11
 */
@RequestMapping("/api/analysis/fzAdChannel")
@RestController
public class FzAdChannelController {

    @Resource
    private FzAdChannelService fzAdChannelService;

    @Resource
    private ModelMapper modelMapper;

    @PostMapping("/queryList")
    public Map<String, Object> queryProjectList(HttpServletRequest request, @RequestBody Map<String, Object> data) {

        FzAdChannelQuery fzAdChannelQuery = modelMapper.map(data.get("params"), FzAdChannelQuery.class);

        // // 1）分页
        // PageHelper.startPage(fzAdChannelQuery.getCurrent(), fzAdChannelQuery.getPageSize());// 1,10
        // // 获取第1页，10条内容，默认查询总数count

        // 2）获取业务数据
        List<FzAdChannelDTO> list = fzAdChannelService.getFzAdChannelListBy(fzAdChannelQuery);

        // 3) 处理分页
        PageInfo<FzAdChannelDTO> page = new PageInfo<FzAdChannelDTO>(list);// PageInfo 包含分页信息

        // 5）返回值
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", list);
        // result.put("total", page.getTotal());
        // result.put("success", true);
        // result.put("pageSize", page.getPageSize());
        // result.put("current", page.getSize());
        return result;
    }

    /**
     * 新增
     * 
     * @param request
     * @param FzAdChannelQuery
     * @return
     */
    @PostMapping("/save")
    public String saveFzAdChannel(HttpServletRequest request, @RequestBody FzAdChannelQuery fzAdChannelQuery) {
        fzAdChannelService.saveFzAdChannel(fzAdChannelQuery);
        return "ok";
    }

    /**
     * 获取
     * 
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/queryFzAdChannelById")
    public FzAdChannelQuery queryFzAdChannelById(HttpServletRequest request, Long id) {
        return modelMapper.map(fzAdChannelService.getFzAdChannelById(id), FzAdChannelQuery.class);
    }

    /**
     * 修改
     * 
     * @param request
     * @param data
     * @return
     */
    @PostMapping("/update")
    public FzAdChannelQuery updateFzAdChannel(HttpServletRequest request, @RequestBody Map<String, Object> data) {

        return modelMapper.map(fzAdChannelService.updateFzAdChannel(modelMapper.map(data, FzAdChannelQuery.class)),
            FzAdChannelQuery.class);
    }

}
