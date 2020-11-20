package com.sdm.auth.service.impl;

import org.springframework.stereotype.Service;

import com.sdm.auth.model.po.SysUser;
import com.sdm.auth.model.query.UserQuery;
import com.sdm.auth.model.shiro.SysToken;
import com.sdm.auth.model.shiro.TokenGenerator;
import com.sdm.auth.service.ShiroService;
import com.sdm.auth.service.SysTokenService;
import com.sdm.auth.service.UserManageService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * @Author 大誌
 * @Date 2019/3/30 22:18
 * @Version 1.0
 */
@Service
public class ShiroServiceImpl implements ShiroService {
	
    @Resource
    private UserManageService userManageService;
    
    @Resource
    private SysTokenService sysTokenService;
        
	
	@Override
	public Map<String, Object> fakeAccountLogin(UserQuery userQuery) {
        Map<String,Object> result = new HashMap<>();
		SysUser sysUser = userManageService.getUserByName(userQuery.getName());
		 result.put("type","account");// 前端需求字段 用户密码登录
		 
         result.put("status","error");
         result.put("access","guest");// 默认权限
        if (sysUser != null) {
     
        	//密码处理	
        	String password = userQuery.getPassword();
        	// 比对密码
        	if(sysUser.getPassword().equals(password)) {
        		
        		// 重复登录
        		SysToken token =sysTokenService.findByUserId(sysUser.getId());
        		if(token==null) {
        			token = sysTokenService.createToken(sysUser.getId());
        		}
        		            	//产生token
                result.put("token",token.getToken());
        		 result.put("status","ok");
                 result.put("access",sysUser.getName());
                 result.put("coede",1000);
        	}else {//密码
                result.put("errMsg", "密码错误");
        	}
        	        	
        }else{//账号不存在
            result.put("status","error");
            result.put("access","guest");
            result.put("errMsg", "账号错误");
        }
			
		return result;
	}

    /**
     * 更新数据库的token，使前端拥有的token失效
     * 防止黑客利用token搞事情
     *
     * @param token
     */
    public void logout(String token) {

        sysTokenService.del(token);
    }

    public SysToken findByToken(String accessToken) {
        return sysTokenService.findByToken(accessToken);
    }

}
