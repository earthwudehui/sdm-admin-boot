/**
 * CopyRight ©2020 上海分忧. All Rights Reserved
 * 2020-11-27 Created
 */
package com.sdm.auth.dao;

import com.sdm.auth.model.po.SysComTyp;
import java.util.List;

public interface SysComTypDao {
    /**
     *
     * @Description  一句话描述方法用法
     * @param comTyp
     * @return
     * @see: 需要参考的类或方法
     */
    int delete(String comTyp);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SysComTyp record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param comTyp
     * @return
     * @see: 需要参考的类或方法
     */
    SysComTyp findById(String comTyp);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List findAllList(SysComTyp record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SysComTyp record);
}