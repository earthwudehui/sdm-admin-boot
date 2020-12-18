/**
 * CopyRight ©2020 上海分忧. All Rights Reserved
 * 2020-11-27 Created
 */
package com.sdm.auth.dao;

import com.sdm.auth.model.po.SysComCde;
import com.sdm.auth.model.po.SysComCdeKey;
import java.util.List;

public interface SysComCdeDao {
    /**
     *
     * @Description  一句话描述方法用法
     * @param key
     * @return
     * @see: 需要参考的类或方法
     */
    int delete(SysComCdeKey key);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SysComCde record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param key
     * @return
     * @see: 需要参考的类或方法
     */
    SysComCde findById(SysComCdeKey key);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List findAllList(SysComCde record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SysComCde record);
}