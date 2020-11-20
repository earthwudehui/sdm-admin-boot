package com.sdm.auth.service;

import java.util.Map;

import com.sdm.auth.model.query.UserQuery;
import com.sdm.auth.model.shiro.SysToken;

public interface ShiroService {


	/**
	 * 登录
	 * 只验证用户身份，不加载数据
	 * @param sysUser
	 * @return
	 */
	Map<String, Object>fakeAccountLogin(UserQuery userQuery);
	
     /**
      * logout
      * @param token
      */
     void logout(String token);

     /**
      * find token by token
      * @param accessToken
      * @return
      */
     SysToken findByToken(String accessToken);

}
