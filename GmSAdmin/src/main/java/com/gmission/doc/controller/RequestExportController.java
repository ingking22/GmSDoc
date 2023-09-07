package com.gmission.doc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmission.doc.vo.RequestUploadFileTempVO;

@RestController
@RequestMapping("/DTC")
public class RequestExportController {


    @PostMapping
    public List<RequestUploadFileTempVO> selectRequestUploadFileTempList(@ModelAttribute RequestUploadFileTempVO requestUploadFileTempVO) {


        return null;
    }
}
