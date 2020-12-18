/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-12-08 Created
 */
package com.sdm.auth.model.dto;

import java.util.Date;

import lombok.Data;

/**
 *
 * @Description: 投放项目所属广告信息表
 * @see: 此处填写需要参考的类
 * @version 2020年12月08日 下午 15:43:48
 * @autor
 */
@Data
public class FzProjectAdDTO {
    private Long id;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 上刊广告名称
     */
    private String adName;

    /**
     * 广告状态 0 正常| 1 禁用
     */
    private String status;

    /**
     * 创建人ID
     */
    private String createBy;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 最后更新人ID
     */
    private String updateBy;

    /**
     * 最后更新时间
     */
    private Date updateDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 图片地址
     */
    private String pictureUrl;

    /**
     * 品牌名称
     */
    private String xxmc;

    /**
     * 品牌名称
     */
    private String projectName;

}