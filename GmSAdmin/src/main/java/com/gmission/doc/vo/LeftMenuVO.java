package com.gmission.doc.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LeftMenuVO {

    private String programcd;
    private String parprogramcd;
    private String programnm;
    private String programord;
    private String filenm;
    private String progparam;
    private String reguserid;
    private Timestamp regdt;
    private String moduserid;
    private Timestamp moddt;
    private String programdepth;
    private String popupfg;
    private String callfunction;
    private String usefg;

    private String authoritycd;



}
