/**
 * CopyRight © 2018 上海分忧. All Rights Reserved 2020-10-27 Created
 */
package com.sdm.auth.dao;

import java.util.List;

import com.sdm.auth.model.po.SysMenu;

public interface SysMenuDao {
    /**
     *
     * @Description 一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    int delete(Long id);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SysMenu record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    SysMenu findById(Long id);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List<SysMenu> findAllList(SysMenu record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SysMenu record);
}