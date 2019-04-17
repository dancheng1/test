package com.dancheng.bs.corp.dao;

import java.util.List;

import com.dancheng.bs.corp.model.CorpSummaryDetail;
import org.springframework.stereotype.Repository;

@Repository(value = "corpSummaryDetailMapper")
public interface CorpSummaryDetailMapper {

    /**
     * 根据主键删除元素
     * @param assetsno
     * @return
     */
    int deleteByPrimaryKey(String assetsno);

    /**
     * 添加元素
     * @param record
     * @return
     */
    int insert(CorpSummaryDetail record);

    int insertSelective(CorpSummaryDetail record);

    CorpSummaryDetail selectByPrimaryKey(String assetsno);

    int updateByPrimaryKeySelective(CorpSummaryDetail record);

    int updateByPrimaryKey(CorpSummaryDetail record);

    List<CorpSummaryDetail> findAll();

    List<CorpSummaryDetail> findCorpByAssType(String value);

    int updateUsesTate(String value);

    int updateUsesTate1(String value);
}