package com.sdm.auth.service.impl;

import com.sdm.auth.dao.SysUserDao;
import com.sdm.auth.dao.SysUserRoleDao;
import com.sdm.auth.model.dto.SysUserDTO;
import com.sdm.auth.model.po.SysRole;
import com.sdm.auth.model.po.SysUser;
import com.sdm.auth.model.po.SysUserRole;
import com.sdm.auth.model.query.UserQuery;
import com.sdm.auth.service.UserManageService;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Resource
    private ModelMapper modelMapper;

    @Override
    public List<SysUserDTO> getUserListByAllRole(UserQuery userQuery) {
        return sysUserDao.findAllRoleList(modelMapper.map(userQuery, SysUser.class));
    }

    @Override
    public SysUser saveSysUser(UserQuery userQuery) {
        SysUser sysUser = modelMapper.map(userQuery, SysUser.class);
        sysUser.getPassword();//加密处理
        sysUser.setCreateDate(new Date());
        sysUser.setStatus("0");
        sysUserDao.insert(sysUser);
        return sysUser;
    }

    @Override
    public SysUser getUserById(Long id){
        return sysUserDao.findById(id);
    }
    
	@Override
	public SysUser getUserByName(String name) {
		return  sysUserDao.findByName(name);
	}

    @Override
    public SysUser updateSysUser(UserQuery userQuery) {
        SysUser sysUser = modelMapper.map(userQuery, SysUser.class);
        sysUser.setUpdateDate(new Date());
        SysUser sysUserDB =sysUserDao.findById(sysUser.getId());
        if(sysUserDB==null){

        }
        sysUserDB.setUpdateDate(new Date());
        sysUserDao.update(sysUser);
        
    	SysUserRole sysUserRole = sysUserRoleDao.findByUserId(sysUserDB.getId());
    	
    	//有值（创建、修改、不动）
    	if(!StringUtils.isEmpty(userQuery.getRoleId())&&!userQuery.getRoleId().equals("null")) {
    		SysUserRole sysUserRoleNew = new SysUserRole();
    		sysUserRoleNew.setUserId(sysUserDB.getId());
    		sysUserRoleNew.setRoleId(Long.valueOf(userQuery.getRoleId()));
    		
    		if(sysUserRole==null) {//创建角色
    			sysUserRoleDao.insert(sysUserRoleNew);
    		}else {
    			if(sysUserRole.getId()!=Long.valueOf(userQuery.getRoleId())) {//修改
					sysUserRoleDao.delete(sysUserRole.getId());//删除角色
					sysUserRoleDao.insert(sysUserRoleNew);//创建新的
    			}
    		}	
		}else {//没值（删除、不动）
			if(sysUserRole!=null&&sysUserRole.getId()>0) {//删除
				sysUserRoleDao.delete(sysUserRole.getId());//删除角色
			}
		}
        return sysUser;
    }

    @Override
    public SysUser updateSysUserDisable(Long id,String status) {
        SysUser sysUser = sysUserDao.findById(id);
        sysUser.setStatus(status);
        sysUserDao.update(sysUser);
        return sysUser;
    }

    @Override
    public SysUser updateSysUserRole(Long id, List<SysRole> roleList) {
        return null;
    }

}
