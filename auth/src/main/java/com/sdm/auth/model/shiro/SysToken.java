package com.sdm.auth.model.shiro;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * token实体类
 */
@Data
public class SysToken implements Serializable {

	private static final long serialVersionUID = 5068799589696142576L;

	/**
     * 用户ID
     */
    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
