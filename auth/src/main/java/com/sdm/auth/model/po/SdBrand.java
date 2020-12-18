/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-11-27 Created
 */
package com.sdm.auth.model.po;

import lombok.Data;

/**
 *
 * @Description: 品牌
 * @see: 此处填写需要参考的类
 * @version 2020年11月27日 下午 17:27:11
 * @autor
 */
@Data
public class SdBrand {
    private String id;

    /**
     * 和ID一致
     */
    private String chinauniversityid;

    /**
     * 品牌标识
     */
    private String xxdm;

    /**
     * 品牌名称
     */
    private String xxmc;

    /**
     * 品牌logo
     */
    private String xxywmc;

    /**
     * 是否删除：已删除,未删除
     */
    private String isdelete;
}