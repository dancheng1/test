package com.dancheng.bs.corp.mapper;

import java.util.List;

import com.dancheng.bs.corp.model.CorpSummaryDetail;

public interface CorpSummaryDetailMapper {

    int deleteByPrimaryKey(String assetsno);

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