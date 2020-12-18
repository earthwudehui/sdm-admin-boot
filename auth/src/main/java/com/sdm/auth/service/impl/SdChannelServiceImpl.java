package com.sdm.auth.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdm.auth.dao.SdChannelDao;
import com.sdm.auth.model.po.SdChannel;
import com.sdm.auth.service.CommonDicnameService;
import com.sdm.auth.service.SdChannelService;

@Service
public class SdChannelServiceImpl implements SdChannelService {

    @Resource
    private SdChannelDao sdChannelDao;

    @Resource
    private CommonDicnameService commonDicnameService;

    @Resource
    private SdChannelService sdChannelService;

    @Override
    public Map<String, String> getRoleMap() {
        SdChannel sdChannel = new SdChannel();
        sdChannel.setIsdelete("未删除");
        List<SdChannel> list = sdChannelDao.findAllList(sdChannel);
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (SdChannel sd : list) {
            map.put(sd.getId(), sd.getChannelname());
        }
        return map;
    }

    @Override
    public void refreshRoleDicname(String dicname) {
        commonDicnameService.refreshSysComCdeMapByDicname(dicname, sdChannelService.getRoleMap());
    }

}
