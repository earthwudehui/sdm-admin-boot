package com.sdm.auth.service;

import java.util.List;
import java.util.Map;

import com.sdm.auth.model.dto.SysRoleDTO;
import com.sdm.auth.model.po.SysRole;

/**
 * 角色业务处理类
 */
public interface RoleManageService {

    /**
     * 获取角色数据
     * 
     * @param sysRole
     * @return
     */
    public List<SysRoleDTO> getRoleListbyAll(SysRole sysRole);

    /**
     * 获取角色数据
     * 
     * @param sysRole
     * @return
     */
    public SysRoleDTO getRoleListById(Long id);

    /**
     *
     * @param sysRole
     * @return
     */
    public SysRole saveSysRole(SysRole sysRole);

    /**
     * 获取角色字典
     * 
     * @return
     */
    public Map<String, String> getRoleMap();

    /**
     * 刷新缓存
     * 
     * @return
     */
    public void refreshRoleDicname(String dicname);

}
