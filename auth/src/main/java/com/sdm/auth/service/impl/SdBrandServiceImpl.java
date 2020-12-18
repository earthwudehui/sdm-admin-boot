package com.sdm.auth.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdm.auth.dao.SdBrandDao;
import com.sdm.auth.model.po.SdBrand;
import com.sdm.auth.service.CommonDicnameService;
import com.sdm.auth.service.SdBrandService;

@Service
public class SdBrandServiceImpl implements SdBrandService {

    @Resource
    private SdBrandDao sdBrandDao;

    @Resource
    private CommonDicnameService commonDicnameService;

    @Resource
    private SdBrandService sdBrandService;

    @Override
    public Map<String, String> getRoleMap() {
        SdBrand sdBrand = new SdBrand();
        sdBrand.setIsdelete("未删除");
        List<SdBrand> list = sdBrandDao.findAllList(sdBrand);
        Map<String, String> map = new HashMap<String, String>();
        for (SdBrand sd : list) {
            map.put(sd.getId(), sd.getXxmc());
        }
        return map;
    }

    @Override
    public void refreshRoleDicname(String dicname) {
        commonDicnameService.refreshSysComCdeMapByDicname(dicname, sdBrandService.getRoleMap());
    }

}
