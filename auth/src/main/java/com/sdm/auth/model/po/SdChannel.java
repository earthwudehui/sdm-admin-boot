/**
 * CopyRight ©2020 上海分忧. All Rights Reserved 2020-12-17 Created
 */
package com.sdm.auth.model.po;

import java.util.Date;

import lombok.Data;

/**
 *
 * @Description: 渠道
 * @see: 此处填写需要参考的类
 * @version 2020年12月17日 下午 17:34:01
 * @autor
 */
@Data
public class SdChannel {
    /**
     * 主键
     */
    private String id;

    /**
     * 渠道名称
     */
    private String channelname;

    /**
     * 访问人数
     */
    private Integer uv;

    /**
     * 访问次数
     */
    private Integer pv;

    /**
     * 注册新用户数
     */
    private Integer reguserv;

    /**
     * 转发人次
     */
    private Integer forwarduv;

    /**
     * 转发次数
     */
    private Integer forwardv;

    /**
     * 渠道码名称
     */
    private String indexpagecodename;

    /**
     * 渠道首页分享码
     */
    private String indexpagecode;

    /**
     * 能否删除：能、否
     */
    private String deleteenable;

    /**
     * 商品副标题
     */
    private String exp1;

    /**
     * 扩展2
     */
    private String exp2;

    /**
     * 扩展3
     */
    private String exp3;

    /**
     * 扩展4
     */
    private String exp4;

    /**
     * 扩展5
     */
    private String exp5;

    /**
     * 扩展日期1
     */
    private Date exdate1;

    /**
     * 扩展日期2
     */
    private Date exdate2;

    /**
     * 扩展日期3
     */
    private Date exdate3;

    /**
     * 是否删除：已删除,未删除
     */
    private String isdelete;

    private String createuser;

    /**
     * 创建时间
     */
    private Date createdate;

    private String modifyuser;

    private Date modifydate;

    /**
     * 渠道说明
     */
    private String channeldesc;

}