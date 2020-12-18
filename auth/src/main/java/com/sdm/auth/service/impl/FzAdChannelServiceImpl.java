package com.sdm.auth.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.sdm.auth.dao.FzAdChannelDao;
import com.sdm.auth.model.dto.FzAdChannelDTO;
import com.sdm.auth.model.po.FzAdChannel;
import com.sdm.auth.model.query.FzAdChannelQuery;
import com.sdm.auth.service.FzAdChannelService;

@Service
public class FzAdChannelServiceImpl implements FzAdChannelService {

    @Resource
    private FzAdChannelDao fzAdChannelDao;

    @Resource
    private ModelMapper modelMapper;

    @Override
    public List<FzAdChannelDTO> getFzAdChannelListBy(FzAdChannelQuery fzAdChanneQuery) {
        List<FzAdChannel> list = fzAdChannelDao.findAllList(modelMapper.map(fzAdChanneQuery, FzAdChannel.class));
        return modelMapper.map(list, new TypeToken<List<FzAdChannelDTO>>() {}.getType());
    }

    @Override
    public FzAdChannelDTO saveFzAdChannel(FzAdChannelQuery fzAdChanneQuery) {

        FzAdChannel fzAdChannel = modelMapper.map(fzAdChanneQuery, FzAdChannel.class);
        fzAdChannel.setCreateDate(new Date());
        fzAdChannelDao.insert(fzAdChannel);
        return modelMapper.map(fzAdChannel, FzAdChannelDTO.class);
    }

    @Override
    public FzAdChannelDTO getFzAdChannelById(Long id) {
        return modelMapper.map(fzAdChannelDao.findById(id), FzAdChannelDTO.class);
    }

    @Override
    public FzAdChannelDTO updateFzAdChannel(FzAdChannelQuery fzAdChanneQuery) {
        FzAdChannel fzAdChannel = modelMapper.map(fzAdChanneQuery, FzAdChannel.class);

        fzAdChannel.setUpdateDate(new Date());
        FzAdChannel FzAdChannelDB = fzAdChannelDao.findById(fzAdChannel.getId());
        if (FzAdChannelDB == null) {

        }
        fzAdChannel.setUpdateDate(new Date());
        fzAdChannelDao.update(fzAdChannel);
        return modelMapper.map(fzAdChannel, FzAdChannelDTO.class);
    }

}
