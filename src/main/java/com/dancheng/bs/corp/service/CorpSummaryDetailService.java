package com.dancheng.bs.corp.service;

import com.dancheng.bs.corp.model.CorpSummaryDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
public interface CorpSummaryDetailService {

    /**
     * 查询公司资产By_id
     * @param corpSummaryDetail
     * @return
     */
    public CorpSummaryDetail selectByPrimaryKey(CorpSummaryDetail corpSummaryDetail);

    /**
     * 根据类别查询资产信息
     * @param corpSummaryDetail
     * @return
     */
    public List<CorpSummaryDetail> findByAssType(CorpSummaryDetail corpSummaryDetail);

    /**
     * 查询公司全部资产
     * @return
     */
    public List<CorpSummaryDetail> selectCorp();

    /**
     * 新增公司资产
     * @param corpSummaryDetail
     * @return
     */
    public int insertCorp(CorpSummaryDetail corpSummaryDetail);

    /**
     * 删除公司资产信息
     * @param corpSummaryDetail
     * @return
     */
    public int deleteCorp(CorpSummaryDetail corpSummaryDetail);

    /**
     * 回显公司资产
     * @param corpSummaryDetail
     * @return
     */
    public CorpSummaryDetail editCorp(CorpSummaryDetail corpSummaryDetail);

    /**
     * 修改资产信息
     * @param corpSummaryDetail
     * @return
     */
    public int updateCorp(CorpSummaryDetail corpSummaryDetail);
}
