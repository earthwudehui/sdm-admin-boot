/**
 * CopyRight © 2018 上海分忧. All Rights Reserved
 * 2020-11-11 Created
 */
package com.sdm.auth.model.po;

/**
 *
 * @Description: 用户角色表
 * @see: 此处填写需要参考的类
 * @version 2020年11月11日 下午 15:17:12
 * @autor 
 */
public class SysUserRole {
    private Long id;

    private Long userId;

    private Long roleId;

    /**
     * @Description  一句话描述方法用法
     * @return
     * @see: 需要参考的类或方法
     */
    public Long getId() {
        return id;
    }

    /**
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @Description  一句话描述方法用法
     * @return
     * @see: 需要参考的类或方法
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @Description  一句话描述方法用法
     * @param userId
     * @return
     * @see: 需要参考的类或方法
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @Description  一句话描述方法用法
     * @return
     * @see: 需要参考的类或方法
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @Description  一句话描述方法用法
     * @param roleId
     * @return
     * @see: 需要参考的类或方法
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}