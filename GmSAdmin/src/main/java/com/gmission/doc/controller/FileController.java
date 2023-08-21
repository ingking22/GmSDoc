package com.gmission.doc.controller;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/File")
public class FileController {

    @PostMapping("/UploadExportFile")
    @ResponseBody
    public String requestExport(Model model) {

        return "SUCCESS";
    }


    @GetMapping("/FileDownLoadTest")
    public ResponseEntity<Resource> FileDownLoadTest() {

        HttpHeaders httpHeaders = new HttpHeaders();
        File file = new File("D:/Install/eGovFrameDev-4.1.0-Win-64bit.exe");
        FileSystemResource resource = new FileSystemResource(file);


        httpHeaders.set(HttpHeaders.LAST_MODIFIED, String.valueOf(file.lastModified()));
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment ; filename=\"%s\"", file.getName()));
        httpHeaders.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()));



        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


}
