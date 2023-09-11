package com.gmission.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmission.doc.mapper.CodeMapper;
import com.gmission.doc.vo.CodeVO;

@Service
public class CodeService {

    @Autowired
    private CodeMapper codeMapper;

    public List<?> selectCodeMap(CodeVO codeVO) throws Exception {
        return codeMapper.selectCodeMap(codeVO);
    }
    
}
