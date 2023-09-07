package com.gmission.doc.vo;

import lombok.Data;

@Data
public class RequestUploadFileTempVO {
    private String tempfileid;
    private String seq;
    private String reqexpseq;
    private String filepath;
    private String filename;
    private int filesize;
    private String createdt;
}
