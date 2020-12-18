package com.sdm.auth.common.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sdm.auth.model.po.SysMenu;
import com.sdm.auth.model.shiro.SysToken;
import com.sdm.auth.service.CommonDicnameService;

/**
 * @Description: 应用内存
 * @author Administrator
 * @date 2020/11/24
 */
@Component
public class SystemInfo {

    private static SystemInfo instance;

    @Resource
    private CommonDicnameService commonDicnameService;

    /**
     * token-Systoken 缓存
     */
    private Map<String, SysToken> sysTokenMap = new HashMap<String, SysToken>();

    /**
     * UserId-Token 缓存
     */
    private Map<Long, String> userIdTokenMap = new HashMap<Long, String>();

    /**
     * 角色权限 缓存
     */
    private Map<String, List<SysMenu>> sysMenuMap = new HashMap<String, List<SysMenu>>();

    /** 系统字典项数据 */
    private Map<String, Map<String, String>> sysComCdeMap = new HashMap<String, Map<String, String>>();

    static {
        instance = new SystemInfo();
        // instance.init();
    }

    /**
     * 初始化方法
     * 
     * @Description 一句话描述方法用法
     * @see 需要参考的类或方法
     */
    @PostConstruct
    private void init() {
        System.out.println("init SystemInfo....... 开始...........................................");

        // token
        instance.sysTokenMap.clear();
        instance.userIdTokenMap.clear();

        // 初始化角色权限信息

        // 初始化字典项
        instance.sysComCdeMap.clear();
        instance.sysComCdeMap = commonDicnameService.initSysComCdeMap();
        System.out.println("init SystemInfo.......结束 ...........................................");
    }

    /**
     * 警告：这个函数一般不需要手工调用 重新装入系统信息，请不要随便调用
     */
    public void reLoadSystem() {
        init();
    }

    /**
     * 指定dicname 刷新
     * 
     * @param dicname
     * @param map
     */
    public void refreshSysComCdeMapByDicname(String dicname, Map<String, String> map) {
        instance.sysComCdeMap.remove(dicname);
        instance.sysComCdeMap.put(dicname, map);
    }

    /**
     * @Description 一句话描述方法用法
     * @see 需要参考的类或方法
     */
    public static SystemInfo getSystemInfo() {
        return instance;
    }

    public Map<String, SysToken> getSysTokenMap() {
        return instance.sysTokenMap;
    }

    public Map<Long, String> getUserIdTokenMap() {
        return instance.userIdTokenMap;
    }

    public Map<String, Map<String, String>> getSysComCdeMap() {
        return instance.sysComCdeMap;
    }
}
