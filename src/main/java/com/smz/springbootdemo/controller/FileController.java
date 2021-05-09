package com.smz.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "file")
public class FileController {

    //绝对路径，例：Linux，file.upload.path=/root/a/b/c/，则最终文件是在root/a/b/c/目录下
    @Value("${file.upload.path}")
    private String uploadPath;

    //
    @Value("${file.prefix.dir}")
    private String localEnvDir;

    @RequestMapping(path = "uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return "file not exists";
        }

        String originalFilename = file.getOriginalFilename();
        String suffixFileName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String prefixFileName = originalFilename.substring(0, originalFilename.lastIndexOf("."));

        String prefixName ;
        //如果配置文件没有定义上传路径，则目录默认是/userhome/localEnvDir/prefixDirByDate/
        if (uploadPath == null || "".equalsIgnoreCase(uploadPath)) {
            if ( localEnvDir == null || "".equalsIgnoreCase(localEnvDir) ) {
                return "you need to specified file.upload.path or file.prefix.dir in application.properties";
            } else {
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd");
                Calendar calendar = Calendar.getInstance();
                 prefixName =
                         System.getProperty("user.home") + localEnvDir + simpleDateFormat.format(calendar.getTime() ) + File.separator;
            }
        } else {
                prefixName = uploadPath;
        }

        originalFilename = prefixFileName + "_" + System.currentTimeMillis() + suffixFileName;
        File dest = new File(prefixName + originalFilename);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return  "上传文件成功！";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "上传文件失败！请联系管理员！";
        } catch (IOException e) {
            e.printStackTrace();
            return "上传文件失败！请联系管理员！";
        }
    }
}
