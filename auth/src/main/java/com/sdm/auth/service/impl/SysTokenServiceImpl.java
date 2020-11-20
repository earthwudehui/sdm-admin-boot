package com.sdm.auth.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sdm.auth.common.cache.SystemInfo;
import com.sdm.auth.model.shiro.SysToken;
import com.sdm.auth.model.shiro.TokenGenerator;
import com.sdm.auth.service.SysTokenService;

@Service
public class SysTokenServiceImpl implements SysTokenService{
	
    //12小时后失效
    private final static int EXPIRE = 2;
    
    private final SystemInfo systemInfo = SystemInfo.getSystemInfo();

	
	@Override
	/**
     * 生成一个token/延期
     *@param  [userId]
     *@return Result
     */
    public SysToken createToken(Long userId) {
               
        String token = systemInfo.getUserIdTokenMap().get(userId);
        LocalDateTime now = LocalDateTime.now(); //当前时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);  //过期时间
        SysToken tokenEntity = null;
        if (token == null) {        //新增token
            //生成一个token
           token = TokenGenerator.generateValue();
           tokenEntity = new SysToken();
           tokenEntity.setUserId(userId);
            //保存token
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            systemInfo.getUserIdTokenMap().put(userId, token);//保存关系
        } else {        //延期token
            //更新token
        	tokenEntity =  systemInfo.getSysTokenMap().get(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
        }
        systemInfo.getSysTokenMap().put(token, tokenEntity);// 保存token

        return tokenEntity;
    }

	@Override
	public SysToken findByToken(String token) {

		return  systemInfo.getSysTokenMap().get(token);
	}

	@Override
	public SysToken findByUserId(Long userId) {
        return systemInfo.getSysTokenMap().get(systemInfo.getUserIdTokenMap().get(userId));
	}

	@Override
	public void del(String token) {
		SysToken sysToken = systemInfo.getSysTokenMap().get(token);
		if(sysToken!=null) {
			systemInfo.getUserIdTokenMap().remove(sysToken.getUserId());
			systemInfo.getSysTokenMap().remove(sysToken.getToken());
		}
	}

}
