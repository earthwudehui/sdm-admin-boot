package com.sdm.auth.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sdm.auth.dao.FzProjectAdDao;
import com.sdm.auth.model.dto.FzProjectAdDTO;
import com.sdm.auth.model.po.FzProjectAd;
import com.sdm.auth.model.query.FzProjectAdQuery;
import com.sdm.auth.service.FzProjectAdService;

@Service
public class FzProjectAdServiceImpl implements FzProjectAdService {

    @Resource
    private FzProjectAdDao fzProjectAdDao;

    @Resource
    private ModelMapper modelMapper;

    @Override
    public List<FzProjectAdDTO> getFzProjectAdListBy(FzProjectAdQuery FzProjectAdQuery) {

        return fzProjectAdDao.findAllListDTO(modelMapper.map(FzProjectAdQuery, FzProjectAdDTO.class));
    }

    @Override
    public FzProjectAdDTO saveFzProjectAd(FzProjectAdQuery FzProjectAdQuery) {

        FzProjectAd FzProjectAd = modelMapper.map(FzProjectAdQuery, FzProjectAd.class);
        FzProjectAd.setCreateDate(new Date());
        fzProjectAdDao.insert(FzProjectAd);
        return modelMapper.map(FzProjectAd, FzProjectAdDTO.class);
    }

    @Override
    public FzProjectAdDTO getFzProjectAdById(Long id) {
        return modelMapper.map(fzProjectAdDao.findById(id), FzProjectAdDTO.class);
    }

    @Override
    public FzProjectAdDTO updateFzProjectAd(FzProjectAdQuery FzProjectAdQuery) {
        FzProjectAd FzProjectAd = modelMapper.map(FzProjectAdQuery, FzProjectAd.class);

        FzProjectAd.setUpdateDate(new Date());
        FzProjectAd FzProjectAdDB = fzProjectAdDao.findById(FzProjectAd.getId());
        if (FzProjectAdDB == null) {

        }
        FzProjectAd.setUpdateDate(new Date());
        fzProjectAdDao.update(FzProjectAd);
        return modelMapper.map(FzProjectAd, FzProjectAdDTO.class);
    }

}
