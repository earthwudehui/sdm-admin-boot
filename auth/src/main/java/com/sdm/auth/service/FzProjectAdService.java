package com.sdm.auth.service;

import java.util.List;

import com.sdm.auth.model.dto.FzProjectAdDTO;
import com.sdm.auth.model.query.FzProjectAdQuery;

/**
 * 分众广告投放项目所属广告服务
 * 
 * @author Administrator
 * @date 2020/11/27
 */
public interface FzProjectAdService {
    /**
     * 获取 FzProjectAd列表信息
     * 
     * @param FzProjectAdQuery
     * @return
     */
    public List<FzProjectAdDTO> getFzProjectAdListBy(FzProjectAdQuery FzProjectAdQuery);

    /**
     * 新增FzProjectAd
     * 
     * @param FzProjectAdQuery
     * @return
     */
    public FzProjectAdDTO saveFzProjectAd(FzProjectAdQuery FzProjectAdQuery);

    /**
     * id获取FzProjectAd
     * 
     * @param id
     * @return
     */
    public FzProjectAdDTO getFzProjectAdById(Long id);

    /**
     * 修改FzProjectAd
     * 
     * @param FzProjectAdQuery
     * @return
     */
    public FzProjectAdDTO updateFzProjectAd(FzProjectAdQuery FzProjectAdQuery);
}
