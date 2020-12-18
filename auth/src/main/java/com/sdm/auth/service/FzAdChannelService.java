package com.sdm.auth.service;

import java.util.List;

import com.sdm.auth.model.dto.FzAdChannelDTO;
import com.sdm.auth.model.query.FzAdChannelQuery;

/**
 * 分众投放广告所属渠道服务
 * 
 * @author Administrator
 * @date 2020/11/27
 */
public interface FzAdChannelService {
    /**
     * 获取 FzAdChannel列表信息
     * 
     * @param FzAdChannelQuery
     * @return
     */
    public List<FzAdChannelDTO> getFzAdChannelListBy(FzAdChannelQuery fzAdChannelQuery);

    /**
     * 新增FzAdChannel
     * 
     * @param FzAdChannelQuery
     * @return
     */
    public FzAdChannelDTO saveFzAdChannel(FzAdChannelQuery fzAdChannelQuery);

    /**
     * id获取FzAdChannel
     * 
     * @param id
     * @return
     */
    public FzAdChannelDTO getFzAdChannelById(Long id);

    /**
     * 修改FzAdChannel
     * 
     * @param FzAdChannelQuery
     * @return
     */
    public FzAdChannelDTO updateFzAdChannel(FzAdChannelQuery fzAdChannelQuery);
}
