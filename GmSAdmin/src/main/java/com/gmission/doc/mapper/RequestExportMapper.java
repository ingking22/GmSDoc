package com.gmission.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gmission.doc.vo.RequestUploadFileTempVO;

@Repository
@Mapper
public interface RequestExportMapper {
    void insertRequestUploadFileTemp(RequestUploadFileTempVO requestUploadFileTempVO) throws Exception;
    List<RequestUploadFileTempVO> selectRequestUploadFileTemp(RequestUploadFileTempVO requestUploadFileTempVO) throws Exception;
}
