package com.dancheng.bs.dao;

import com.dancheng.bs.model.UniversityModel;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository(value = "universityDao")
public interface UniversityDao {

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
    int deleteUniversityById(Integer id);

    /**
     * 按id查询全部
     * @param id
     * @return
     */
    UniversityModel selectById(Integer id);

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