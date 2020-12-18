/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-11-27 Created
 */
package com.sdm.auth.dao;

import java.util.List;

import com.sdm.auth.model.dto.FzProjectAdDTO;
import com.sdm.auth.model.po.FzProjectAd;

public interface FzProjectAdDao {
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
    int insert(FzProjectAd record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param id
     * @return
     * @see: 需要参考的类或方法
     */
    FzProjectAd findById(Long id);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    List<FzProjectAd> findAllList(FzProjectAd record);

    /**
     * 
     * @param record
     * @return
     */
    List<FzProjectAdDTO> findAllListDTO(FzProjectAdDTO record);

    /**
     *
     * @Description 一句话描述方法用法
     * @param record
     * @return
     * @see: 需要参考的类或方法
     */
    int update(FzProjectAd record);
}