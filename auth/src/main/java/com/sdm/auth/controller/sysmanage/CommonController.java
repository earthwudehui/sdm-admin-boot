package com.sdm.auth.controller.sysmanage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sdm.auth.model.po.SysUser;
import com.sdm.auth.service.CommonService;

/**
 * 通用API
 * @author Administrator
 *
 */
@RequestMapping("/api/common")
@RestController
public class CommonController {
	
@Resource
private CommonService commonService;

    /**
     * 获取用户详细信息
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/findDictionary")
    public String queryUserById(HttpServletRequest request,String dicname) {
    	
    	Map<String,Object> result = new HashMap();
    	result.put("data",  commonService.queryDicname(dicname));
        return JSON.toJSONString(result);
    }
}
