package com.sdm.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdm.auth.common.cache.SystemInfo;
import com.sdm.auth.service.CommonDicnameService;
import com.sdm.auth.service.RoleManageService;
import com.sdm.auth.service.SdBrandService;

/**
 * 通用字典服务--内部缓存
 * 
 * @author Administrator
 * @date 2020/11/27
 */
@Service
public class CommonDicnameServiceImpl implements CommonDicnameService {

    private final SystemInfo systemInfo = SystemInfo.getSystemInfo();

    @Resource
    private RoleManageService roleManageService;

    @Resource
    private SdBrandService sdBrandService;

    @Override
    public Map<String, String> queryDicname(String dicname) {
        return systemInfo.getSysComCdeMap().get(dicname);
    }

    @Override
    public Map<String, Map<String, String>> queryMapDicname(List<String> dicnameList) {
        Map<String, Map<String, String>> sysComCdeMap = new HashMap<String, Map<String, String>>();
        for (String dicname : dicnameList) {
            Map<String, String> map = systemInfo.getSysComCdeMap().get(dicname);
            if (map != null) {
                sysComCdeMap.put(dicname, map);
            }
        }
        return sysComCdeMap;
    }

    @Override
    public Map<String, Map<String, String>> initSysComCdeMap() {
        Map<String, Map<String, String>> sysComCdeMap = new HashMap<String, Map<String, String>>();
        sysComCdeMap.put("role", roleManageService.getRoleMap());// 加载角色字典
        sysComCdeMap.put("brand", sdBrandService.getRoleMap());// 加载品牌字典
        return sysComCdeMap;
    }

    @Override
    public void refreshSysComCdeMapByDicname(String dicname, Map<String, String> map) {
        systemInfo.refreshSysComCdeMapByDicname(dicname, map);
    }

    @Override
    public void refreshSysComCdeMap() {
        systemInfo.reLoadSystem();
    }
}
