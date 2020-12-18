package com.sdm.auth.service;

import java.util.Map;

public interface SdChannelService {

    /**
     * 获取角色字典
     * 
     * @return
     */
    public Map<String, String> getRoleMap();

    /**
     * 刷新缓存
     * 
     * @return
     */
    public void refreshRoleDicname(String dicname);
}
