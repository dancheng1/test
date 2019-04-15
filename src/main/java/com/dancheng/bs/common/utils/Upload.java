package com.dancheng.bs.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class Upload {

    public String uploadpic(MultipartFile items_pic, String url) throws Exception{//方法
        //上传图片
        System.out.println(url);
        if(items_pic != null && !items_pic.isEmpty()){
            //存储图片的物理路径
            String pic_path = url;
            //上传图片的原始名称
            String originalFilename = items_pic.getOriginalFilename();
            //新的图片名
            //uuid+扩展名
            String newFileName = UUID.randomUUID() +
                    originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(pic_path+newFileName);//新图片(新文件)

            //将内存中的文件写入磁盘
            items_pic.transferTo(newFile);
            //返回新文件的名称itemsCustom
            return pic_path + newFileName;
        }
        return null;
    }

}