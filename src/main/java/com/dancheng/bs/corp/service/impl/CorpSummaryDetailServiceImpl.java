package com.dancheng.bs.corp.service.impl;

import com.dancheng.bs.corp.dao.CorpSummaryDetailMapper;
import com.dancheng.bs.corp.model.CorpSummaryDetail;
import com.dancheng.bs.corp.service.CorpSummaryDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
@Service
public class CorpSummaryDetailServiceImpl implements CorpSummaryDetailService {

    @Resource(name = "corpSummaryDetailMapper")
    private CorpSummaryDetailMapper corpSummaryDetailMapper;


    @Override
    public CorpSummaryDetail selectByPrimaryKey(CorpSummaryDetail corpSummaryDetail) {
        return corpSummaryDetailMapper.selectByPrimaryKey(corpSummaryDetail.getAssetsno());
    }

    @Override
    public List<CorpSummaryDetail> findByAssType(CorpSummaryDetail corpSummaryDetail) {
        return corpSummaryDetailMapper.findCorpByAssType(corpSummaryDetail.getAssetstype());
    }

    @Override
    public List<CorpSummaryDetail> selectCorp() {
        return corpSummaryDetailMapper.findAll();
    }

    @Override
    public int insertCorp(CorpSummaryDetail corpSummaryDetail) {
        List<CorpSummaryDetail> list = corpSummaryDetailMapper.findAll();
        for(CorpSummaryDetail corpSummaryDetail1 : list){
            if(corpSummaryDetail.getAssetsno().equals(corpSummaryDetail1.getAssetsno())){
                return 0;
            }
        }

        return corpSummaryDetailMapper.insert(corpSummaryDetail);
    }

    @Override
    public int deleteCorp(CorpSummaryDetail corpSummaryDetail) {
        return corpSummaryDetailMapper.deleteByPrimaryKey(corpSummaryDetail.getAssetsno());
    }

    @Override
    public CorpSummaryDetail editCorp(CorpSummaryDetail corpSummaryDetail) {
        return corpSummaryDetailMapper.selectByPrimaryKey(corpSummaryDetail.getAssetsno());
    }

    @Override
    public int updateCorp(CorpSummaryDetail corpSummaryDetail) {
        return corpSummaryDetailMapper.updateByPrimaryKey(corpSummaryDetail);
    }
}
