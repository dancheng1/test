package com.dancheng.bs.university.service;

import com.dancheng.bs.university.model.UniversityModel;
import java.util.List;

public interface UniversityService {

    /**
     * 增加大学信息
     * @param universityModel
     * @return int
     */
    int insertUniversityModel(UniversityModel universityModel);

    /**
     * 按id删除大学
     * @return int
     */
    int deleteUniversityById(UniversityModel universityModel);

    /**
     * 按id查询全部
     * @param universityModel
     * @return
     */
    UniversityModel selectById(UniversityModel universityModel);

    /**
     * 查询全部
     * @return
     */
    List<UniversityModel> selectAll();

    /**
     * 根据id修改
     * @param universityModel
     * @return
     */
    int updateById(UniversityModel universityModel);

}