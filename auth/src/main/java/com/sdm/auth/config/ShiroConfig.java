package com.sdm.auth.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sdm.auth.config.filter.shiro.AuthFilter;
import com.sdm.auth.model.shiro.AuthRealm;

/**
 * Shiro 用户认证
 * 
 * @author Administrator
 * 
 */
@Configuration
public class ShiroConfig {

    /**
     * 然后配置SecurityManager Bean SecurityManager为Shiro的安全管理器，管理着所有Subject； AuthRealm 自定义实现Realm（AuthorizingRealm）
     * 
     * @param authRealm
     * @return
     */
    @Bean("securityManager")
    public SecurityManager securityManager(AuthRealm authRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        securityManager.setRememberMeManager(null);

        // 关闭 ShiroDAO 功能
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        // 不需要将 Shiro Session 中的东西存到任何地方（包括 Http Session 中）
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        // 设置securityManager
        shiroFilter.setSecurityManager(securityManager);

        // 登录的url
        shiroFilter.setLoginUrl("/api/frameadmin/account");
        // 登录成功后跳转的url
        // shiroFilter.setSuccessUrl("/");
        // 未授权url
        shiroFilter.setUnauthorizedUrl("/401");

        Map<String, Filter> filters = new HashMap<>();
        filters.put("auth", new AuthFilter());
        shiroFilter.setFilters(filters);

        // auth过滤（需要注意的是filterChain基于短路机制，即最先匹配原则）

        Map<String, String> filterMap = new LinkedHashMap<>();
        // anno匿名访问 auth验证
        // filterMap.put("/webjars/**", "anon");
        // filterMap.put("/druid/**", "anon");
        filterMap.put("/api/frameadmin/account", "anon");// 登录
        filterMap.put("/api/frameadmin/captcha", "anon");// 验证码
        filterMap.put("/api/frameadmin/outLogin", "anon");// 退出
        // filterMap.put("/api/common/findDictionary", "anon");// 字典

        // filterMap.put("/swagger/**", "anon");
        // filterMap.put("/v2/api-docs", "anon");
        // filterMap.put("/swagger-ui.html", "anon");
        // filterMap.put("/swagger-resources/**", "anon");
        // filterMap.put("/doc.html", "anon");
        // 除了以上路径，其他都需要权限验证

        // druid数据源监控页面不拦截
        filterMap.put("/druid/**", "anon");

        // // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了 （框架特殊逻辑需要操作的不用该方式）
        // filterMap.put("/logout", "logout");
        filterMap.put("/**", "auth");// authc 会跳转到login.jsp

        shiroFilter.setFilterChainDefinitionMap(filterMap);

        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}
