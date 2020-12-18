package com.sdm.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.sdm.auth.dao.SysRoleDao;
import com.sdm.auth.model.dto.SysRoleDTO;
import com.sdm.auth.model.po.SysRole;
import com.sdm.auth.service.CommonDicnameService;
import com.sdm.auth.service.RoleManageService;

@Service
public class RoleManageServiceImpl implements RoleManageService {

    @Resource
    private SysRoleDao sysRoleDao;

    @Resource
    private ModelMapper modelMapper;

    @Resource
    private CommonDicnameService commonDicnameService;

    @Resource
    private RoleManageService roleManageService;

    @Override
    public List<SysRoleDTO> getRoleListbyAll(SysRole sysRole) {
        List<SysRole> list = sysRoleDao.findAllList(sysRole);
        return modelMapper.map(list, new TypeToken<List<SysRoleDTO>>() {}.getType());
    }

    @Override
    public SysRole saveSysRole(SysRole sysRole) {
        int i = sysRoleDao.insert(sysRole);
        if (i == 0) {

        }
        roleManageService.refreshRoleDicname("role");
        return sysRole;
    }

    @Override
    public SysRoleDTO getRoleListById(Long id) {
        return modelMapper.map(sysRoleDao.findById(id), SysRoleDTO.class);
    }

    @Override
    public Map<String, String> getRoleMap() {
        SysRole sysRole = new SysRole();
        List<SysRole> list = sysRoleDao.findAllList(sysRole);
        Map<String, String> map = new HashMap<String, String>();
        for (SysRole sys : list) {
            map.put(sys.getId().toString(), sys.getDescription());
        }
        return map;
    }

    @Override
    public void refreshRoleDicname(String dicname) {
        commonDicnameService.refreshSysComCdeMapByDicname(dicname, roleManageService.getRoleMap());
    }
}
