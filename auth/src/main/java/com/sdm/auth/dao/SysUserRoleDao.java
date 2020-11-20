package com.sdm.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sdm.auth.model.po.SysUserRole;

public interface SysUserRoleDao {
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
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SysUserRole record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    SysUserRole findById(Long id);
    
    /**
     * 根据UserId 获取角色
     * @param userId
     * @return
     */
    SysUserRole findByUserId(@Param("userId") Long userId);


    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List<SysUserRole> findAllList(SysUserRole record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SysUserRole record);
}