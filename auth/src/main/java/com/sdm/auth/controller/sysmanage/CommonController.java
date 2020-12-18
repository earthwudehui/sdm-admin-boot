package com.sdm.auth.controller.sysmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sdm.auth.service.CommonDicnameService;
import com.sdm.auth.service.RoleManageService;
import com.sdm.auth.service.SdBrandService;
import com.sdm.auth.service.SdChannelService;

/**
 * 通用API
 * 
 * @author Administrator
 *
 */
@RequestMapping("/api/common")
@RestController
public class CommonController {

    @Resource
    private CommonDicnameService commonService;

    @Resource
    private SdBrandService sdBrandService;

    @Resource
    private SdChannelService sdChannelService;

    @Resource
    private RoleManageService roleManageService;

    /**
     * 获取Cache中字典信息
     * 
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/findDictionary")
    public String findDictionary(HttpServletRequest request, String dicname) {

        Map<String, Object> result = new HashMap();
        result.put("data", commonService.queryDicname(dicname));
        result.put("success", true);
        return JSON.toJSONString(result);
    }

    /**
     * 缓存获取 获取字典信息，特定格式 { label: '全部', value: 'all' }, { label: '未解决', value: 'open' }, { label: '已解决', value: 'closed'
     * }, { label: '解决中', value: 'processing' },
     * 
     * @param request
     * @param dicname
     * @return
     */
    @RequestMapping("/findDictionaryValueEnumByDicnameCache")
    public List<Map> findDictionaryValueEnumByDicnameCache(HttpServletRequest request, String dicname) {

        List<Map> result = new ArrayList<>();
        Map<String, String> map = commonService.queryDicname(dicname);
        map.forEach((k, v) -> {
            Map<String, Object> mapReact = new HashMap();
            mapReact.put("label", v);
            mapReact.put("value", k);
            result.add(mapReact);
        });
        return result;
    }

    /**
     * 强制刷新获取字典项 ，特定格式 { label: '全部', value: 'all' }, { label: '未解决', value: 'open' }, { label: '已解决', value: 'closed'
     * }, { label: '解决中', value: 'processing' },
     * 
     * @param request
     * @param dicname
     * @return
     */
    @RequestMapping("/findDictionaryValueEnumByDicname")
    public List<Map> findDictionaryValueEnumByDicname(HttpServletRequest request, String dicname) {
        List<Map> result = new ArrayList<>();
        Map<String, String> map = null;

        switch (dicname) {
            case "brand":
                map = sdBrandService.getRoleMap();
                break;
            case "role":
                map = roleManageService.getRoleMap();
                break;
            case "channel":
                map = sdChannelService.getRoleMap();
                break;
            default:
                break;
        }

        if (map != null) {
            map.forEach((k, v) -> {
                Map<String, Object> mapReact = new LinkedHashMap();
                mapReact.put("label", v);
                mapReact.put("value", k);
                // mapReact.put("isLeaf", false);// 级联菜单加载
                result.add(mapReact);
            });
        }
        return result;
    }

}
