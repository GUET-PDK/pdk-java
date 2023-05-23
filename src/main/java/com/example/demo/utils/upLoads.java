package com.example.demo.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName upLoads
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 16:40
 * @Version 1.0
 **/
@Service
public class upLoads {

    public String upLoad(MultipartFile file, String upImagePath, String getImagePath){


        System.out.println("======="+upImagePath);
        String filename = file.getOriginalFilename();
        String filename1 = System.currentTimeMillis()+"."+filename.substring(filename.lastIndexOf(".")+1);

        File image = new File(upImagePath,filename1);

        if(!image.exists()){
            image.mkdirs();    //如果该路径不存在就新建该路径
        }
        //往数据流写入文件对象
        try{
            file.transferTo(image);
        }catch (IOException e){
            e.printStackTrace();
//            如果写入失败直接返回空
            return null;
        }
        return getImagePath+filename1;
    }



}
