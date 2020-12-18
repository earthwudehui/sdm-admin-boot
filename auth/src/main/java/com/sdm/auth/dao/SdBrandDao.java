/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-11-27 Created
 */
package com.sdm.auth.dao;

import java.util.List;

import com.sdm.auth.model.po.SdBrand;

public interface SdBrandDao {
    /**
     *
     * @Description 一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    int delete(String id);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int insert(SdBrand record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    SdBrand findById(String id);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List<SdBrand> findAllList(SdBrand record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(SdBrand record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int updateByPrimaryKeyWithBLOBs(SdBrand record);
}