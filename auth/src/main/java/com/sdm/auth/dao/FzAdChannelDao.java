/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-11-27 Created
 */
package com.sdm.auth.dao;

import java.util.List;

import com.sdm.auth.model.po.FzAdChannel;

public interface FzAdChannelDao {
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
    int insert(FzAdChannel record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    FzAdChannel findById(Long id);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List<FzAdChannel> findAllList(FzAdChannel record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(FzAdChannel record);
}