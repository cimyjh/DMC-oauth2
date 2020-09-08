package com.dmc.oauth2.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
public class FileApiController {

    @PostMapping("/v1/file/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        File targetFile = new File("/" + multipartFile.getOriginalFilename());
        try {
            //multipartFile.getOriginalFilename() 메소드의 결과물을 객체로 담으면 될 듯
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            e.printStackTrace();
        }
        return "success";
    }


}
