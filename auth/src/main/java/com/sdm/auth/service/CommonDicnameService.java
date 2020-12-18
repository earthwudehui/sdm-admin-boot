package com.sdm.auth.service;

import java.util.List;
import java.util.Map;

public interface CommonDicnameService {

    /**
     * 获取字典
     * 
     * @param dicname
     * @return
     */
    public Map<String, String> queryDicname(String dicname);

    /**
     * 获取字典
     * 
     * @param dicname
     * @return
     */
    public Map<String, Map<String, String>> queryMapDicname(List<String> dicnameList);

    /**
     * 获取字典
     * 
     * @param dicname
     * @return
     */
    public Map<String, Map<String, String>> initSysComCdeMap();

    /**
     * 指定字典刷新
     * 
     * @param dicname
     * @return
     */
    public void refreshSysComCdeMapByDicname(String dicname, Map<String, String> map);

    /**
     * 刷新字典
     * 
     * @param dicname
     * @return
     */
    public void refreshSysComCdeMap();

}
