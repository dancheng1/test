package com.dancheng.bs.corp.web;

import com.alibaba.fastjson.JSON;
import com.dancheng.bs.common.json.JsonUtils;
import com.dancheng.bs.corp.model.CorpSummaryDetail;
import com.dancheng.bs.corp.service.CorpSummaryDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
@Controller
@RequestMapping(value ="corp")
public class CorpSummaryDetailController {

    @Resource(name = "corpSummaryDetailServiceImpl")
    private CorpSummaryDetailService corpSummaryDetailService;

    @RequestMapping(method = RequestMethod.GET)
    public String toPage(HttpServletRequest request,HttpServletResponse response){return  "corp/toPage";}
    @RequestMapping( value = "select",method =  RequestMethod.GET)
    public String select(HttpServletRequest request,HttpServletResponse response){return  "corp/selectCorp";}
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String update(HttpServletRequest request,HttpServletResponse response){return "corp/insertCorp";};

    /**
     * 查询公司资产By_id
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "selectByPrimaryKey" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectByPrimaryKey (@RequestBody CorpSummaryDetail corpSummaryDetail){
        Map<String, Object> map = new HashMap<>();
        try {
            CorpSummaryDetail corpSummaryDetailResp = corpSummaryDetailService.selectByPrimaryKey(corpSummaryDetail);
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(corpSummaryDetailResp, JsonUtils.isNullFilter)));   //获取信息
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        }catch (Exception e){
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 根据资产类别查询资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "findByAssType" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findByAssType (@RequestBody CorpSummaryDetail corpSummaryDetail){
        Map<String, Object> map = new HashMap<>();
        try {
            List<CorpSummaryDetail> list = corpSummaryDetailService.findByAssType(corpSummaryDetail);
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
            map.put("total", list.size());  //对list的数量进行汇总
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 查询公司全部资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "selectCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> selectCorp(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<CorpSummaryDetail> list = corpSummaryDetailService.selectCorp();
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
            map.put("total", list.size());  //对list的数量进行汇总
            map.put("msg", "查询成功！");    //如果上述执行成功     提示成功信息
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 新增公司资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "insertCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertCorp(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = corpSummaryDetailService.insertCorp(corpSummaryDetail);   //定义一个count   获取将要插入的数据
            if (count != 0) {
                map.put("isSuccess", "1");
                map.put("msg", "保存成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "保存失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "保存失败！");
        }
        return map;
    }

    /**
     * 删除公司资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "deleteCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteCorp(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = corpSummaryDetailService.deleteCorp(corpSummaryDetail);
            if (count != 0) {
                map.put("isSuccess", "1");
                map.put("msg", "删除成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "删除失败！");
        }
        return map;
    }

    /**
     * 回显公司资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "editCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editSys(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            CorpSummaryDetail corpSummaryDetailResp = corpSummaryDetailService.editCorp(corpSummaryDetail);
            map.put("isSuccess", "1");
            map.put("rows", JSON.parse(JSON.toJSONString(corpSummaryDetailResp, JsonUtils.isNullFilter)));
            map.put("msg", "查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 更新公司资产
     * @param corpSummaryDetail
     * @return
     */
    @RequestMapping(value = "updateCorp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateCorp(@RequestBody CorpSummaryDetail corpSummaryDetail) {
        Map<String, Object> map = new HashMap<>();
        try {
            int count = corpSummaryDetailService.updateCorp(corpSummaryDetail);
            if (count != 0) {
                map.put("isSuccess", "1");
                map.put("msg", "更新成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "更新失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "更新失败！");
        }
        return map;
    }
}

