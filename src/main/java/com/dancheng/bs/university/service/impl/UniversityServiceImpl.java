package com.dancheng.bs.university.service.impl;

import com.dancheng.bs.university.dao.UniversityDao;
import com.dancheng.bs.university.model.UniversityModel;
import com.dancheng.bs.university.service.UniversityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "universityServiceImpl")
public class UniversityServiceImpl implements UniversityService {

    @Resource(name = "universityDao")
    private UniversityDao universityDao;

    @Override
    public int insertUniversityModel(UniversityModel universityModel) {
        return universityDao.insertUniversityModel(universityModel);
    }

    @Override
    public int deleteUniversityById(UniversityModel universityModel) {
        return universityDao.deleteUniversityById(universityModel.getId());
    }

    @Override
    public UniversityModel selectById(UniversityModel universityModel) {
        return universityDao.selectById(universityModel.getId());
    }

    @Override
    public List<UniversityModel> selectAll() {
        return universityDao.selectAll();
    }

    @Override
    public int updateById(UniversityModel universityModel) {
        UniversityModel universityModelYuan = universityDao.selectById(universityModel.getId());
        if(universityModel.getSchoolName() == null)
            universityModel.setSchoolName(universityModelYuan.getSchoolName());
        if(universityModel.getPicLink() == null)
            universityModel.setPicLink(universityModelYuan.getPicLink());
        if(universityModel.getPicClickLink() == null)
            universityModel.setPicClickLink(universityModelYuan.getPicClickLink());
        if(universityModel.getRegistrationTime() == null)
            universityModel.setRegistrationTime(universityModelYuan.getRegistrationTime());
        if(universityModel.getRegistrationConditionLink() == null)
            universityModel.setRegistrationConditionLink(universityModelYuan.getRegistrationConditionLink());
        return universityDao.updateById(universityModel);
    }
}