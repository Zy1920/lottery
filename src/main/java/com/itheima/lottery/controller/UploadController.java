package com.itheima.lottery.controller;

import com.itheima.lottery.bean.User;
import com.itheima.lottery.service.UserService;
import com.itheima.lottery.utils.UploadUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/30  18:59
 */
@Controller
public class UploadController {

    @Autowired
    private UserService userService;

    @PostMapping("/upload")
    public String upload(MultipartFile wenjian, String username, HttpSession session) throws IOException {
        System.out.println(wenjian.getName());
        System.out.println(wenjian.getOriginalFilename());
        System.out.println(username);

        //InputStream is = wenjian.getInputStream();
        //解决文件可能重名的问题
        String uuidName = UploadUtils.getUUIDName(wenjian.getOriginalFilename());
        System.out.println(uuidName);

        //生成一个随机目录
        String uuidDir = UploadUtils.getDir();

        File fileDir = new File("D:/test"+uuidDir);
        if (! fileDir.exists()){
            fileDir.mkdirs();
        }
        File file = new File(fileDir, uuidName);
        //文件copy方式一
        /*FileOutputStream fos = new FileOutputStream(file);
        IOUtils.copy(is,fos);
        is.close();
        fos.close();*/
        //文件转移方式二
        wenjian.transferTo(file);

        String savePath=uuidDir+"/"+uuidName;

        User user= (User) session.getAttribute("user");
        user.setHeadimg(savePath);
        userService.update(user);
        return "redirect:/user/mine";
    }


    @Autowired
    private ResourceLoader resourceLoader;
    @GetMapping("/get/{dir1}/{dir2}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> get(@PathVariable String dir1,@PathVariable String dir2,@PathVariable String filename){
        Path path=Paths.get("D:/test"+"/"+dir1+"/"+dir2,filename);
        Resource resource = resourceLoader.getResource("file:" + path.toString());
        return ResponseEntity.ok(resource);
    }

}
