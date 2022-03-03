package com.bing.lan.spring.mvc._04_file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 蓝兵 on 2018/4/27.
 */

@Controller
public class FileController {

  @RequestMapping("/uploadFile")
  public String uploadFile(HttpServletRequest request, Model model) throws IOException {
    // multipartFile 名字要与表单中一致 否则需要用注解

    System.out.println("upload(): ");
    MultipartHttpServletRequest defaultMultipartActionRequest = (MultipartHttpServletRequest) request;
    Map<String, MultipartFile> fileMap = defaultMultipartActionRequest.getFileMap();
    for (String key : fileMap.keySet()) {
      MultipartFile multipartFile = fileMap.get(key);
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
        String lastName = "jpg";
        String[] split = originalFilename.split("\\.");
        if (split.length >= 2) {
          lastName = split[1];
        }
        String fileName = uuid + "." + lastName;
        InputStream inputStream = multipartFile.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, fileName));

        copy(inputStream, fileOutputStream);
      }
    }

    model.addAttribute("uploadResultMsg", "上传成功, 继续上传");
    return "forward:/upload.jsp";
  }

  private void copy(InputStream inputStream, OutputStream outputStream) {
    try {
      byte[] buffer = new byte[4096];
      int n;
      long count = 0L;
      while (-1 != (n = inputStream.read(buffer))) {
        outputStream.write(buffer, 0, n);
        count += (long) n;
      }
      System.out.println("copy() count: " + count);
    } catch (Exception e) {
      System.out.println("Exception: " + e);
    } finally {
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          System.out.println("Exception: " + e);
        }
      }
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e) {
          System.out.println("Exception: " + e);
        }
      }
    }
  }

  @RequestMapping("/downloadFile")
  @ResponseBody
  public void downloadFile(HttpServletResponse response) throws IOException {
    File file = new File("E:\\workspace\\IDEA_workspace\\SpringMVCDemo\\file\\8c0e7f73-0ea3-4118-9eec-cf2f4e15c740.jpg");
    FileInputStream fileInputStream;
    fileInputStream = new FileInputStream(file);
    // 直接下载 或者弹下载窗口  否则会直接显示在浏览器中
    response.setHeader("Content-Disposition", "attachment;filename=a.jpg");
    ServletOutputStream outputStream = response.getOutputStream();
    copy(fileInputStream, outputStream);
  }
}
