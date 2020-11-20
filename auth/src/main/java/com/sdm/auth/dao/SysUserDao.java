package com.sdm.auth.dao;

import com.sdm.auth.model.dto.SysUserDTO;
import com.sdm.auth.model.po.SysUser;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserDao {
    /**
     *
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    int delete(Long id);

    /**
     *
     * @Description  一句话描述方法用法
     * @param sysUser
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SysUser sysUser);

    /**
     *
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    SysUser findById(Long id);
    
    /**
    *
    * @Description  一句话描述方法用法
    * @param id
    * @return
    * @see: 需要参考的类或方法
    */
   SysUser findByName(@Param("name")   String name);
    /**
     *
     * @Description  一句话描述方法用法
     * @param sysUser
     * @return
     * @see: 需要参考的类或方法
     */
    List<SysUser> findAllList(SysUser sysUser);

    /**
     *
     * @Description  返回用户信息角色信息
     * @param sysUser
     * @return
     * @see: 需要参考的类或方法
     */
    List<SysUserDTO> findAllRoleList(SysUser sysUser);

    /**
     *
     * @Description  一句话描述方法用法
     * @param sysUser
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SysUser sysUser);
}