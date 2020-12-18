/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-11-27 Created
 */
package com.sdm.auth.model.po;

import java.util.Date;

import lombok.Data;

/**
 *
 * @Description: 字典类型表
 * @see: 此处填写需要参考的类
 * @version 2020年11月27日 下午 17:15:07
 * @autor
 */
@Data
public class SysComTyp {
    /**
     * 通用代码类别
     */
    private String comTyp;

    /**
     * 类别描述
     */
    private String comTypDesc;

    /**
     * 状态
     */
    private String comStatus;

    /**
     * 系统内部数据 0:是（内部加载）| 1不是（配置表加载）
     */
    private String comSysInd;

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