package com.bing.lan.springMvc._04_file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by 蓝兵 on 2018/4/27.
 */

@Controller
public class FileController {

    @RequestMapping("/uploadFile")
    public String uploadFile(MultipartFile multipartFile, Model model) throws IOException {
        // multipartFile 名字要与表单中一致 否则需要用注解

        System.out.println("upload(): ");

        if (multipartFile != null) {
            String contentType = multipartFile.getContentType();
            String name = multipartFile.getName();
            String originalFilename = multipartFile.getOriginalFilename();
            long size = multipartFile.getSize();

            System.out.println("upload() contentType: " + contentType);
            System.out.println("upload() name: " + name);
            System.out.println("upload() originalFilename: " + originalFilename);
            System.out.println("upload() size: " + size);

            String dir = "E:\\workspace\\IDEA_workspace\\SpringMVCDemo\\file";
            String uuid = UUID.randomUUID().toString();
            String lastName = multipartFile.getOriginalFilename().split("\\.")[1];
            String fileName = uuid + "." + lastName;

            try {
                InputStream inputStream = multipartFile.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, fileName));

                byte[] buffer = new byte[4096];
                int n;
                long count = 0L;
                while (-1 != (n = inputStream.read(buffer))) {
                    fileOutputStream.write(buffer, 0, n);
                    count += (long) n;
                }

                System.out.println("uploadFile() count: " + count);
            } catch (Exception e) {
                e.printStackTrace();
            }


            model.addAttribute("uploadResultMsg", "上传成功, 继续上传");
        } else {
            model.addAttribute("uploadResultMsg", "请选择文件后再上传");
        }

        return "forward:/upload.jsp";
    }
}
