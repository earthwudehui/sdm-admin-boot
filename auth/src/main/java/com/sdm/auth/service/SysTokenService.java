package com.sdm.auth.service;

import java.util.Map;

import com.sdm.auth.model.shiro.SysToken;

public interface SysTokenService {
	
    /**
     * create token by userId
     * @param userId
     * @return
     */
	SysToken createToken(Long userId);

	 /**
     * 通过token查找
     * @param token
     * @return
     */
	SysToken findByToken(String token);

    /**
     * 通过userID查找
     * @param userId
     * @return
     */
    SysToken findByUserId(Long userId);
    
    /**
     * 删除token
     * @param sysToken
     * @return
     */
   void del (String token);

}
