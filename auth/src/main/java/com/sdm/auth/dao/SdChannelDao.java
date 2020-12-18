/**
 * CopyRight ©2020 上海分忧. All Rights Reserved
 * 2020-12-17 Created
 */
package com.sdm.auth.dao;

import com.sdm.auth.model.po.SdChannel;
import java.util.List;

public interface SdChannelDao {
    /**
     *
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    int delete(String id);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SdChannel record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    SdChannel findById(String id);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List findAllList(SdChannel record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SdChannel record);

    /**
     *
     * @Description  一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int updateByPrimaryKeyWithBLOBs(SdChannel record);
}