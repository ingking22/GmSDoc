package com.gmission.doc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmission.doc.service.RequestExportService;
import com.gmission.doc.vo.RequestUploadFileTempVO;

@RestController
@RequestMapping("/DTC")
public class RequestExportController {

    @Autowired
    public RequestExportService requestExportService;

    @PostMapping("/RequestUploadFileTempList")
    public List<RequestUploadFileTempVO> selectRequestUploadFileTempList(@RequestBody(required=false) RequestUploadFileTempVO requestUploadFileTempVO) throws Exception {

        if(requestUploadFileTempVO == null)
            return new ArrayList<RequestUploadFileTempVO>();

        return requestExportService.selectRequestUploadFileTemp(requestUploadFileTempVO);
    }
}
