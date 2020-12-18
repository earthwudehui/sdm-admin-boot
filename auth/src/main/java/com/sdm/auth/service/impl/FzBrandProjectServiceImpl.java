package com.sdm.auth.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.sdm.auth.dao.FzBrandProjectDao;
import com.sdm.auth.model.dto.FzBrandProjectDTO;
import com.sdm.auth.model.po.FzBrandProject;
import com.sdm.auth.model.query.FzBrandProjectQuery;
import com.sdm.auth.service.FzBrandProjectService;

@Service
public class FzBrandProjectServiceImpl implements FzBrandProjectService {

    @Resource
    private FzBrandProjectDao fzBrandProjectDao;

    @Resource
    private ModelMapper modelMapper;

    @Override
    public List<FzBrandProjectDTO> getFzBrandProjectListBy(FzBrandProjectQuery fzBrandProjectQuery) {
        return fzBrandProjectDao.findAllListDTO(modelMapper.map(fzBrandProjectQuery, FzBrandProjectDTO.class));
    }

    @Override
    public FzBrandProjectDTO saveFzBrandProject(FzBrandProjectQuery fzBrandProjectQuery) {

        FzBrandProject fzBrandProject = modelMapper.map(fzBrandProjectQuery, FzBrandProject.class);
        fzBrandProject.setCreateDate(new Date());
        fzBrandProjectDao.insert(fzBrandProject);
        return modelMapper.map(fzBrandProject, FzBrandProjectDTO.class);
    }

    @Override
    public FzBrandProjectDTO getFzBrandProjectById(Long id) {
        return modelMapper.map(fzBrandProjectDao.findById(id), FzBrandProjectDTO.class);
    }

    @Override
    public FzBrandProjectDTO updateFzBrandProject(FzBrandProjectQuery fzBrandProjectQuery) {
        FzBrandProject fzBrandProject = modelMapper.map(fzBrandProjectQuery, FzBrandProject.class);

        fzBrandProject.setUpdateDate(new Date());
        FzBrandProject fzBrandProjectDB = fzBrandProjectDao.findById(fzBrandProject.getId());
        if (fzBrandProjectDB == null) {

        }
        fzBrandProject.setUpdateDate(new Date());
        fzBrandProjectDao.update(fzBrandProject);
        return modelMapper.map(fzBrandProject, FzBrandProjectDTO.class);
    }

    @Override
    public List<FzBrandProjectDTO> getFzBrandProjectByBrandId(String brandId) {
        FzBrandProject fzBrandProject = new FzBrandProject();
        fzBrandProject.setBrandId(brandId);
        return modelMapper.map(fzBrandProjectDao.findAllList(fzBrandProject),
            new TypeToken<List<FzBrandProjectDTO>>() {}.getType());
    }

}
