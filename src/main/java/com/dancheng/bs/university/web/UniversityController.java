package com.dancheng.bs.university.web;

import com.alibaba.fastjson.JSON;
import com.dancheng.bs.common.json.JsonUtils;
import com.dancheng.bs.common.utils.Upload;
import com.dancheng.bs.university.model.UniversityFaceModel;
import com.dancheng.bs.university.model.UniversityModel;
import com.dancheng.bs.university.service.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "universityController")
@RequestMapping(value = "university")
public class UniversityController {

    @Resource(name = "universityServiceImpl")
    private UniversityService universityService;

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String toIndexPage(){ return "indexUniversity"; }

    @RequestMapping(value = "/insert", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String toInsertPage(){ return "insertUniversity"; }

    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String toUpdatePage(){ return "updateUniversity"; }

    @RequestMapping(value = "driverUpload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> driverUpload(@RequestParam("file") MultipartFile[] files) {
        Map result = new HashMap<String,String>();
        Upload upload = new Upload();
        String url = null;
        for(MultipartFile f : files){
            try{
                String rootPath = this.getClass().getResource("/").getPath() + "../../static/resource/";
                url = upload.uploadpic(f, rootPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(url != null){
            String urls[] = url.split("/\\.\\./\\.\\./");
            if(urls.length == 2){
                result.put("result","success");
                result.put("url",urls[1]);
            } else {
                result.put("result","fail");
                result.put("url","");
            }
        }
        return result;
    }

    /**
     * 获取所有大学信息
     * @return map
     */
    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAll(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<UniversityModel> list = universityService.selectAll();
            map.put("isSuccess", "1");  //注入结果集
            map.put("rows", JSON.parse(JSON.toJSONString(list, JsonUtils.isNullFilter)));   //以list的形式进行行显示
            map.put("total", list.size());
            map.put("msg", "查询成功！");
        } catch (Exception e) {
            System.out.println("获取全部信息失败");
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

    /**
     * 修改大学
     * @param universityFaceModel
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody UniversityFaceModel universityFaceModel){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            UniversityModel universityModel = new UniversityModel(universityFaceModel);
            int count = universityService.updateById(universityModel);
            if(count != 0){
                map.put("isSuccess", "1");
                map.put("msg", "更新成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "更新失败！");
            }
        } catch (Exception e) {
            System.out.println("修改失败");
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "更新失败！");
        }
        return map;
    }

    /**
     * 删除大学
     * @param universityFaceModel
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delete(@RequestBody UniversityFaceModel universityFaceModel){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            UniversityModel universityModel = new UniversityModel(universityFaceModel);
            int count = universityService.deleteUniversityById(universityModel);
            if(count != 0){
                map.put("isSuccess", "1");
                map.put("msg", "删除成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "删除失败！");
            }
        } catch (Exception e) {
            System.out.println("删除失败");
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "删除失败！");
        }
        return map;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(@RequestBody UniversityFaceModel universityFaceModel){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            UniversityModel universityModel = new UniversityModel(universityFaceModel);
            int count = universityService.insertUniversityModel(universityModel);
            if(count != 0){
                map.put("isSuccess", "1");
                map.put("msg", "添加成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "添加失败！");
            }
        } catch (Exception e) {
            System.out.println("添加失败");
            e.printStackTrace();
            map.put("isSuccess", "0");
            map.put("msg", "添加失败！");
        }
        return map;
    }

    @RequestMapping(value = "findById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findById(@RequestBody UniversityFaceModel universityFaceModel){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            UniversityModel universityModel = new UniversityModel(universityFaceModel);
            UniversityModel universityModelResult = universityService.selectById(universityModel);
            if(universityModelResult != null){
                map.put("isSuccess", "1");
                map.put("rows", JSON.parse(JSON.toJSONString(universityModelResult, JsonUtils.isNullFilter)));
                map.put("msg", "查询成功！");
            } else {
                map.put("isSuccess", "0");
                map.put("msg", "查询失败！");
            }
        } catch (Exception e) {
            map.put("isSuccess", "0");
            map.put("msg", "查询失败！");
        }
        return map;
    }

}