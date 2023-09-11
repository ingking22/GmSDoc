package com.gmission.doc.vo;

import lombok.Data;

@Data
public class CodeVO {

    private String codecd;
    //private String codesetcd;
    private String codenm;
    private String addcd;
    private String addnm;
    private String codeord;
    private String usefg;
    private String codedesc;
    private String reguserid;
    private String regdt;
    private String moduserid;
    private String moddt;

    private CodeSetVO codeSetVO;
}
