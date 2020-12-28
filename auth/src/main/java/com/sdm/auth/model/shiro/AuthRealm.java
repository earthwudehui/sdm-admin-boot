package com.sdm.auth.model.shiro;

import java.time.LocalDateTime;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdm.auth.model.po.SysUser;
import com.sdm.auth.service.ShiroService;
import com.sdm.auth.service.UserManageService;

@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    @Autowired
    private UserManageService userManageService;

    @Override
    /**
     * 授权 获取用户的角色和权限
     * 
     * @param [principals]
     * @return org.apache.shiro.authz.AuthorizationInfo
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // //1. 从 PrincipalCollection 中来获取登录用户的信息
        //// SysUser sysUserr = (SysUser) principals.getPrimaryPrincipal();
        //// //Integer userId = user.getUserId();
        //// //2.添加角色和权限
        //// SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //// for (SysRole sysRole : sysUserr.getSysRoleList()) {
        //// //2.1添加角色
        //// simpleAuthorizationInfo.addRole(sysRole.getDescription());
        //// for (SysMenu sysMenu : sysRole.getSysMenuList()) {
        //// //2.1.1添加权限
        //// simpleAuthorizationInfo.addStringPermission(sysMenu.getPath());
        //// }
        //// }
        //// return simpleAuthorizationInfo;
        return null;
    }

    @Override
    /**
     * 认证 判断token的有效性(登录签发token)
     * 
     * @param [token]
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取token，既前端传入的token
        String accessToken = (String)token.getPrincipal();
        // 1. 根据accessToken，查询用户信息
        SysToken tokenEntity = shiroService.findByToken(accessToken);
        // 2. token失效
        if (tokenEntity == null || tokenEntity.getExpireTime().isBefore(LocalDateTime.now())) {
            if (tokenEntity.getExpireTime().isBefore(LocalDateTime.now())) {
                shiroService.logout(tokenEntity.getToken());
            }
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        // 3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录

        SysUser SysUser = userManageService.getUserById(tokenEntity.getUserId().longValue());
        // User user = shiroService.findByUserId(tokenEntity.getUserId());
        // 4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if (SysUser == null) {
            throw new UnknownAccountException("用户不存在!");
        }
        // 5. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(SysUser, accessToken, this.getName());
        return info;
    }
}
