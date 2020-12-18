/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-11-27 Created
 */
package com.sdm.auth.model.po;

import java.util.Date;

import lombok.Data;

/**
 *
 * @Description: 字典明细表
 * @see: 此处填写需要参考的类
 * @version 2020年11月27日 下午 17:14:49
 * @autor
 */
@Data
public class SysComCde extends SysComCdeKey {
    /**
     * 通用代码描述
     */
    private String comDesc;

    /**
     * 状态
     */
    private String comStatus;

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
}