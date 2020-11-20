package com.sdm.auth.controller.sysmanage;

import com.alibaba.fastjson.JSON;
import com.sdm.auth.common.utils.TokenUtil;
import com.sdm.auth.model.po.SysUser;
import com.sdm.auth.model.query.UserQuery;
import com.sdm.auth.service.ShiroService;
import com.sdm.auth.service.UserManageService;

import org.apache.shiro.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 框架管理类
 */
@RequestMapping("/api/frameadmin")
@RestController
public class FrameAdminController {
	
    @Resource
    private ModelMapper modelMapper;
	
    @Resource
    private UserManageService userManageService;
        
    @Resource
    private  ShiroService shiroService;

    /**
     * 验证码
     * @return
     */
    @RequestMapping("/captcha")
    @ResponseBody
    public String getFakeCaptcha() {
        System.out.println("captcha");

        return "Hello World!!!!!!!!" ;
    }


    /**
     *  ant.d.pro  登录请求
     * @param request
     * @return
     */
    @PostMapping ("/account")
    public  String  fakeAccountLogin(HttpServletRequest request,@RequestBody Map<String, String> date) {

        UserQuery userQuery= modelMapper.map(date, UserQuery.class);
        userQuery.setName(date.get("username"));
        Map<String,Object> result = shiroService.fakeAccountLogin(userQuery);
        
        return JSON.toJSONString(result);
    }

    /**
     *  ant.d.pro  退出请求
     * @param request
     * @return
     */
    @RequestMapping ("/outLogin")
    public  String  outLogin(HttpServletRequest request) {
    	String token = TokenUtil.getRequestToken((HttpServletRequest) request);        
    	shiroService.logout(token);
        return "ok";
    }

    /**
     * 获取登录用户信息
     * @param request
     * @return
     */
    @RequestMapping ("/currentUser")
    public  String  currentUser(HttpServletRequest request) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();


        Map<String, Object> result = new HashMap<String, Object>();

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("userid", user.getId());
        data.put("access", "admin");
        data.put("name", user.getRealName());
        data.put("avatar", "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");

        /**
         {
         path: '/welcome',
         name: 'welcome',
         icon: 'smile',
         component: './Welcome',
         },
         {
         path: '/admin',    // 路径
         name: 'admin',
         icon: 'crown',     // 图标
         access: 'canAdmin',  // 权限
         component: './Admin',  //配置 location 和 path 匹配后用于渲染的 React 组件路径。可以是绝对路径，也可以是相对路径，如果是相对路径，会从 src/pages 开始找起。
         routes: [             //配置子路由，通常在需要为多个路径增加 layout 组件时使用。
         {
         path: '/admin/sub-page',
         name: 'sub-page',
         icon: 'smile',
         component: './Welcome',
         },
         ],
         },
         {
         name: 'list.table-list',
         icon: 'table',
         path: '/list',
         component: './ListTableList',
         },

         {
         name: '分析页',
         icon: 'smile',
         path: '/dashboardanalysis',
         component: './DashboardAnalysis',
         },
         */
        List<Map<String, Object>> list = new ArrayList<>();

        //1）登录路由
        Map<String, Object> resultLogin = new HashMap<String, Object>();
        resultLogin.put("path","/user");
        resultLogin.put("layout","false");

        List<Map<String, Object>> listLogin = new ArrayList<>();

        Map<String, Object> resultLoginChildren = new HashMap<String, Object>();
        resultLoginChildren.put("name","login");
        resultLoginChildren.put("path","user/login");
        resultLoginChildren.put("component","./user/login");
        listLogin.add(resultLoginChildren);
        resultLogin.put("routes",listLogin);
        list.add(resultLogin);

        // 2)首页
        Map<String, Object> resultfirst = new HashMap<String, Object>();
        resultfirst.put("path","/");
        resultfirst.put("redirect","/welcome");
        list.add(resultfirst);

        // 3）功能菜单
        // 3.1
        Map<String, Object> resultbuz1 = new HashMap<String, Object>();
        resultbuz1.put("path","/welcome");
        resultbuz1.put("name","欢迎");
        resultbuz1.put("icon","smile");
        resultbuz1.put("component","./Welcome");
        list.add(resultbuz1);

        // 3.2
        Map<String, Object> resultbuz2 = new HashMap<String, Object>();
        resultbuz2.put("path","/resmanage");
        resultbuz2.put("name","资源管理");
//        resultbuz2.put("icon","crown");
        resultbuz2.put("access","canAdmin");//权限

        List<Map<String, Object>> buzlist2 = new ArrayList<>();

        Map<String, Object>buzChildren21 = new HashMap<String, Object>();
        buzChildren21.put("name","用户管理");
        buzChildren21.put("path","/resmanage/usermanage");
        buzChildren21.put("component","./resmanage/usermanage");
        buzlist2.add(buzChildren21);

        Map<String, Object>buzChildren22 = new HashMap<String, Object>();
        buzChildren22.put("name","角色管理");
        buzChildren22.put("path","/resmanage/rolemanage");
        buzChildren22.put("component","./resmanage/rolemanage");
        buzlist2.add(buzChildren22);

        Map<String, Object>buzChildren23 = new HashMap<String, Object>();
        buzChildren23.put("name","菜单管理");
        buzChildren23.put("path","/resmanage/resmanage");
        buzChildren23.put("component","./ListTableList");
        buzlist2.add(buzChildren23);


        resultbuz2.put("routes",buzlist2);
        list.add(resultbuz2);


        //4）404
        Map<String, Object> result404 = new HashMap<String, Object>();
        result404.put("component","./404");
        list.add(result404);

//
//        Map<String, Object> resultData = new HashMap<String, Object>();
//        resultData.put("routes",list);
//        data.put("menudata",resultData);
//        result.put("data",data);
//        result.put("success",true);

        System.out.println(result);
        return JSON.toJSONString(data);
    }

}
