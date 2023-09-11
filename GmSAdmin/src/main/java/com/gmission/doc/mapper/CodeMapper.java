package com.gmission.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gmission.doc.vo.CodeVO;

@Mapper
public interface CodeMapper {

    List<?> selectCodeMap(CodeVO codeVO) throws Exception;

}
