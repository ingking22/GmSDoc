package com.gmission.doc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gmission.doc.service.CodeService;
import com.gmission.doc.vo.CodeVO;

@RestController
public class CodeController {

    @Autowired
    private CodeService codeService;

    public List<CodeVO> selectCodeMap(@RequestBody CodeVO codeVO) throws Exception {
        return (ArrayList<CodeVO>)codeService.selectCodeMap(codeVO);
    }
}
