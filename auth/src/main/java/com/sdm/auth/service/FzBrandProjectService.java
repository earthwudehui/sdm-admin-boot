package com.sdm.auth.service;

import java.util.List;

import com.sdm.auth.model.dto.FzBrandProjectDTO;
import com.sdm.auth.model.query.FzBrandProjectQuery;

/**
 * 分众品牌广告投放项目管理服务
 * 
 * @author Administrator
 * @date 2020/11/27
 */
public interface FzBrandProjectService {

    /**
     * 获取 FzBrandProject列表信息
     * 
     * @param brandId
     * @return
     */
    public List<FzBrandProjectDTO> getFzBrandProjectListBy(FzBrandProjectQuery fzBrandProjectQuery);

    /**
     * 新增FzBrandProject
     * 
     * @param fzBrandProjectQuery
     * @return
     */
    public FzBrandProjectDTO saveFzBrandProject(FzBrandProjectQuery fzBrandProjectQuery);

    /**
     * id获取FzBrandProject
     * 
     * @param id
     * @return
     */
    public FzBrandProjectDTO getFzBrandProjectById(Long id);

    /**
     * 修改FzBrandProject
     * 
     * @param fzBrandProjectQuery
     * @return
     */
    public FzBrandProjectDTO updateFzBrandProject(FzBrandProjectQuery fzBrandProjectQuery);

    /**
     * brandId获取List<FzBrandProjectDTO>
     * 
     * @param id
     * @return
     */
    public List<FzBrandProjectDTO> getFzBrandProjectByBrandId(String brandId);

}
