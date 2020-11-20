package com.sdm.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdm.auth.model.dto.SysRoleDTO;
import com.sdm.auth.model.po.SysRole;
import com.sdm.auth.service.CommonService;
import com.sdm.auth.service.RoleManageService;

@Service
public class CommonServiceImpl implements CommonService{

	@Resource
	private RoleManageService roleManageService;
	
	@Override
	public Map<String, String> queryDicname(String dicname) {
		
		//redis获取字段缓存
		SysRole sysRole = new SysRole();
		sysRole.setId(Long.getLong(dicname));
		List<SysRoleDTO> sysRoleDTOList =roleManageService.getRoleListbyAll(sysRole);
		Map<String, String> map = new HashMap<String, String>();
		for (SysRoleDTO sysRoleDTO : sysRoleDTOList) {
			map.put(sysRoleDTO.getId().toString(), sysRoleDTO.getDescription());
		}
	return map;
	}
}
