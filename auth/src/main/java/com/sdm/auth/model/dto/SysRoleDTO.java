/**
 * 2020-10-27 Created
 */
package com.sdm.auth.model.dto;

import lombok.Data;

/**
 *
 * @Description: 角色表
 * @see: 此处填写需要参考的类
 * @version 2020年10月27日 下午 15:33:29
 * @autor 
 */
@Data
public class SysRoleDTO {
    private Long id;

    /**
     * 角色编码
     */
    private String role;

    /**
     * 描述
     */
    private String description;


}