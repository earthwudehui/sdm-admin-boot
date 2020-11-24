package com.sdm.auth.common.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sdm.auth.model.po.SysMenu;
import com.sdm.auth.model.shiro.SysToken;

/**
 * @Description: 应用内存
 * @author Administrator
 * @date 2020/11/24
 */
public class SystemInfo {

    private static SystemInfo instance;

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
    // private Map<String, List<SComCde>> sComCdeMap = new HashMap<String, List<SComCde>>();

    static {
        instance = new SystemInfo();
        instance.init();
    }

    /**
     * 初始化方法
     * 
     * @Description 一句话描述方法用法
     * @see 需要参考的类或方法
     */
    private void init() {
        System.out.println("init SystemInfo....... ...........................................");

        // token
        sysTokenMap.clear();
        userIdTokenMap.clear();

        // 初始化角色权限信息

        System.out.println("init....... success!");
    }

    /**
     * 警告：这个函数一般不需要手工调用 重新装入系统信息，请不要随便调用
     */
    public void reLoadSystem() {
        init();
    }

    /**
     * @Description 一句话描述方法用法
     * @see 需要参考的类或方法
     */
    public static SystemInfo getSystemInfo() {
        return instance;
    }

    public Map<String, SysToken> getSysTokenMap() {
        return sysTokenMap;
    }

    public Map<Long, String> getUserIdTokenMap() {
        return userIdTokenMap;
    }
}
