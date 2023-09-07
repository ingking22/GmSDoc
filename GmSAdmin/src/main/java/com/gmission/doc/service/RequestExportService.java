package com.gmission.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmission.doc.mapper.RequestExportMapper;
import com.gmission.doc.vo.RequestUploadFileTempVO;

@Service
public class RequestExportService {

    @Autowired
    private RequestExportMapper requestExportMapper;


    public void insertRequestUploadFileTemp(RequestUploadFileTempVO requestUploadFileTempVO) throws Exception
    {
        requestExportMapper.insertRequestUploadFileTemp(requestUploadFileTempVO);
    }



    public List<RequestUploadFileTempVO> selectRequestUploadFileTemp(RequestUploadFileTempVO requestUploadFileTempVO) throws Exception
    {
        return requestExportMapper.selectRequestUploadFileTemp(requestUploadFileTempVO);
    }
}
