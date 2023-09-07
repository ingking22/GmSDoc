package com.gmission.doc.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class FavoriteAddressVO {
    private int optionseq;
    private String addresstype;
    private String address;
    private Timestamp createdt;
}
