package com.homerunball.admin.product.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/* 2024.05.xx [혁락] multipart upload 공부용 컨트롤러 */
@Controller
public class FileUploadController {

  private final String UPLOAD_DIR = "/home/ec2-user/homerunball/ext";

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
    if (file.isEmpty()) {
      model.addAttribute("message", "업로드할 파일을 선택하세요");
      return "uploadStatus";
    }

    File targetFile = new File(UPLOAD_DIR + File.separator + file.getOriginalFilename());
    try {
      file.transferTo(targetFile);
      model.addAttribute("message", "파일이 업로드 되었습니다::" + targetFile.getAbsolutePath());
    } catch (IOException e) {
      /* TODO: 추가 조치를 할까? */
      model.addAttribute("message", "파일 업로드 실패!!");
    }
    return "uploadStatus";
  }
}

